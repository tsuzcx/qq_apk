package com.tencent.jni;

public class IdCardInfo
{
  byte[] mData;
  byte[] mInfo;
  
  public byte[] data()
  {
    return this.mData;
  }
  
  public byte[] info()
  {
    return this.mInfo;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  public void setInfo(byte[] paramArrayOfByte)
  {
    this.mInfo = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.IdCardInfo
 * JD-Core Version:    0.7.0.1
 */