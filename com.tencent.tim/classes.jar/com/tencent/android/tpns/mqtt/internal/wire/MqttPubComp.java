package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttPubComp
  extends MqttAck
{
  public MqttPubComp(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)7);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public MqttPubComp(int paramInt)
  {
    super((byte)7);
    this.msgId = paramInt;
  }
  
  public MqttPubComp(MqttPublish paramMqttPublish)
  {
    super((byte)7);
    this.msgId = paramMqttPublish.getMessageId();
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return encodeMessageId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp
 * JD-Core Version:    0.7.0.1
 */