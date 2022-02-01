package com.tencent.token;

public class aeg
{
  static
  {
    aeg.class.desiredAssertionStatus();
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.getBytes();
    int i = paramString.length;
    Object localObject = new b(new byte[i * 3 / 4]);
    int n = ((b)localObject).e;
    if (n == 6)
    {
      i = 0;
    }
    else
    {
      int i3 = i + 0;
      int j = ((b)localObject).f;
      byte[] arrayOfByte = ((a)localObject).a;
      int[] arrayOfInt = ((b)localObject).g;
      i = 0;
      int m = 0;
      int k;
      int i1;
      for (;;)
      {
        k = i;
        i1 = j;
        if (m >= i3) {
          break;
        }
        int i2 = m;
        k = i;
        i1 = j;
        if (n == 0)
        {
          for (;;)
          {
            i1 = m + 4;
            if (i1 > i3) {
              break;
            }
            k = arrayOfInt[(paramString[m] & 0xFF)] << 18 | arrayOfInt[(paramString[(m + 1)] & 0xFF)] << 12 | arrayOfInt[(paramString[(m + 2)] & 0xFF)] << 6 | arrayOfInt[(paramString[(m + 3)] & 0xFF)];
            j = k;
            if (k < 0) {
              break;
            }
            arrayOfByte[(i + 2)] = ((byte)k);
            arrayOfByte[(i + 1)] = ((byte)(k >> 8));
            arrayOfByte[i] = ((byte)(k >> 16));
            i += 3;
            m = i1;
            j = k;
          }
          k = i;
          i1 = j;
          if (m >= i3) {
            break;
          }
          i1 = j;
          k = i;
          i2 = m;
        }
        j = arrayOfInt[(paramString[i2] & 0xFF)];
        switch (n)
        {
        default: 
          break;
        case 5: 
          if (j == -1) {
            break label560;
          }
          ((b)localObject).e = 6;
          i = 0;
          break;
        case 4: 
          if (j == -2)
          {
            i = n + 1;
            break label563;
          }
          if (j == -1) {
            break label560;
          }
          ((b)localObject).e = 6;
          i = 0;
          break;
        case 3: 
          if (j >= 0)
          {
            j |= i1 << 6;
            arrayOfByte[(k + 2)] = ((byte)j);
            arrayOfByte[(k + 1)] = ((byte)(j >> 8));
            arrayOfByte[k] = ((byte)(j >> 16));
            k += 3;
            i = 0;
            break label566;
          }
          if (j == -2)
          {
            arrayOfByte[(k + 1)] = ((byte)(i1 >> 2));
            arrayOfByte[k] = ((byte)(i1 >> 10));
            k += 2;
            i = 5;
            break label563;
          }
          if (j == -1) {
            break label560;
          }
          ((b)localObject).e = 6;
          i = 0;
          break;
        case 2: 
          if (j < 0)
          {
            if (j == -2)
            {
              arrayOfByte[k] = ((byte)(i1 >> 4));
              k += 1;
              i = 4;
              break label563;
            }
            if (j == -1) {
              break label560;
            }
            ((b)localObject).e = 6;
            i = 0;
          }
          break;
        case 1: 
          if (j >= 0)
          {
            i = n + 1;
            j |= i1 << 6;
            break label566;
          }
          if (j == -1) {
            break label560;
          }
          ((b)localObject).e = 6;
          i = 0;
          break;
        }
        if (j >= 0)
        {
          i = n + 1;
        }
        else
        {
          if (j != -1)
          {
            ((b)localObject).e = 6;
            i = 0;
            break label710;
          }
          label560:
          i = n;
          label563:
          j = i1;
        }
        label566:
        m = i2 + 1;
        n = i;
        i = k;
      }
      i = k;
      switch (n)
      {
      default: 
        i = k;
        break;
      case 4: 
        ((b)localObject).e = 6;
        i = 0;
        break;
      case 3: 
        j = k + 1;
        arrayOfByte[k] = ((byte)(i1 >> 10));
        i = j + 1;
        arrayOfByte[j] = ((byte)(i1 >> 2));
        break;
      case 2: 
        arrayOfByte[k] = ((byte)(i1 >> 4));
        i = k + 1;
        break;
      case 1: 
        ((b)localObject).e = 6;
        i = 0;
        break;
      }
      ((b)localObject).e = n;
      ((a)localObject).b = i;
      i = 1;
    }
    label710:
    if (i != 0)
    {
      i = ((a)localObject).b;
      localObject = ((a)localObject).a;
      paramString = (String)localObject;
      if (i != localObject.length)
      {
        paramString = new byte[i];
        System.arraycopy(localObject, 0, paramString, 0, i);
      }
      return paramString;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static abstract class a
  {
    public byte[] a;
    public int b;
  }
  
  public static final class b
    extends aeg.a
  {
    public static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    public static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    public int e;
    public int f;
    public final int[] g;
    
    public b(byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      this.g = c;
      this.e = 0;
      this.f = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aeg
 * JD-Core Version:    0.7.0.1
 */