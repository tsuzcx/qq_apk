package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttPubRel
  extends MqttPersistableWireMessage
{
  public MqttPubRel(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)6);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public MqttPubRel(MqttPubRec paramMqttPubRec)
  {
    super((byte)6);
    setMessageId(paramMqttPubRec.getMessageId());
  }
  
  protected byte getMessageInfo()
  {
    if (this.duplicate) {}
    for (int i = 8;; i = 0) {
      return (byte)(i | 0x2);
    }
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return encodeMessageId();
  }
  
  public String toString()
  {
    return super.toString() + " msgId " + this.msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPubRel
 * JD-Core Version:    0.7.0.1
 */