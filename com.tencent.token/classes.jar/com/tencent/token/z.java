package com.tencent.token;

import java.nio.ByteOrder;

public final class z
{
  public final byte[] a;
  public final int b;
  public final ByteOrder c;
  public int d;
  
  public z(byte[] paramArrayOfByte, ByteOrder paramByteOrder)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = paramByteOrder;
  }
  
  public final int a()
  {
    byte[] arrayOfByte = this.a;
    int j = this.b + this.d;
    int i;
    int k;
    if (this.c == ByteOrder.BIG_ENDIAN)
    {
      i = j + 1;
      j = arrayOfByte[j];
      k = i + 1;
      j = (j & 0xFF) << 24 | (arrayOfByte[i] & 0xFF) << 16 | (arrayOfByte[k] & 0xFF) << 8;
      i = (arrayOfByte[(k + 1)] & 0xFF) << 0;
    }
    else
    {
      i = j + 1;
      j = arrayOfByte[j];
      k = i + 1;
      j = (j & 0xFF) << 0 | (arrayOfByte[i] & 0xFF) << 8 | (arrayOfByte[k] & 0xFF) << 16;
      i = (arrayOfByte[(k + 1)] & 0xFF) << 24;
    }
    this.d += 4;
    return i | j;
  }
  
  public final short b()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b + this.d;
    int j;
    if (this.c == ByteOrder.BIG_ENDIAN)
    {
      j = arrayOfByte[i] << 8;
      i = arrayOfByte[(i + 1)];
    }
    else
    {
      j = arrayOfByte[(i + 1)] << 8;
      i = arrayOfByte[i];
    }
    short s = (short)(i & 0xFF | j);
    this.d += 2;
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.z
 * JD-Core Version:    0.7.0.1
 */