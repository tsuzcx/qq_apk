package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttSuback
  extends MqttAck
{
  private int[] grantedQos;
  
  public MqttSuback(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)9);
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = localDataInputStream.readUnsignedShort();
    int i = 0;
    this.grantedQos = new int[paramArrayOfByte.length - 2];
    for (paramByte = localDataInputStream.read(); paramByte != -1; paramByte = localDataInputStream.read())
    {
      this.grantedQos[i] = paramByte;
      i += 1;
    }
    localDataInputStream.close();
  }
  
  public int[] getGrantedQos()
  {
    return this.grantedQos;
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return new byte[0];
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString()).append(" granted Qos");
    int i = 0;
    while (i < this.grantedQos.length)
    {
      localStringBuffer.append(" ").append(this.grantedQos[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttSuback
 * JD-Core Version:    0.7.0.1
 */