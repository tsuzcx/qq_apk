package com.tencent.token;

import java.io.UnsupportedEncodingException;

public class e
{
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int j;
    int i;
    int m;
    label169:
    for (;;)
    {
      int k;
      g localg;
      try
      {
        k = paramArrayOfByte.length;
        localg = new g();
        j = k / 3 * 4;
        if (!localg.d) {
          break label120;
        }
        i = j;
        if (k % 3 > 0) {
          i = j + 4;
        }
        if ((!localg.e) || (k <= 0)) {
          break label169;
        }
        m = (k - 1) / 57;
        if (!localg.f) {
          break;
        }
        j = 2;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        label71:
        throw new AssertionError(paramArrayOfByte);
      }
      localg.a = new byte[i];
      localg.a(paramArrayOfByte, k);
      if ((!a) && (localg.b != i))
      {
        throw new AssertionError();
        label120:
        i = j;
      }
      switch (k % 3)
      {
      case 0: 
        paramArrayOfByte = new String(localg.a, "US-ASCII");
        return paramArrayOfByte;
      }
    }
    for (;;)
    {
      i = j * (m + 1) + i;
      break label71;
      i = j;
      break;
      i = j + 2;
      break;
      i = j + 3;
      break;
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.e
 * JD-Core Version:    0.7.0.1
 */