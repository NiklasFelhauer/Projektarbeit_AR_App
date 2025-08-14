
#%%
import json
import paho.mqtt.client as mqtt
import time

def on_connect(client, userdata, flags, rc):
    print(f"Verbunden mit Code: {rc}")

# MQTT-Verbindung einrichten
broker_address = "192.168.188.26"        # IP-Adresse des Brokers (Pi)
topic = "brauanlage/data"                # Topic

client = mqtt.Client()
client.on_connect = on_connect

client.connect(broker_address, 1883, 60)

# Nachricht im JSON-Format vorbereiten
data = {
    "tank_1": 23.4,
    "tank_2": 22.2,
    "tank_3": 33.3,
    "ventil_1": 1,
    "ventil_2": 0,
    "ventil_3": 0,
    "ventil_4": 1,
    "ventil_5": 1,
    "ventil_6": 1,
    "ventil_7": 1,
    "ventil_8": 1,
    "ventil_9": 1,
    "pumpe_1": 0,
    "pumpe_2": 1,
    "heater_1": 1,
    "heater_2": 0,
    "aventil": 70
}

# JSON in String umwandeln
payload = json.dumps(data)

# Nachricht senden
client.loop_start()
client.publish(topic, payload)
time.sleep(1)  # kurz warten, damit Publish sicher rausgeht
client.loop_stop()

print(f"Nachricht gesendet: {payload}")

# %%
