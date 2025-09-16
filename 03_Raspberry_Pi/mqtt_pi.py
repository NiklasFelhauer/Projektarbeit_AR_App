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
Q_Ventil_1 = 'ns=3;s="Q_Ventil_1";datatype=Boolean'
Q_Ventil_2 = 'ns=3;s="Q_Ventil_2";datatype=Boolean'
Q_Ventil_3 = 'ns=3;s="Q_Ventil_3";datatype=Boolean' 
Q_Ventil_4 = 'ns=3;s="Q_Ventil_4";datatype=Boolean'
Q_Ventil_5 = 'ns=3;s="Q_Ventil_5";datatype=Boolean'
Q_Ventil_6 = 'ns=3;s="Q_Ventil_6";datatype=Boolean'
Q_Ventil_7 = 'ns=3;s="Q_Ventil_7";datatype=Boolean'
Q_Ventil_8 = 'ns=3;s="Q_Ventil_8";datatype=Boolean'
Q_Ventil_9 = 'ns=3;s="Q_Ventil_9";datatype=Boolean'
Q_Pumpe_1 = 'ns=3;s="Q_Pumpe_1";datatype=Boolean'
Q_Pumpe_2 = 'ns=3;s="Q_Pumpe_2";datatype=Boolean'
Q_Heizung_1 = 'ns=3;s="Q_Heizung_1";datatype=Boolean'
Q_Heizung_2 = 'ns=3;s="Q_Heizung_2";datatype=Boolean'

# MQTT-Einstellungen
MQTT_BROKER = "192.168.0.100"  # IP-Adresse des Raspberry Pi 
MQTT_PORT = 1883
MQTT_TOPIC = "brauanlage/data"

def read_opcua_data(opc_client):
    """
    Liest Daten von der SPS über OPC UA.
    
     
    """
    try:
        # Knoten abrufen und Werte auslesen
        temp_hlt = opc_client.get_node(TEMPERATURE_HLT).get_value()
        temp_mlt_outside = opc_client.get_node(TEMPERATURE_MLT_OUTSIDE).get_value()
        temp_mlt_inside = opc_client.get_node(TEMPERATURE_MLT_INSIDE).get_value()
        temp_boil = opc_client.get_node(TEMPERATURE_BOIL).get_value()
        temp_pv1 = opc_client.get_node(TEMPERATURE_PV1).get_value()
        fl_pv1 = opc_client.get_node(FLOW_PV1).get_value()
        q_ventil_1 = float(opc_client.get_node(Q_Ventil_1).get_value())
        q_ventil_2 = float(opc_client.get_node(Q_Ventil_2).get_value())
        q_ventil_3 = float(opc_client.get_node(Q_Ventil_3).get_value())
        q_ventil_4 = float(opc_client.get_node(Q_Ventil_4).get_value())
        q_ventil_5 = float(opc_client.get_node(Q_Ventil_5).get_value())
        q_ventil_6 = float(opc_client.get_node(Q_Ventil_6).get_value())
        q_ventil_7 = float(opc_client.get_node(Q_Ventil_7).get_value())
        q_ventil_8 = float(opc_client.get_node(Q_Ventil_8).get_value())
        q_ventil_9 = float(opc_client.get_node(Q_Ventil_9).get_value())
        q_pumpe_1 = float(opc_client.get_node(Q_Pumpe_1).get_value())
        q_pumpe_2 = float(opc_client.get_node(Q_Pumpe_2).get_value())
        q_heizung_1 = float(opc_client.get_node(Q_Heizung_1).get_value())
        q_heizung_2 = float(opc_client.get_node(Q_Heizung_2).get_value())
        
        #"temp_mlt_outside": temp_mlt_outside, "temp_pv1": temp_pv1,

        return {"tank_3": temp_hlt, "tank_2": temp_mlt_inside,"tank_1": temp_boil,"aventil": fl_pv1, "ventil_1": q_ventil_1, "ventil_2": q_ventil_2, "ventil_3": q_ventil_3,"ventil_4": q_ventil_4, "ventil_5": q_ventil_5, "ventil_6": q_ventil_6, "ventil_7": q_ventil_7, "ventil_8": q_ventil_8,"ventil_9": q_ventil_9, "pumpe_1": q_pumpe_1 , "pumpe_2": q_pumpe_2, "heater_1": q_heizung_1, "heater_2": q_heizung_2}
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
                #print(data)
            else:
                print("Keine Daten empfangen.")

            time.sleep(2)  # Warte 2 Sekunden, bevor die nächsten Daten abgerufen werden
    except KeyboardInterrupt:
        print("Beende Skript...")
    finally:
        # Verbindung schließen
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
