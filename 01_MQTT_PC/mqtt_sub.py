import paho.mqtt.client as mqtt

def on_connect(client, userdata, flags, rc):
    print(f"Verbunden mit Code: {rc}")
    client.subscribe("brauanlage/data")

def on_message(client, userdata, msg):
    print(f"Nachricht empfangen: {msg.topic} {msg.payload.decode()}")

broker_address = "192.168.188.26"  # IP-Adresse des Brokers

client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message
client.connect(broker_address, 1883, 60)  # Port 1883 ist Standard (MQTT)

client.loop_forever()
