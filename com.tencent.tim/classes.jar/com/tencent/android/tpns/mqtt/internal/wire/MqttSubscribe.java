package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MqttSubscribe
  extends MqttWireMessage
{
  private int count;
  private String[] names;
  private int[] qos;
  
  public MqttSubscribe(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)8);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    this.count = 0;
    this.names = new String[10];
    this.qos = new int[10];
    while (paramByte == 0) {
      try
      {
        this.names[this.count] = decodeUTF8(paramArrayOfByte);
        int[] arrayOfInt = this.qos;
        int i = this.count;
        this.count = (i + 1);
        arrayOfInt[i] = paramArrayOfByte.readByte();
      }
      catch (Throwable localThrowable)
      {
        paramByte = 1;
      }
    }
    paramArrayOfByte.close();
  }
  
  public MqttSubscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super((byte)8);
    this.names = paramArrayOfString;
    this.qos = paramArrayOfInt;
    if (paramArrayOfString.length != paramArrayOfInt.length) {
      throw new IllegalArgumentException();
    }
    this.count = paramArrayOfString.length;
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      MqttMessage.validateQos(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  protected byte getMessageInfo()
  {
    if (this.duplicate) {}
    for (int i = 8;; i = 0) {
      return (byte)(i | 0x2);
    }
  }
  
  public byte[] getPayload()
    throws MqttException
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      int i = 0;
      while (i < this.names.length)
      {
        encodeUTF8(localDataOutputStream, this.names[i]);
        localDataOutputStream.writeByte(this.qos[i]);
        i += 1;
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
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeShort(this.msgId);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public boolean isRetryable()
  {
    return true;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" names:[");
    int i = 0;
    while (i < this.count)
    {
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append("\"").append(this.names[i]).append("\"");
      i += 1;
    }
    localStringBuffer.append("] qos:[");
    i = j;
    while (i < this.count)
    {
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(this.qos[i]);
      i += 1;
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe
 * JD-Core Version:    0.7.0.1
 */