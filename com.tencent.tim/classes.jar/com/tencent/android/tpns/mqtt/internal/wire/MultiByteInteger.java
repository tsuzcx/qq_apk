package com.tencent.android.tpns.mqtt.internal.wire;

public class MultiByteInteger
{
  private int length;
  private long value;
  
  public MultiByteInteger(long paramLong)
  {
    this(paramLong, -1);
  }
  
  public MultiByteInteger(long paramLong, int paramInt)
  {
    this.value = paramLong;
    this.length = paramInt;
  }
  
  public int getEncodedLength()
  {
    return this.length;
  }
  
  public long getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MultiByteInteger
 * JD-Core Version:    0.7.0.1
 */