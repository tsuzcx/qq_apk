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
    int i = 0;
    int j = paramString.length;
    Object localObject = new b(paramInt, new byte[j * 3 / 4]);
    int k = ((b)localObject).e;
    int m;
    byte[] arrayOfByte;
    int[] arrayOfInt;
    label100:
    int n;
    int i2;
    if (k == 6)
    {
      paramInt = 0;
      if (paramInt == 0) {
        break label771;
      }
      paramInt = ((a)localObject).b;
      paramString = ((a)localObject).a;
      if (paramInt == paramString.length) {
        return paramString;
      }
    }
    else
    {
      int i3 = j + 0;
      j = ((b)localObject).f;
      m = 0;
      arrayOfByte = ((a)localObject).a;
      arrayOfInt = ((b)localObject).g;
      paramInt = i;
      i = m;
      if (paramInt >= i3) {
        break label781;
      }
      m = i;
      n = j;
      i2 = paramInt;
      if (k == 0)
      {
        int i1 = paramInt;
        for (paramInt = j;; paramInt = j)
        {
          m = i1 + 4;
          if (m > i3) {
            break;
          }
          j = arrayOfInt[(paramString[i1] & 0xFF)] << 18 | arrayOfInt[(paramString[(i1 + 1)] & 0xFF)] << 12 | arrayOfInt[(paramString[(i1 + 2)] & 0xFF)] << 6 | arrayOfInt[(paramString[(i1 + 3)] & 0xFF)];
          paramInt = j;
          if (j < 0) {
            break;
          }
          arrayOfByte[(i + 2)] = ((byte)j);
          arrayOfByte[(i + 1)] = ((byte)(j >> 8));
          arrayOfByte[i] = ((byte)(j >> 16));
          i += 3;
          i1 = m;
        }
        m = i;
        n = paramInt;
        i2 = i1;
        if (i1 >= i3) {
          j = paramInt;
        }
      }
    }
    label385:
    label771:
    label781:
    for (;;)
    {
      paramInt = i;
      switch (k)
      {
      default: 
        paramInt = i;
      case 0: 
      case 4: 
      case 3: 
      case 2: 
        for (;;)
        {
          ((b)localObject).e = k;
          ((a)localObject).b = paramInt;
          paramInt = 1;
          break;
          j = arrayOfInt[(paramString[i2] & 0xFF)];
          switch (k)
          {
          }
          label376:
          do
          {
            paramInt = k;
            j = n;
            i = m;
            for (;;)
            {
              k = paramInt;
              paramInt = i2 + 1;
              break label100;
              if (j == -1) {
                break label376;
              }
              ((b)localObject).e = 6;
              paramInt = 0;
              break;
              if (j == -2)
              {
                paramInt = k + 1;
                i = m;
                j = n;
              }
              else
              {
                if (j == -1) {
                  break label376;
                }
                ((b)localObject).e = 6;
                paramInt = 0;
                break;
                if (j >= 0)
                {
                  j = n << 6 | j;
                  arrayOfByte[(m + 2)] = ((byte)j);
                  arrayOfByte[(m + 1)] = ((byte)(j >> 8));
                  arrayOfByte[m] = ((byte)(j >> 16));
                  i = m + 3;
                  paramInt = 0;
                }
                else if (j == -2)
                {
                  arrayOfByte[(m + 1)] = ((byte)(n >> 2));
                  arrayOfByte[m] = ((byte)(n >> 10));
                  i = m + 2;
                  paramInt = 5;
                  j = n;
                }
                else
                {
                  if (j == -1) {
                    break label376;
                  }
                  ((b)localObject).e = 6;
                  paramInt = 0;
                  break;
                  if (j >= 0) {}
                  do
                  {
                    j = n << 6 | j;
                    paramInt = k + 1;
                    i = m;
                    break label385;
                    if (j == -2)
                    {
                      arrayOfByte[m] = ((byte)(n >> 4));
                      paramInt = 4;
                      i = m + 1;
                      j = n;
                      break label385;
                    }
                    if (j == -1) {
                      break label376;
                    }
                    ((b)localObject).e = 6;
                    paramInt = 0;
                    break;
                  } while (j >= 0);
                  if (j == -1) {
                    break label376;
                  }
                  ((b)localObject).e = 6;
                  paramInt = 0;
                  break;
                  if (j < 0) {
                    break label667;
                  }
                  paramInt = k + 1;
                  i = m;
                }
              }
            }
          } while (j == -1);
          label667:
          ((b)localObject).e = 6;
          paramInt = 0;
          break;
          ((b)localObject).e = 6;
          paramInt = 0;
          break;
          m = i + 1;
          arrayOfByte[i] = ((byte)(j >> 10));
          paramInt = m + 1;
          arrayOfByte[m] = ((byte)(j >> 2));
          continue;
          arrayOfByte[i] = ((byte)(j >> 4));
          paramInt = i + 1;
        }
      }
      ((b)localObject).e = 6;
      paramInt = 0;
      break;
      localObject = new byte[paramInt];
      System.arraycopy(paramString, 0, localObject, 0, paramInt);
      return localObject;
      throw new IllegalArgumentException("bad base-64");
    }
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
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = c;; paramArrayOfByte = d)
      {
        this.g = paramArrayOfByte;
        this.e = 0;
        this.f = 0;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bu
 * JD-Core Version:    0.7.0.1
 */