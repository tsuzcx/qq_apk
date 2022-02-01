package com.android.safeguard;

import java.io.UnsupportedEncodingException;

public class d
{
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    f localf = new f(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    if (localf.d)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      default: 
        paramInt3 = i;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      case 1: 
        paramInt3 = i + 2;
      }
    }
    i = paramInt3;
    if (localf.e)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        int j = (paramInt2 - 1) / 57;
        if (localf.f) {
          i = 2;
        } else {
          i = 1;
        }
        i = paramInt3 + (j + 1) * i;
      }
    }
    localf.a = new byte[i];
    localf.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((!a) && (localf.b != i)) {
      throw new AssertionError();
    }
    return localf.a;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.d
 * JD-Core Version:    0.7.0.1
 */