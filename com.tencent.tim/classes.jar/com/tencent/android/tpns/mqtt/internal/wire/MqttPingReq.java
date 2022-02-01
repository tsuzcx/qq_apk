package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

public class MqttPingReq
  extends MqttWireMessage
{
  public static final String KEY = "Ping";
  
  public MqttPingReq()
  {
    super((byte)12);
  }
  
  public MqttPingReq(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)12);
  }
  
  public String getKey()
  {
    return "Ping";
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
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq
 * JD-Core Version:    0.7.0.1
 */