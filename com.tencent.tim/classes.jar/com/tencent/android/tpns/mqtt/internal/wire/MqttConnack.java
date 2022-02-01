package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class MqttConnack
  extends MqttAck
{
  public static final String KEY = "Con";
  private int returnCode;
  private boolean sessionPresent;
  
  public MqttConnack(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)2);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    if ((paramArrayOfByte.readUnsignedByte() & 0x1) == 1) {}
    for (;;)
    {
      this.sessionPresent = bool;
      this.returnCode = paramArrayOfByte.readUnsignedByte();
      paramArrayOfByte.close();
      return;
      bool = false;
    }
  }
  
  public String getKey()
  {
    return "Con";
  }
  
  public int getReturnCode()
  {
    return this.returnCode;
  }
  
  public boolean getSessionPresent()
  {
    return this.sessionPresent;
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
  
  public String toString()
  {
    return super.toString() + " session present:" + this.sessionPresent + " return code: " + this.returnCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MqttConnack
 * JD-Core Version:    0.7.0.1
 */