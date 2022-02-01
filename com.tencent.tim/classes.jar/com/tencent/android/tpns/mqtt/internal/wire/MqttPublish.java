package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MqttPublish
  extends MqttPersistableWireMessage
{
  private byte[] encodedPayload = null;
  private MqttMessage message;
  private String topicName;
  
  public MqttPublish(byte paramByte, byte[] paramArrayOfByte)
    throws MqttException, IOException
  {
    super((byte)3);
    this.message = new MqttReceivedMessage();
    this.message.setQos(paramByte >> 1 & 0x3);
    if ((paramByte & 0x1) == 1) {
      this.message.setRetained(true);
    }
    if ((paramByte & 0x8) == 8) {
      ((MqttReceivedMessage)this.message).setDuplicate(true);
    }
    CountingInputStream localCountingInputStream = new CountingInputStream(new ByteArrayInputStream(paramArrayOfByte));
    DataInputStream localDataInputStream = new DataInputStream(localCountingInputStream);
    this.topicName = decodeUTF8(localDataInputStream);
    if (this.message.getQos() > 0) {
      this.msgId = localDataInputStream.readUnsignedShort();
    }
    paramArrayOfByte = new byte[paramArrayOfByte.length - localCountingInputStream.getCounter()];
    localDataInputStream.readFully(paramArrayOfByte);
    localDataInputStream.close();
    this.message.setPayload(paramArrayOfByte);
  }
  
  public MqttPublish(String paramString, MqttMessage paramMqttMessage)
  {
    super((byte)3);
    this.topicName = paramString;
    this.message = paramMqttMessage;
  }
  
  protected static byte[] encodePayload(MqttMessage paramMqttMessage)
  {
    return paramMqttMessage.getPayload();
  }
  
  public MqttMessage getMessage()
  {
    return this.message;
  }
  
  protected byte getMessageInfo()
  {
    byte b2 = (byte)(this.message.getQos() << 1);
    byte b1 = b2;
    if (this.message.isRetained()) {
      b1 = (byte)(b2 | 0x1);
    }
    if (!this.message.isDuplicate())
    {
      b2 = b1;
      if (!this.duplicate) {}
    }
    else
    {
      b2 = (byte)(b1 | 0x8);
    }
    return b2;
  }
  
  public byte[] getPayload()
    throws MqttException
  {
    if (this.encodedPayload == null) {
      this.encodedPayload = encodePayload(this.message);
    }
    return this.encodedPayload;
  }
  
  public int getPayloadLength()
  {
    try
    {
      int i = getPayload().length;
      return i;
    }
    catch (MqttException localMqttException) {}
    return 0;
  }
  
  public String getTopicName()
  {
    return this.topicName;
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      encodeUTF8(localDataOutputStream, this.topicName);
      if (this.message.getQos() > 0) {
        localDataOutputStream.writeShort(this.msgId);
      }
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public boolean isMessageIdRequired()
  {
    return true;
  }
  
  public void setMessageId(int paramInt)
  {
    super.setMessageId(paramInt);
    if ((this.message instanceof MqttReceivedMessage)) {
      ((MqttReceivedMessage)this.message).setMessageId(paramInt);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = this.message.getPayload();
    int j = Math.min(arrayOfByte.length, 20);
    int i = 0;
    Object localObject2;
    Object localObject1;
    while (i < j)
    {
      localObject2 = Integer.toHexString(arrayOfByte[i]);
      localObject1 = localObject2;
      if (((String)localObject2).length() == 1) {
        localObject1 = "0" + (String)localObject2;
      }
      localStringBuffer.append((String)localObject1);
      i += 1;
    }
    try
    {
      localObject1 = new String(arrayOfByte, 0, j, "UTF-8");
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(super.toString());
      ((StringBuffer)localObject2).append(" qos:").append(this.message.getQos());
      if (this.message.getQos() > 0) {
        ((StringBuffer)localObject2).append(" msgId:").append(this.msgId);
      }
      ((StringBuffer)localObject2).append(" retained:").append(this.message.isRetained());
      ((StringBuffer)localObject2).append(" dup:").append(this.duplicate);
      ((StringBuffer)localObject2).append(" topic:\"").append(this.topicName).append("\"");
      ((StringBuffer)localObject2).append(" payload:[hex:").append(localStringBuffer);
      ((StringBuffer)localObject2).append(" utf8:\"").append((String)localObject1).append("\"");
      ((StringBuffer)localObject2).append(" length:").append(arrayOfByte.length).append("]");
      return ((StringBuffer)localObject2).toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "?";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttPublish
 * JD-Core Version:    0.7.0.1
 */