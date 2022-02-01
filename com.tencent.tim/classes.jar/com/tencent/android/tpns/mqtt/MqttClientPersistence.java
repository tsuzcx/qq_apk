package com.tencent.android.tpns.mqtt;

import java.util.Enumeration;

public abstract interface MqttClientPersistence
{
  public abstract void clear()
    throws MqttPersistenceException;
  
  public abstract void close()
    throws MqttPersistenceException;
  
  public abstract boolean containsKey(String paramString)
    throws MqttPersistenceException;
  
  public abstract MqttPersistable get(String paramString)
    throws MqttPersistenceException;
  
  public abstract Enumeration keys()
    throws MqttPersistenceException;
  
  public abstract void open(String paramString1, String paramString2)
    throws MqttPersistenceException;
  
  public abstract void put(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttPersistenceException;
  
  public abstract void remove(String paramString)
    throws MqttPersistenceException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttClientPersistence
 * JD-Core Version:    0.7.0.1
 */