package com.tencent.turingfd.sdk.base;

public class cn
{
  static
  {
    cn.class.desiredAssertionStatus();
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    paramString = paramString.getBytes();
    int i = 0;
    int j = paramString.length;
    Object localObject = new cp(paramInt, new byte[j * 3 / 4]);
    int k = ((cp)localObject).e;
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
      paramInt = ((co)localObject).b;
      paramString = ((co)localObject).a;
      if (paramInt == paramString.length) {
        return paramString;
      }
    }
    else
    {
      int i3 = j + 0;
      j = ((cp)localObject).f;
      m = 0;
      arrayOfByte = ((co)localObject).a;
      arrayOfInt = ((cp)localObject).g;
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
          ((cp)localObject).e = k;
          ((co)localObject).b = paramInt;
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
              ((cp)localObject).e = 6;
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
                ((cp)localObject).e = 6;
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
                  ((cp)localObject).e = 6;
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
                    ((cp)localObject).e = 6;
                    paramInt = 0;
                    break;
                  } while (j >= 0);
                  if (j == -1) {
                    break label376;
                  }
                  ((cp)localObject).e = 6;
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
          ((cp)localObject).e = 6;
          paramInt = 0;
          break;
          ((cp)localObject).e = 6;
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
      ((cp)localObject).e = 6;
      paramInt = 0;
      break;
      localObject = new byte[paramInt];
      System.arraycopy(paramString, 0, localObject, 0, paramInt);
      return localObject;
      throw new IllegalArgumentException("bad base-64");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cn
 * JD-Core Version:    0.7.0.1
 */