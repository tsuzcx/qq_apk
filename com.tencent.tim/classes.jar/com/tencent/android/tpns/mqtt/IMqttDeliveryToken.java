package com.tencent.android.tpns.mqtt;

public abstract interface IMqttDeliveryToken
  extends IMqttToken
{
  public abstract MqttMessage getMessage()
    throws MqttException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.IMqttDeliveryToken
 * JD-Core Version:    0.7.0.1
 */