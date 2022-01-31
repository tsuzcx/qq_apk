package com.tencent.av.config;

import java.io.UnsupportedEncodingException;

public class ByteBuffer
{
  private static final int jdField_a_of_type_Int = 512;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = 0;
  private int c = 0;
  
  public ByteBuffer()
  {
    this.a = null;
    this.a = new byte[512];
    int i = 0;
    while (i < 512)
    {
      this.a[i] = 0;
      i += 1;
    }
    this.b = 0;
    this.c = 0;
  }
  
  public ByteBuffer(byte[] paramArrayOfByte)
  {
    this.a = null;
    if (paramArrayOfByte == null)
    {
      this.a = new byte[512];
      int i = 0;
      while (i < 512)
      {
        this.a[i] = 0;
        i += 1;
      }
      this.b = 0;
      this.c = 0;
      return;
    }
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = paramArrayOfByte.length;
  }
  
  public byte a()
  {
    if (b() < 1) {
      return -1;
    }
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i];
  }
  
  public int a()
  {
    int n = 0;
    int i2;
    if (b() < 4)
    {
      i2 = -1;
      return i2;
    }
    byte[] arrayOfByte = this.a;
    int i1 = this.b;
    this.b = (i1 + 1);
    int i = arrayOfByte[i1];
    arrayOfByte = this.a;
    i1 = this.b;
    this.b = (i1 + 1);
    int j = arrayOfByte[i1];
    arrayOfByte = this.a;
    i1 = this.b;
    this.b = (i1 + 1);
    int k = arrayOfByte[i1];
    arrayOfByte = this.a;
    i1 = this.b;
    this.b = (i1 + 1);
    int m = arrayOfByte[i1];
    i1 = 0;
    for (;;)
    {
      i2 = n;
      if (i1 >= 4) {
        break;
      }
      i2 = new byte[] { i, j, k, m }[(3 - i1)];
      int i3 = Common.a(16, i1 * 2);
      i1 += 1;
      n = i2 * i3 + n;
    }
  }
  
  public String a(int paramInt)
  {
    if ((paramInt <= 0) || (b() < paramInt)) {
      return null;
    }
    Object localObject = new byte[paramInt];
    System.arraycopy(this.a, this.b, localObject, 0, paramInt);
    this.b += paramInt;
    try
    {
      localObject = new String((byte[])localObject, "GBK");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  public short a()
  {
    if (b() < 2) {
      return -1;
    }
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte2 = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte1[0] = arrayOfByte2[i];
    arrayOfByte2 = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte1[1] = arrayOfByte2[i];
    i = arrayOfByte1[0];
    return (short)(arrayOfByte1[1] + i * 256);
  }
  
  public void a(byte paramByte)
  {
    this.a[this.b] = paramByte;
    this.b += 1;
    this.c += 1;
  }
  
  public void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    byte[] arrayOfByte = this.a;
    paramInt = this.b;
    System.arraycopy(new byte[] { m, k, j, i }, 0, arrayOfByte, paramInt, 4);
    this.b += 4;
    this.c += 4;
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 1)) {
      return;
    }
    try
    {
      paramString = paramString.getBytes("GBK");
      System.arraycopy(paramString, 0, this.a, this.b, paramString.length);
      this.b += paramString.length;
      int i = this.c;
      this.c = (paramString.length + i);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    int j = (byte)(paramShort >> 8 & 0xFF);
    byte[] arrayOfByte = this.a;
    paramShort = this.b;
    System.arraycopy(new byte[] { j, i }, 0, arrayOfByte, paramShort, 2);
    this.b += 2;
    this.c += 2;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1)) {
      return;
    }
    System.arraycopy(paramArrayOfByte, 0, this.a, this.b, paramArrayOfByte.length);
    this.b += paramArrayOfByte.length;
    this.c += paramArrayOfByte.length;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt <= 0) || (b() < paramInt)) {
      return false;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, paramInt);
    this.b += paramInt;
    return true;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.c];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.c);
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.c - this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */