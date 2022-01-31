package com.qq.taf.jce.dynamic;

public class ByteArrayField
  extends JceField
{
  private byte[] data;
  
  ByteArrayField(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramInt);
    this.data = paramArrayOfByte;
  }
  
  public byte[] get()
  {
    return this.data;
  }
  
  public void set(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.ByteArrayField
 * JD-Core Version:    0.7.0.1
 */