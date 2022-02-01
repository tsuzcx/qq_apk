package com.tencent.android.tpns.mqtt.persist;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import java.util.Enumeration;
import java.util.Hashtable;

public class MemoryPersistence
  implements MqttClientPersistence
{
  private Hashtable data;
  
  public void clear()
    throws MqttPersistenceException
  {
    this.data.clear();
  }
  
  public void close()
    throws MqttPersistenceException
  {
    this.data.clear();
  }
  
  public boolean containsKey(String paramString)
    throws MqttPersistenceException
  {
    return this.data.containsKey(paramString);
  }
  
  public MqttPersistable get(String paramString)
    throws MqttPersistenceException
  {
    return (MqttPersistable)this.data.get(paramString);
  }
  
  public Enumeration keys()
    throws MqttPersistenceException
  {
    return this.data.keys();
  }
  
  public void open(String paramString1, String paramString2)
    throws MqttPersistenceException
  {
    this.data = new Hashtable();
  }
  
  public void put(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttPersistenceException
  {
    this.data.put(paramString, paramMqttPersistable);
  }
  
  public void remove(String paramString)
    throws MqttPersistenceException
  {
    this.data.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.persist.MemoryPersistence
 * JD-Core Version:    0.7.0.1
 */