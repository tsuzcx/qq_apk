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
      c localc;
      int j;
      try
      {
        k = paramArrayOfByte.length;
        localc = new c(0, null);
        j = k / 3 << 2;
        if (!localc.c) {
          break label131;
        }
        paramInt = j;
        if (k % 3 > 0) {
          paramInt = j + 4;
        }
        if ((!localc.d) || (k <= 0)) {
          break label181;
        }
        j = (k - 1) / 57;
        if (!localc.e) {
          break label184;
        }
        i = 2;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
      localc.a = new byte[paramInt];
      localc.a(paramArrayOfByte, 0, k, true);
      if ((!a) && (localc.b != paramInt))
      {
        throw new AssertionError();
        label131:
        paramInt = j;
      }
      switch (k % 3)
      {
      case 0: 
        paramArrayOfByte = new String(localc.a, "US-ASCII");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.a
 * JD-Core Version:    0.7.0.1
 */