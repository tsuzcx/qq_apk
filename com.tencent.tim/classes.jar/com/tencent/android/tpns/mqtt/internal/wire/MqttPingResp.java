package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;

public class MqttPingResp
  extends MqttAck
{
  public static final String KEY = "Ping";
  
  public MqttPingResp(byte paramByte, byte[] paramArrayOfByte)
  {
    super((byte)13);
  }
  
  public String getKey()
  {
    return "Ping";
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
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPingResp
 * JD-Core Version:    0.7.0.1
 */