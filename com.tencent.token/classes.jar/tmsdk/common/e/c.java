package tmsdk.common.e;

class c
  extends b
{
  private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private int e;
  private int f;
  private final int[] g;
  
  public c(int paramInt, byte[] paramArrayOfByte)
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
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int n = this.e;
    if (n == 6) {
      return false;
    }
    int i2 = paramInt2 + paramInt1;
    paramInt2 = this.f;
    byte[] arrayOfByte = this.a;
    int[] arrayOfInt = this.g;
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    int k;
    for (;;)
    {
      k = paramInt2;
      j = paramInt1;
      if (i >= i2) {
        break;
      }
      k = paramInt2;
      j = paramInt1;
      int m = i;
      if (n == 0)
      {
        for (;;)
        {
          k = i + 4;
          if (k > i2) {
            break;
          }
          j = arrayOfInt[(paramArrayOfByte[i] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(i + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(i + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(i + 3)] & 0xFF)];
          paramInt2 = j;
          if (j < 0) {
            break;
          }
          arrayOfByte[(paramInt1 + 2)] = ((byte)j);
          arrayOfByte[(paramInt1 + 1)] = ((byte)(j >> 8));
          arrayOfByte[paramInt1] = ((byte)(j >> 16));
          paramInt1 += 3;
          i = k;
          paramInt2 = j;
        }
        k = paramInt2;
        j = paramInt1;
        m = i;
        if (i >= i2)
        {
          k = paramInt2;
          j = paramInt1;
          break;
        }
      }
      int i1 = arrayOfInt[(paramArrayOfByte[m] & 0xFF)];
      switch (n)
      {
      default: 
        paramInt1 = n;
        paramInt2 = k;
        i = j;
        break;
      case 5: 
        paramInt1 = n;
        paramInt2 = k;
        i = j;
        if (i1 != -1)
        {
          this.e = 6;
          return false;
        }
        break;
      case 4: 
        if (i1 == -2)
        {
          paramInt1 = n + 1;
          paramInt2 = k;
          i = j;
        }
        else
        {
          paramInt1 = n;
          paramInt2 = k;
          i = j;
          if (i1 != -1)
          {
            this.e = 6;
            return false;
          }
        }
        break;
      case 3: 
        if (i1 >= 0)
        {
          paramInt2 = i1 | k << 6;
          arrayOfByte[(j + 2)] = ((byte)paramInt2);
          arrayOfByte[(j + 1)] = ((byte)(paramInt2 >> 8));
          arrayOfByte[j] = ((byte)(paramInt2 >> 16));
          i = j + 3;
          paramInt1 = 0;
        }
        else if (i1 == -2)
        {
          arrayOfByte[(j + 1)] = ((byte)(k >> 2));
          arrayOfByte[j] = ((byte)(k >> 10));
          i = j + 2;
          paramInt1 = 5;
          paramInt2 = k;
        }
        else
        {
          paramInt1 = n;
          paramInt2 = k;
          i = j;
          if (i1 != -1)
          {
            this.e = 6;
            return false;
          }
        }
        break;
      case 2: 
        if (i1 >= 0)
        {
          paramInt1 = n + 1;
          paramInt2 = i1 | k << 6;
          i = j;
        }
        else if (i1 == -2)
        {
          arrayOfByte[j] = ((byte)(k >> 4));
          i = j + 1;
          paramInt1 = 4;
          paramInt2 = k;
        }
        else
        {
          paramInt1 = n;
          paramInt2 = k;
          i = j;
          if (i1 != -1)
          {
            this.e = 6;
            return false;
          }
        }
        break;
      case 1: 
        if (i1 >= 0)
        {
          paramInt1 = n + 1;
          paramInt2 = i1 | k << 6;
          i = j;
        }
        else
        {
          paramInt1 = n;
          paramInt2 = k;
          i = j;
          if (i1 != -1)
          {
            this.e = 6;
            return false;
          }
        }
        break;
      case 0: 
        if (i1 >= 0)
        {
          paramInt1 = n + 1;
          paramInt2 = i1;
          i = j;
        }
        else
        {
          paramInt1 = n;
          paramInt2 = k;
          i = j;
          if (i1 != -1)
          {
            this.e = 6;
            return false;
          }
        }
        break;
      }
      j = m + 1;
      n = paramInt1;
      paramInt1 = i;
      i = j;
    }
    if (!paramBoolean)
    {
      this.e = n;
      this.f = k;
      this.b = j;
      return true;
    }
    paramInt1 = j;
    switch (n)
    {
    default: 
      paramInt1 = j;
      break;
    case 4: 
      this.e = 6;
      return false;
    case 3: 
      paramInt2 = j + 1;
      arrayOfByte[j] = ((byte)(k >> 10));
      paramInt1 = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(k >> 2));
      break;
    case 2: 
      arrayOfByte[j] = ((byte)(k >> 4));
      paramInt1 = j + 1;
      break;
    case 1: 
      this.e = 6;
      return false;
    }
    this.e = n;
    this.b = paramInt1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.e.c
 * JD-Core Version:    0.7.0.1
 */