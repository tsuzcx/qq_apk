package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttPersistable;

public class MqttPersistentData
  implements MqttPersistable
{
  private int hLength = 0;
  private int hOffset = 0;
  private byte[] header = null;
  private String key = null;
  private int pLength = 0;
  private int pOffset = 0;
  private byte[] payload = null;
  
  public MqttPersistentData(String paramString, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    this.key = paramString;
    this.header = paramArrayOfByte1;
    this.hOffset = paramInt1;
    this.hLength = paramInt2;
    this.payload = paramArrayOfByte2;
    this.pOffset = paramInt3;
    this.pLength = paramInt4;
  }
  
  public byte[] getHeaderBytes()
  {
    return this.header;
  }
  
  public int getHeaderLength()
  {
    return this.hLength;
  }
  
  public int getHeaderOffset()
  {
    return this.hOffset;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public byte[] getPayloadBytes()
  {
    return this.payload;
  }
  
  public int getPayloadLength()
  {
    if (this.payload == null) {
      return 0;
    }
    return this.pLength;
  }
  
  public int getPayloadOffset()
  {
    return this.pOffset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.MqttPersistentData
 * JD-Core Version:    0.7.0.1
 */