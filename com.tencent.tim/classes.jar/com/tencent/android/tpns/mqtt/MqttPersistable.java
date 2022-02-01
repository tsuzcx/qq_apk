package com.tencent.android.tpns.mqtt;

public abstract interface MqttPersistable
{
  public abstract byte[] getHeaderBytes()
    throws MqttPersistenceException;
  
  public abstract int getHeaderLength()
    throws MqttPersistenceException;
  
  public abstract int getHeaderOffset()
    throws MqttPersistenceException;
  
  public abstract byte[] getPayloadBytes()
    throws MqttPersistenceException;
  
  public abstract int getPayloadLength()
    throws MqttPersistenceException;
  
  public abstract int getPayloadOffset()
    throws MqttPersistenceException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttPersistable
 * JD-Core Version:    0.7.0.1
 */