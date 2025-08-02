import time
from opcua import Client
import paho.mqtt.client as mqtt
import json

# OPC UA-Einstellungen
OPC_UA_SERVER = "opc.tcp://172.16.54.1:4840"

TEMPERATURE_HLT = 'ns=3;s="I_Temp_3";datatype=Double'
TEMPERATURE_MLT_OUTSIDE = 'ns=3;s="I_Temp_2";datatype=Double'
TEMPERATURE_MLT_INSIDE = 'ns=3;s="Temp_MLT_FloWave";datatype=Double'
TEMPERATURE_BOIL = 'ns=3;s="I_Temp_1";datatype=Double'
TEMPERATURE_PV1 = 'ns=3;s="Daten_Bauteile_DB"."BauteileDaten"."FLOWave"."Temperature";datatype=Double'
FLOW_PV1 = 'ns=3;s="Daten_Bauteile_DB"."BauteileDaten"."FLOWave"."VolumeFlow";datatype=Double'


# MQTT-Einstellungen
MQTT_BROKER = "192.168.188.26"  # IP-Adresse des Raspberry Pi 
MQTT_PORT = 1883
MQTT_TOPIC = "brauanlage/data"

def read_opcua_data(opc_client):
    """
    Liest Daten von der SPS ueber OPC UA.
    
    """
    try:
        # Knoten abrufen und Werte auslesen
        temp_hlt = opc_client.get_node(TEMPERATURE_HLT).get_value()
        temp_mlt_outside = opc_client.get_node(TEMPERATURE_MLT_OUTSIDE).get_value()
        temp_mlt_inside = opc_client.get_node(TEMPERATURE_MLT_INSIDE).get_value()
        temp_boil = opc_client.get_node(TEMPERATURE_BOIL).get_value()
        temp_pv1 = opc_client.get_node(TEMPERATURE_PV1).get_value()
        fl_pv1 = opc_client.get_node(FLOW_PV1).get_value()
        return {"temp_hlt": temp_hlt, "temp_mlt_outside": temp_mlt_outside,"temp_mlt_inside": temp_mlt_inside,"temp_boil": temp_boil,"temp_pv1": temp_pv1,"fl_pv1": fl_pv1}
    except Exception as e:
        print(f"Fehler beim Abrufen der OPC UA-Daten: {e}")
        return None

def main():
    # Verbindung mit OPC UA-Server herstellen
    opc_client = Client(OPC_UA_SERVER)
    try:
        opc_client.connect()
        print("Mit OPC UA-Server verbunden.")
    except Exception as e:
        print(f"Fehler bei der Verbindung mit OPC UA-Server: {e}")
        return

    # Verbindung mit MQTT-Broker herstellen
    mqtt_client = mqtt.Client()
    
    try:
        mqtt_client.connect(MQTT_BROKER, MQTT_PORT, keepalive=60)
        mqtt_client.loop_start() # Startet die MQTT Schleife
        print("Mit MQTT-Broker verbunden.")
    except Exception as e:
        print(f"Fehler bei der Verbindung mit dem MQTT-Broker: {e}")
        opc_client.disconnect()
        return

    # Endlos-Schleife: Daten abrufen und per MQTT senden
    try:
        while True:
            data = read_opcua_data(opc_client)
            if data:
                # Daten als JSON an MQTT senden
                mqtt_payload = json.dumps(data)
                mqtt_client.publish(MQTT_TOPIC, mqtt_payload)
                print(f"MQTT gesendet: {mqtt_payload}")
            else:
                print("Keine Daten empfangen.")

            time.sleep(2)  # Warte 2 Sekunden, bevor die naechsten Daten abgerufen werden
    except KeyboardInterrupt:
        print("Beende Skript...")
    finally:
        # Verbindung schliessen
        opc_client.disconnect()
        mqtt_client.loop_stop()
        mqtt_client.disconnect()
        print("Verbindungen geschlossen.")

if __name__ == "__main__":
    while True:
        try:
            main()
        except:
            main()
        finally:
            pass 