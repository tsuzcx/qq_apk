package com.tencent.tmassistantsdk.f;

import java.io.UnsupportedEncodingException;

public class a
{
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 1;
    for (;;)
    {
      int k;
      d locald;
      int j;
      try
      {
        k = paramArrayOfByte.length;
        locald = new d(0, null);
        j = k / 3 << 2;
        if (!locald.c) {
          break label131;
        }
        paramInt = j;
        if (k % 3 > 0) {
          paramInt = j + 4;
        }
        if ((!locald.d) || (k <= 0)) {
          break label181;
        }
        j = (k - 1) / 57;
        if (!locald.e) {
          break label184;
        }
        i = 2;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
      locald.a = new byte[paramInt];
      locald.a(paramArrayOfByte, 0, k, true);
      if ((!a) && (locald.b != paramInt))
      {
        throw new AssertionError();
        label131:
        paramInt = j;
      }
      switch (k % 3)
      {
      case 0: 
        paramArrayOfByte = new String(locald.a, "US-ASCII");
        return paramArrayOfByte;
        continue;
        paramInt = i * (j + 1) + paramInt;
        break;
      default: 
        paramInt = j;
        break;
      case 1: 
        paramInt = j + 2;
        break;
      case 2: 
        label181:
        label184:
        paramInt = j + 3;
      }
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = paramString.getBytes();
    paramInt = arrayOfByte.length;
    paramString = new c(0, new byte[paramInt * 3 / 4]);
    if (!paramString.a(arrayOfByte, 0, paramInt, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (paramString.b == paramString.a.length) {
      return paramString.a;
    }
    arrayOfByte = new byte[paramString.b];
    System.arraycopy(paramString.a, 0, arrayOfByte, 0, paramString.b);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.a
 * JD-Core Version:    0.7.0.1
 */