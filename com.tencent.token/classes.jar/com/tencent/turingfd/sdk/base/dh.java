package com.tencent.turingfd.sdk.base;

public class dh
{
  public final int a;
  public final byte[] b;
  
  public dh(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }
  
  public static dh a(int paramInt, byte[] paramArrayOfByte)
  {
    return new dh(paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.dh
 * JD-Core Version:    0.7.0.1
 */