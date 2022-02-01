package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttTopic;

public abstract interface DestinationProvider
{
  public abstract MqttTopic getTopic(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.DestinationProvider
 * JD-Core Version:    0.7.0.1
 */