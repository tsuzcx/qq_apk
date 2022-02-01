package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.MqttException;

public abstract interface IDisconnectedBufferCallback
{
  public abstract void publishBufferedMessage(BufferedMessage paramBufferedMessage)
    throws MqttException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.IDisconnectedBufferCallback
 * JD-Core Version:    0.7.0.1
 */