package com.huawei.hms.support.api.push.c.a.a;

import java.nio.charset.Charset;

public abstract class a
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2)] = a[((j & 0xF0) >> 4)];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    paramString = paramString.getBytes(b.a);
    int j = 0;
    while (j < arrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("0x");
      int i = paramString[(j * 2)];
      Charset localCharset = b.a;
      int k = (byte)(Byte.decode(new String(new byte[] { i }, localCharset)).byteValue() << 4);
      localStringBuilder = new StringBuilder().append("0x");
      i = paramString[(j * 2 + 1)];
      localCharset = b.a;
      arrayOfByte[j] = ((byte)(k ^ Byte.decode(new String(new byte[] { i }, localCharset)).byteValue()));
      j += 1;
    }
    return arrayOfByte;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    return new String(paramArrayOfByte, b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */