package com.tencent.token;

import java.io.UnsupportedEncodingException;

public class aug
{
  public static String a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int k;
      int j;
      int m;
      try
      {
        k = paramArrayOfByte.length;
        auj localauj = new auj();
        j = k / 3 * 4;
        if (localauj.d)
        {
          i = j;
          if (k % 3 > 0) {
            i = j + 4;
          }
          j = i;
          if (localauj.e)
          {
            j = i;
            if (k > 0)
            {
              m = (k - 1) / 57;
              j = 1;
              if (!localauj.f) {
                break label199;
              }
              j = 2;
              break label199;
            }
          }
          localauj.a = new byte[j];
          localauj.a(paramArrayOfByte, k);
          if ((!a) && (localauj.b != j)) {
            throw new AssertionError();
          }
          paramArrayOfByte = new String(localauj.a, "US-ASCII");
          return paramArrayOfByte;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
      int i = j;
      switch (k % 3)
      {
      case 0: 
      default: 
        i = j;
        break;
      case 2: 
        i = j + 3;
        break;
      case 1: 
        i = j + 2;
        continue;
        label199:
        j = i + (m + 1) * j;
      }
    }
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte1 = paramString.getBytes();
    int i = arrayOfByte1.length;
    paramString = new aui(new byte[i * 3 / 4]);
    if (paramString.c == 6)
    {
      i = 0;
    }
    else
    {
      int i3 = i + 0;
      int j = paramString.c;
      int k = paramString.d;
      byte[] arrayOfByte2 = paramString.a;
      int[] arrayOfInt = paramString.e;
      int m = 0;
      i = 0;
      int i1;
      int n;
      for (;;)
      {
        i1 = k;
        n = m;
        if (i >= i3) {
          break;
        }
        int i2 = i;
        i1 = k;
        n = m;
        if (j == 0)
        {
          n = k;
          for (k = i;; k = i1)
          {
            i1 = k + 4;
            i = n;
            if (i1 > i3) {
              break;
            }
            n = arrayOfInt[(arrayOfByte1[k] & 0xFF)] << 18 | arrayOfInt[(arrayOfByte1[(k + 1)] & 0xFF)] << 12 | arrayOfInt[(arrayOfByte1[(k + 2)] & 0xFF)] << 6 | arrayOfInt[(arrayOfByte1[(k + 3)] & 0xFF)];
            i = n;
            if (n < 0) {
              break;
            }
            arrayOfByte2[(m + 2)] = ((byte)n);
            arrayOfByte2[(m + 1)] = ((byte)(n >> 8));
            arrayOfByte2[m] = ((byte)(n >> 16));
            m += 3;
          }
          i1 = i;
          n = m;
          if (k >= i3) {
            break;
          }
          n = m;
          i1 = i;
          i2 = k;
        }
        i = i2 + 1;
        k = arrayOfInt[(arrayOfByte1[i2] & 0xFF)];
        switch (j)
        {
        default: 
          break;
        case 5: 
          if (k != -1)
          {
            paramString.c = 6;
            i = 0;
          }
          break;
        case 4: 
          if (k == -2)
          {
            j += 1;
            k = i1;
            m = n;
          }
          else if (k != -1)
          {
            paramString.c = 6;
            i = 0;
          }
          break;
        case 3: 
          if (k >= 0)
          {
            k = i1 << 6 | k;
            arrayOfByte2[(n + 2)] = ((byte)k);
            arrayOfByte2[(n + 1)] = ((byte)(k >> 8));
            arrayOfByte2[n] = ((byte)(k >> 16));
            m = n + 3;
            j = 0;
          }
          else if (k == -2)
          {
            arrayOfByte2[(n + 1)] = ((byte)(i1 >> 2));
            arrayOfByte2[n] = ((byte)(i1 >> 10));
            m = n + 2;
            j = 5;
            k = i1;
          }
          else if (k != -1)
          {
            paramString.c = 6;
            i = 0;
          }
          break;
        case 2: 
          if (k >= 0)
          {
            k = i1 << 6 | k;
            j += 1;
            m = n;
          }
          else if (k == -2)
          {
            arrayOfByte2[n] = ((byte)(i1 >> 4));
            m = n + 1;
            j = 4;
            k = i1;
          }
          else if (k != -1)
          {
            paramString.c = 6;
            i = 0;
          }
          break;
        case 1: 
          if (k >= 0)
          {
            k = i1 << 6 | k;
            j += 1;
            m = n;
          }
          else if (k != -1)
          {
            paramString.c = 6;
            i = 0;
          }
          break;
        case 0: 
          if (k >= 0)
          {
            j += 1;
            m = n;
          }
          else
          {
            if (k != -1)
            {
              paramString.c = 6;
              i = 0;
              break label762;
            }
            k = i1;
            m = n;
          }
          break;
        }
      }
      i = n;
      switch (j)
      {
      default: 
        i = n;
        break;
      case 4: 
        paramString.c = 6;
        i = 0;
        break;
      case 3: 
        k = n + 1;
        arrayOfByte2[n] = ((byte)(i1 >> 10));
        i = k + 1;
        arrayOfByte2[k] = ((byte)(i1 >> 2));
        break;
      case 2: 
        arrayOfByte2[n] = ((byte)(i1 >> 4));
        i = n + 1;
        break;
      case 1: 
        paramString.c = 6;
        i = 0;
        break;
      }
      paramString.c = j;
      paramString.b = i;
      i = 1;
    }
    label762:
    if (i != 0)
    {
      if (paramString.b == paramString.a.length) {
        return paramString.a;
      }
      arrayOfByte1 = new byte[paramString.b];
      System.arraycopy(paramString.a, 0, arrayOfByte1, 0, paramString.b);
      return arrayOfByte1;
    }
    throw new IllegalArgumentException("bad base-64");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aug
 * JD-Core Version:    0.7.0.1
 */