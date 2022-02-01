package com.tencent.android.tpns.mqtt;

public abstract interface IMqttMessageListener
{
  public abstract void messageArrived(String paramString, MqttMessage paramMqttMessage)
    throws Exception;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.IMqttMessageListener
 * JD-Core Version:    0.7.0.1
 */