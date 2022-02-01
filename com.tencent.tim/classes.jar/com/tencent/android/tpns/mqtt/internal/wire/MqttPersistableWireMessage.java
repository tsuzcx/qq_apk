package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;

public abstract class MqttPersistableWireMessage
  extends MqttWireMessage
  implements MqttPersistable
{
  public MqttPersistableWireMessage(byte paramByte)
  {
    super(paramByte);
  }
  
  public byte[] getHeaderBytes()
    throws MqttPersistenceException
  {
    try
    {
      byte[] arrayOfByte = getHeader();
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      throw new MqttPersistenceException(localThrowable.getCause());
    }
  }
  
  public int getHeaderLength()
    throws MqttPersistenceException
  {
    return getHeaderBytes().length;
  }
  
  public int getHeaderOffset()
    throws MqttPersistenceException
  {
    return 0;
  }
  
  public byte[] getPayloadBytes()
    throws MqttPersistenceException
  {
    try
    {
      byte[] arrayOfByte = getPayload();
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      throw new MqttPersistenceException(localThrowable.getCause());
    }
  }
  
  public int getPayloadLength()
    throws MqttPersistenceException
  {
    return 0;
  }
  
  public int getPayloadOffset()
    throws MqttPersistenceException
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPersistableWireMessage
 * JD-Core Version:    0.7.0.1
 */