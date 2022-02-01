package com.tencent.token;

public final class aff
{
  public static final byte[] a = new byte[0];
  public int b;
  public byte[] c;
  
  public aff(int paramInt, byte[] paramArrayOfByte)
  {
    this.b = paramInt;
    this.c = paramArrayOfByte;
  }
  
  public static aff a(int paramInt)
  {
    return new aff(paramInt, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aff
 * JD-Core Version:    0.7.0.1
 */