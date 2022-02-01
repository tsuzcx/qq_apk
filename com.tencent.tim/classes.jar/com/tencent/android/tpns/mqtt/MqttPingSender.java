package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;

public abstract interface MqttPingSender
{
  public abstract void init(ClientComms paramClientComms);
  
  public abstract void schedule(long paramLong);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttPingSender
 * JD-Core Version:    0.7.0.1
 */