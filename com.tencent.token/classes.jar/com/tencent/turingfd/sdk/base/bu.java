package com.tencent.turingfd.sdk.base;

public class bu
{
  static
  {
    bu.class.desiredAssertionStatus();
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    paramString = paramString.getBytes();
    int i = paramString.length;
    Object localObject = new b(paramInt, new byte[i * 3 / 4]);
    int i1 = ((b)localObject).e;
    if (i1 == 6)
    {
      paramInt = 0;
    }
    else
    {
      int i3 = i + 0;
      i = ((b)localObject).f;
      byte[] arrayOfByte = ((a)localObject).a;
      int[] arrayOfInt = ((b)localObject).g;
      paramInt = 0;
      int k;
      int m;
      for (int j = 0;; j = k)
      {
        k = paramInt;
        m = i;
        if (j >= i3) {
          break;
        }
        m = paramInt;
        k = i;
        int n = j;
        if (i1 == 0)
        {
          for (;;)
          {
            m = j + 4;
            if (m > i3) {
              break;
            }
            k = arrayOfInt[(paramString[j] & 0xFF)] << 18 | arrayOfInt[(paramString[(j + 1)] & 0xFF)] << 12 | arrayOfInt[(paramString[(j + 2)] & 0xFF)] << 6 | arrayOfInt[(paramString[(j + 3)] & 0xFF)];
            i = k;
            if (k < 0) {
              break;
            }
            arrayOfByte[(paramInt + 2)] = ((byte)k);
            arrayOfByte[(paramInt + 1)] = ((byte)(k >> 8));
            arrayOfByte[paramInt] = ((byte)(k >> 16));
            paramInt += 3;
            j = m;
            i = k;
          }
          m = paramInt;
          k = i;
          n = j;
          if (j >= i3)
          {
            k = paramInt;
            m = i;
            break;
          }
        }
        int i2 = arrayOfInt[(paramString[n] & 0xFF)];
        switch (i1)
        {
        default: 
          paramInt = i1;
          i = m;
          j = k;
          break;
        case 5: 
          paramInt = i1;
          i = m;
          j = k;
          if (i2 == -1) {
            break label675;
          }
          ((b)localObject).e = 6;
          paramInt = 0;
          break;
        case 4: 
          if (i2 == -2)
          {
            paramInt = i1 + 1;
            i = m;
            j = k;
            break label675;
          }
          paramInt = i1;
          i = m;
          j = k;
          if (i2 == -1) {
            break label675;
          }
          ((b)localObject).e = 6;
          paramInt = 0;
          break;
        case 3: 
          if (i2 >= 0)
          {
            j = i2 | k << 6;
            arrayOfByte[(m + 2)] = ((byte)j);
            arrayOfByte[(m + 1)] = ((byte)(j >> 8));
            arrayOfByte[m] = ((byte)(j >> 16));
            i = m + 3;
            paramInt = 0;
            break label675;
          }
          if (i2 == -2)
          {
            arrayOfByte[(m + 1)] = ((byte)(k >> 2));
            arrayOfByte[m] = ((byte)(k >> 10));
            i = m + 2;
            paramInt = 5;
            j = k;
            break label675;
          }
          paramInt = i1;
          i = m;
          j = k;
          if (i2 == -1) {
            break label675;
          }
          ((b)localObject).e = 6;
          paramInt = 0;
          break;
        case 2: 
          if (i2 < 0)
          {
            if (i2 == -2)
            {
              arrayOfByte[m] = ((byte)(k >> 4));
              i = m + 1;
              paramInt = 4;
              j = k;
              break label675;
            }
            paramInt = i1;
            i = m;
            j = k;
            if (i2 == -1) {
              break label675;
            }
            ((b)localObject).e = 6;
            paramInt = 0;
          }
          break;
        case 1: 
          if (i2 >= 0)
          {
            paramInt = i1 + 1;
            j = i2 | k << 6;
            i = m;
            break label675;
          }
          paramInt = i1;
          i = m;
          j = k;
          if (i2 == -1) {
            break label675;
          }
          ((b)localObject).e = 6;
          paramInt = 0;
          break;
        }
        if (i2 >= 0)
        {
          paramInt = i1 + 1;
          j = i2;
          i = m;
        }
        else
        {
          paramInt = i1;
          i = m;
          j = k;
          if (i2 != -1)
          {
            ((b)localObject).e = 6;
            paramInt = 0;
            break label827;
          }
        }
        label675:
        k = n + 1;
        i1 = paramInt;
        paramInt = i;
        i = j;
      }
      paramInt = k;
      switch (i1)
      {
      default: 
        paramInt = k;
        break;
      case 4: 
        ((b)localObject).e = 6;
        paramInt = 0;
        break;
      case 3: 
        i = k + 1;
        arrayOfByte[k] = ((byte)(m >> 10));
        paramInt = i + 1;
        arrayOfByte[i] = ((byte)(m >> 2));
        break;
      case 2: 
        arrayOfByte[k] = ((byte)(m >> 4));
        paramInt = k + 1;
        break;
      case 1: 
        ((b)localObject).e = 6;
        paramInt = 0;
        break;
      }
      ((b)localObject).e = i1;
      ((a)localObject).b = paramInt;
      paramInt = 1;
    }
    label827:
    if (paramInt != 0)
    {
      paramInt = ((a)localObject).b;
      paramString = ((a)localObject).a;
      if (paramInt == paramString.length) {
        return paramString;
      }
      localObject = new byte[paramInt];
      System.arraycopy(paramString, 0, localObject, 0, paramInt);
      return localObject;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static abstract class a
  {
    public byte[] a;
    public int b;
  }
  
  public static class b
    extends bu.a
  {
    public static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    public static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    public int e;
    public int f;
    public final int[] g;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {
        paramArrayOfByte = c;
      } else {
        paramArrayOfByte = d;
      }
      this.g = paramArrayOfByte;
      this.e = 0;
      this.f = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bu
 * JD-Core Version:    0.7.0.1
 */