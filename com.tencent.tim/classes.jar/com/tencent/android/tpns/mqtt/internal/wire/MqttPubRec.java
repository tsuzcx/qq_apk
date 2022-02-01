package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttPubRec
  extends MqttAck
{
  public MqttPubRec(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)5);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public MqttPubRec(MqttPublish paramMqttPublish)
  {
    super((byte)5);
    this.msgId = paramMqttPublish.getMessageId();
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return encodeMessageId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec
 * JD-Core Version:    0.7.0.1
 */