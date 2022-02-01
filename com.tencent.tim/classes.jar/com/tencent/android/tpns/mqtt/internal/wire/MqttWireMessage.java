package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public abstract class MqttWireMessage
{
  public static final byte MESSAGE_TYPE_CONNACK = 2;
  public static final byte MESSAGE_TYPE_CONNECT = 1;
  public static final byte MESSAGE_TYPE_DISCONNECT = 14;
  public static final byte MESSAGE_TYPE_PINGREQ = 12;
  public static final byte MESSAGE_TYPE_PINGRESP = 13;
  public static final byte MESSAGE_TYPE_PUBACK = 4;
  public static final byte MESSAGE_TYPE_PUBCOMP = 7;
  public static final byte MESSAGE_TYPE_PUBLISH = 3;
  public static final byte MESSAGE_TYPE_PUBREC = 5;
  public static final byte MESSAGE_TYPE_PUBREL = 6;
  public static final byte MESSAGE_TYPE_SUBACK = 9;
  public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
  public static final byte MESSAGE_TYPE_UNSUBACK = 11;
  public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
  private static final String[] PACKET_NAMES = { "reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT" };
  protected static final String STRING_ENCODING = "UTF-8";
  protected boolean duplicate = false;
  protected int msgId;
  private byte type;
  
  public MqttWireMessage(byte paramByte)
  {
    this.type = paramByte;
    this.msgId = 0;
  }
  
  public static MqttWireMessage createWireMessage(MqttPersistable paramMqttPersistable)
    throws MqttException
  {
    byte[] arrayOfByte2 = paramMqttPersistable.getPayloadBytes();
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[0];
    }
    return createWireMessage(new MultiByteArrayInputStream(paramMqttPersistable.getHeaderBytes(), paramMqttPersistable.getHeaderOffset(), paramMqttPersistable.getHeaderLength(), arrayOfByte1, paramMqttPersistable.getPayloadOffset(), paramMqttPersistable.getPayloadLength()));
  }
  
  private static MqttWireMessage createWireMessage(InputStream paramInputStream)
    throws MqttException
  {
    int j;
    byte b;
    try
    {
      paramInputStream = new CountingInputStream(paramInputStream);
      DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
      int i = localDataInputStream.readUnsignedByte();
      j = (byte)(i >> 4);
      b = (byte)(i & 0xF);
      long l = readMBI(localDataInputStream).getValue() + paramInputStream.getCounter() - paramInputStream.getCounter();
      paramInputStream = new byte[0];
      if (l > 0L)
      {
        paramInputStream = new byte[(int)l];
        localDataInputStream.readFully(paramInputStream, 0, paramInputStream.length);
      }
      if (j == 1) {
        return new MqttConnect(b, paramInputStream);
      }
      if (j == 3)
      {
        paramInputStream = new MqttPublish(b, paramInputStream);
        return paramInputStream;
      }
    }
    catch (IOException paramInputStream)
    {
      throw new MqttException(paramInputStream);
    }
    if (j == 4) {
      return new MqttPubAck(b, paramInputStream);
    }
    if (j == 7) {
      return new MqttPubComp(b, paramInputStream);
    }
    if (j == 2) {
      return new MqttConnack(b, paramInputStream);
    }
    if (j == 12) {
      return new MqttPingReq(b, paramInputStream);
    }
    if (j == 13) {
      return new MqttPingResp(b, paramInputStream);
    }
    if (j == 8) {
      return new MqttSubscribe(b, paramInputStream);
    }
    if (j == 9) {
      return new MqttSuback(b, paramInputStream);
    }
    if (j == 10) {
      return new MqttUnsubscribe(b, paramInputStream);
    }
    if (j == 11) {
      return new MqttUnsubAck(b, paramInputStream);
    }
    if (j == 6) {
      return new MqttPubRel(b, paramInputStream);
    }
    if (j == 5) {
      return new MqttPubRec(b, paramInputStream);
    }
    if (j == 14) {
      return new MqttDisconnect(b, paramInputStream);
    }
    throw ExceptionHelper.createMqttException(6);
  }
  
  public static MqttWireMessage createWireMessage(byte[] paramArrayOfByte)
    throws MqttException
  {
    return createWireMessage(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  protected static byte[] encodeMBI(long paramLong)
  {
    int i = 0;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j;
    do
    {
      int k = (byte)(int)(paramLong % 128L);
      paramLong /= 128L;
      j = k;
      if (paramLong > 0L) {
        j = (byte)(k | 0x80);
      }
      localByteArrayOutputStream.write(j);
      j = i + 1;
      if (paramLong <= 0L) {
        break;
      }
      i = j;
    } while (j < 4);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected static MultiByteInteger readMBI(DataInputStream paramDataInputStream)
    throws IOException
  {
    long l1 = 0L;
    int j = 1;
    int i = 0;
    int m;
    int k;
    long l2;
    do
    {
      m = paramDataInputStream.readByte();
      k = i + 1;
      l2 = l1 + (m & 0x7F) * j;
      j *= 128;
      i = k;
      l1 = l2;
    } while ((m & 0x80) != 0);
    return new MultiByteInteger(l2, k);
  }
  
  protected String decodeUTF8(DataInputStream paramDataInputStream)
    throws MqttException
  {
    try
    {
      byte[] arrayOfByte = new byte[paramDataInputStream.readUnsignedShort()];
      paramDataInputStream.readFully(arrayOfByte);
      paramDataInputStream = new String(arrayOfByte, "UTF-8");
      return paramDataInputStream;
    }
    catch (IOException paramDataInputStream)
    {
      throw new MqttException(paramDataInputStream);
    }
  }
  
  protected byte[] encodeMessageId()
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
  
  protected void encodeUTF8(DataOutputStream paramDataOutputStream, String paramString)
    throws MqttException
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = (byte)(paramString.length >>> 8 & 0xFF);
      int j = (byte)(paramString.length >>> 0 & 0xFF);
      paramDataOutputStream.write(i);
      paramDataOutputStream.write(j);
      paramDataOutputStream.write(paramString);
      return;
    }
    catch (UnsupportedEncodingException paramDataOutputStream)
    {
      throw new MqttException(paramDataOutputStream);
    }
    catch (IOException paramDataOutputStream)
    {
      throw new MqttException(paramDataOutputStream);
    }
  }
  
  public byte[] getHeader()
    throws MqttException
  {
    try
    {
      int i = getType();
      int j = getMessageInfo();
      byte[] arrayOfByte = getVariableHeader();
      int k = arrayOfByte.length;
      int m = getPayload().length;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeByte((i & 0xF) << 4 ^ j & 0xF);
      localDataOutputStream.write(encodeMBI(k + m));
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.flush();
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public String getKey()
  {
    return new Integer(getMessageId()).toString();
  }
  
  public int getMessageId()
  {
    return this.msgId;
  }
  
  protected abstract byte getMessageInfo();
  
  public byte[] getPayload()
    throws MqttException
  {
    return new byte[0];
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  protected abstract byte[] getVariableHeader()
    throws MqttException;
  
  public boolean isMessageIdRequired()
  {
    return true;
  }
  
  public boolean isRetryable()
  {
    return false;
  }
  
  public void setDuplicate(boolean paramBoolean)
  {
    this.duplicate = paramBoolean;
  }
  
  public void setMessageId(int paramInt)
  {
    this.msgId = paramInt;
  }
  
  public String toString()
  {
    return PACKET_NAMES[this.type];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
 * JD-Core Version:    0.7.0.1
 */