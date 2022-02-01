package com.tencent.token;

public class afq
{
  static
  {
    afq.class.desiredAssertionStatus();
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes();
    int i = arrayOfByte.length;
    int i3 = i * 3 / 4;
    paramString = new byte[i3];
    int[] arrayOfInt = b.a;
    int i4 = i + 0;
    int m = 0;
    int n = 0;
    i = 0;
    int i1;
    for (int j = 0;; j = k)
    {
      i1 = i;
      k = j;
      if (m >= i4) {
        break;
      }
      int i2 = m;
      i1 = i;
      k = j;
      if (n == 0)
      {
        for (;;)
        {
          i1 = m + 4;
          if (i1 > i4) {
            break;
          }
          k = arrayOfInt[(arrayOfByte[m] & 0xFF)] << 18 | arrayOfInt[(arrayOfByte[(m + 1)] & 0xFF)] << 12 | arrayOfInt[(arrayOfByte[(m + 2)] & 0xFF)] << 6 | arrayOfInt[(arrayOfByte[(m + 3)] & 0xFF)];
          i = k;
          if (k < 0) {
            break;
          }
          paramString[(j + 2)] = ((byte)k);
          paramString[(j + 1)] = ((byte)(k >> 8));
          paramString[j] = ((byte)(k >> 16));
          j += 3;
          m = i1;
          i = k;
        }
        i1 = i;
        k = j;
        if (m >= i4) {
          break;
        }
        k = j;
        i1 = i;
        i2 = m;
      }
      i = arrayOfInt[(arrayOfByte[i2] & 0xFF)];
      switch (n)
      {
      default: 
        break;
      case 5: 
        if (i == -1) {
          break label470;
        }
        break;
      case 4: 
        if (i == -2)
        {
          i = n + 1;
          break label473;
        }
        if (i == -1) {
          break label470;
        }
        break;
      case 3: 
        if (i >= 0)
        {
          j = i | i1 << 6;
          paramString[(k + 2)] = ((byte)j);
          paramString[(k + 1)] = ((byte)(j >> 8));
          paramString[k] = ((byte)(j >> 16));
          k += 3;
          i = 0;
          break label476;
        }
        if (i == -2)
        {
          paramString[(k + 1)] = ((byte)(i1 >> 2));
          paramString[k] = ((byte)(i1 >> 10));
          k += 2;
          i = 5;
          break label473;
        }
        if (i == -1) {
          break label470;
        }
        break;
      case 2: 
        if (i < 0)
        {
          if (i == -2)
          {
            paramString[k] = ((byte)(i1 >> 4));
            k += 1;
            i = 4;
            break label473;
          }
          if (i == -1) {
            break label470;
          }
        }
        break;
      case 1: 
        if (i >= 0)
        {
          i |= i1 << 6;
          break label451;
        }
        if (i == -1) {
          break label470;
        }
        break;
      }
      if (i >= 0)
      {
        label451:
        m = n + 1;
        j = i;
        i = m;
      }
      else
      {
        if (i != -1) {
          break label572;
        }
        label470:
        i = n;
        label473:
        j = i1;
      }
      label476:
      m = i2 + 1;
      n = i;
      i = j;
    }
    switch (n)
    {
    default: 
      i = k;
      break;
    case 3: 
      i = k + 1;
      paramString[k] = ((byte)(i1 >> 10));
      paramString[i] = ((byte)(i1 >> 2));
      i += 1;
      break;
    case 2: 
      i = k + 1;
      paramString[k] = ((byte)(i1 >> 4));
      break;
    case 1: 
    case 4: 
      label572:
      j = 0;
      i = 0;
      break;
    }
    int k = 1;
    j = i;
    i = k;
    if (i != 0)
    {
      if (j != i3)
      {
        arrayOfByte = new byte[j];
        System.arraycopy(paramString, 0, arrayOfByte, 0, j);
        return arrayOfByte;
      }
      return paramString;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static abstract class a {}
  
  public static final class b
    extends afq.a
  {
    public static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    public static final int[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afq
 * JD-Core Version:    0.7.0.1
 */