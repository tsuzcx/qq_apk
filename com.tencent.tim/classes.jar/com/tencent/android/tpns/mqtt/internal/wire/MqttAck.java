package com.tencent.android.tpns.mqtt.internal.wire;

public abstract class MqttAck
  extends MqttWireMessage
{
  public MqttAck(byte paramByte)
  {
    super(paramByte);
  }
  
  protected byte getMessageInfo()
  {
    return 0;
  }
  
  public String toString()
  {
    return super.toString() + " msgId " + this.msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttAck
 * JD-Core Version:    0.7.0.1
 */