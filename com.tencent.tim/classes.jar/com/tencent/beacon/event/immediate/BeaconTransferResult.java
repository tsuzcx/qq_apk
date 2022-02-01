package com.tencent.beacon.event.immediate;

public class BeaconTransferResult
{
  private int a;
  private int b;
  private byte[] c;
  private String d;
  
  public byte[] getBizBuffer()
  {
    return this.c;
  }
  
  public int getBizCode()
  {
    return this.b;
  }
  
  public String getBizMsg()
  {
    return this.d;
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public void setBizBuffer(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public void setBizCode(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setBizMsg(String paramString)
  {
    this.d = paramString;
  }
  
  public void setCode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BeaconTransferResult{");
    localStringBuilder.append("returnCode=").append(this.a);
    localStringBuilder.append(", bizReturnCode=").append(this.b);
    localStringBuilder.append(", bizMsg='").append(this.d).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.immediate.BeaconTransferResult
 * JD-Core Version:    0.7.0.1
 */