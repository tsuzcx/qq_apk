package com.tencent.acstat.common;

class g
  extends f
{
  private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int e;
  private int f;
  private final int[] g;
  
  public g(int paramInt, byte[] paramArrayOfByte)
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
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.e == 6) {
      return false;
    }
    int i1 = paramInt2 + paramInt1;
    paramInt2 = this.e;
    int i = this.f;
    int j = 0;
    byte[] arrayOfByte = this.a;
    int[] arrayOfInt = this.g;
    int m = j;
    int n = i;
    if (paramInt1 < i1)
    {
      int k = j;
      m = i;
      n = paramInt1;
      if (paramInt2 == 0)
      {
        k = paramInt1;
        for (paramInt1 = i; k + 4 <= i1; paramInt1 = i)
        {
          i = arrayOfInt[(paramArrayOfByte[k] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(k + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(k + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(k + 3)] & 0xFF)];
          paramInt1 = i;
          if (i < 0) {
            break;
          }
          arrayOfByte[(j + 2)] = ((byte)i);
          arrayOfByte[(j + 1)] = ((byte)(i >> 8));
          arrayOfByte[j] = ((byte)(i >> 16));
          j += 3;
          k += 4;
        }
        m = j;
        n = paramInt1;
        if (k < i1)
        {
          n = k;
          m = paramInt1;
          k = j;
        }
      }
      else
      {
        paramInt1 = n + 1;
        i = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
        switch (paramInt2)
        {
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    j = k;
                    i = m;
                    break;
                    if (i >= 0)
                    {
                      paramInt2 += 1;
                      j = k;
                      break;
                    }
                  } while (i == -1);
                  this.e = 6;
                  return false;
                  if (i >= 0)
                  {
                    i = m << 6 | i;
                    paramInt2 += 1;
                    j = k;
                    break;
                  }
                } while (i == -1);
                this.e = 6;
                return false;
                if (i >= 0)
                {
                  i = m << 6 | i;
                  paramInt2 += 1;
                  j = k;
                  break;
                }
                if (i == -2)
                {
                  arrayOfByte[k] = ((byte)(m >> 4));
                  paramInt2 = 4;
                  j = k + 1;
                  i = m;
                  break;
                }
              } while (i == -1);
              this.e = 6;
              return false;
              if (i >= 0)
              {
                i = m << 6 | i;
                arrayOfByte[(k + 2)] = ((byte)i);
                arrayOfByte[(k + 1)] = ((byte)(i >> 8));
                arrayOfByte[k] = ((byte)(i >> 16));
                j = k + 3;
                paramInt2 = 0;
                break;
              }
              if (i == -2)
              {
                arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                arrayOfByte[k] = ((byte)(m >> 10));
                j = k + 2;
                paramInt2 = 5;
                i = m;
                break;
              }
            } while (i == -1);
            this.e = 6;
            return false;
            if (i == -2)
            {
              paramInt2 += 1;
              j = k;
              i = m;
              break;
            }
          } while (i == -1);
          this.e = 6;
          return false;
        } while (i == -1);
        this.e = 6;
        return false;
      }
    }
    if (!paramBoolean)
    {
      this.e = paramInt2;
      this.f = n;
      this.b = m;
      return true;
    }
    paramInt1 = m;
    switch (paramInt2)
    {
    default: 
      paramInt1 = m;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        this.e = paramInt2;
        this.b = paramInt1;
        return true;
        this.e = 6;
        return false;
        arrayOfByte[m] = ((byte)(n >> 4));
        paramInt1 = m + 1;
        continue;
        i = m + 1;
        arrayOfByte[m] = ((byte)(n >> 10));
        paramInt1 = i + 1;
        arrayOfByte[i] = ((byte)(n >> 2));
      }
    }
    this.e = 6;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.common.g
 * JD-Core Version:    0.7.0.1
 */