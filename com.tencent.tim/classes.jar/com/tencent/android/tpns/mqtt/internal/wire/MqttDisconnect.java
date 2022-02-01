package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

public class MqttDisconnect
  extends MqttWireMessage
{
  public static final String KEY = "Disc";
  
  public MqttDisconnect()
  {
    super((byte)14);
  }
  
  public MqttDisconnect(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)14);
  }
  
  public String getKey()
  {
    return "Disc";
  }
  
  protected byte getMessageInfo()
  {
    return 0;
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return new byte[0];
  }
  
  public boolean isMessageIdRequired()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect
 * JD-Core Version:    0.7.0.1
 */