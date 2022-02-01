package com.tencent.token;

final class atl
  extends atj
{
  private static final byte[] h = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] i = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  int c = 0;
  public final boolean d = true;
  public final boolean e = true;
  public final boolean f = false;
  private final byte[] j = new byte[2];
  private int k;
  private final byte[] l = h;
  
  public atl()
  {
    this.a = null;
    int m;
    if (this.e) {
      m = 19;
    } else {
      m = -1;
    }
    this.k = m;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = this.l;
    byte[] arrayOfByte2 = this.a;
    int n = this.k;
    int i5 = paramInt + 0;
    switch (this.c)
    {
    default: 
      break;
    case 2: 
      if (i5 > 0)
      {
        byte[] arrayOfByte3 = this.j;
        paramInt = arrayOfByte3[0];
        paramInt = (arrayOfByte3[1] & 0xFF) << 8 | (paramInt & 0xFF) << 16 | paramArrayOfByte[0] & 0xFF;
        this.c = 0;
        m = 1;
      }
      break;
    case 1: 
      if (2 <= i5)
      {
        paramInt = (this.j[0] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 8 | paramArrayOfByte[1] & 0xFF;
        this.c = 0;
        m = 2;
      }
      break;
    }
    paramInt = -1;
    int m = 0;
    if (paramInt != -1)
    {
      arrayOfByte2[0] = arrayOfByte1[(paramInt >> 18 & 0x3F)];
      arrayOfByte2[1] = arrayOfByte1[(paramInt >> 12 & 0x3F)];
      arrayOfByte2[2] = arrayOfByte1[(paramInt >> 6 & 0x3F)];
      arrayOfByte2[3] = arrayOfByte1[(paramInt & 0x3F)];
      n -= 1;
      if (n == 0)
      {
        if (this.f)
        {
          paramInt = 5;
          arrayOfByte2[4] = 13;
        }
        else
        {
          paramInt = 4;
        }
        i1 = paramInt + 1;
        arrayOfByte2[paramInt] = 10;
        n = 19;
        paramInt = i1;
      }
      else
      {
        paramInt = 4;
      }
    }
    else
    {
      paramInt = 0;
    }
    int i2;
    int i3;
    for (;;)
    {
      i1 = m + 3;
      if (i1 > i5) {
        break;
      }
      i2 = paramArrayOfByte[m];
      i3 = paramArrayOfByte[(m + 1)];
      m = paramArrayOfByte[(m + 2)] & 0xFF | (i3 & 0xFF) << 8 | (i2 & 0xFF) << 16;
      arrayOfByte2[paramInt] = arrayOfByte1[(m >> 18 & 0x3F)];
      arrayOfByte2[(paramInt + 1)] = arrayOfByte1[(m >> 12 & 0x3F)];
      arrayOfByte2[(paramInt + 2)] = arrayOfByte1[(m >> 6 & 0x3F)];
      arrayOfByte2[(paramInt + 3)] = arrayOfByte1[(m & 0x3F)];
      paramInt += 4;
      n -= 1;
      if (n == 0)
      {
        if (this.f)
        {
          m = paramInt + 1;
          arrayOfByte2[paramInt] = 13;
          paramInt = m;
        }
        i2 = paramInt + 1;
        arrayOfByte2[paramInt] = 10;
        m = i1;
        n = 19;
        paramInt = i2;
      }
      else
      {
        m = i1;
      }
    }
    int i1 = this.c;
    if (m - i1 == i5 - 1)
    {
      if (i1 > 0)
      {
        i2 = this.j[0];
        i1 = 1;
      }
      else
      {
        i2 = paramArrayOfByte[m];
        m += 1;
        i1 = 0;
      }
      i2 = (i2 & 0xFF) << 4;
      this.c -= i1;
      i3 = paramInt + 1;
      arrayOfByte2[paramInt] = arrayOfByte1[(i2 >> 6 & 0x3F)];
      i1 = i3 + 1;
      arrayOfByte2[i3] = arrayOfByte1[(i2 & 0x3F)];
      paramInt = i1;
      if (this.d)
      {
        i2 = i1 + 1;
        arrayOfByte2[i1] = 61;
        paramInt = i2 + 1;
        arrayOfByte2[i2] = 61;
      }
      i1 = paramInt;
      i2 = m;
      if (this.e)
      {
        if (this.f)
        {
          i1 = paramInt + 1;
          arrayOfByte2[paramInt] = 13;
          paramInt = i1;
        }
        arrayOfByte2[paramInt] = 10;
        i1 = paramInt + 1;
        i2 = m;
      }
    }
    else if (m - i1 == i5 - 2)
    {
      if (i1 > 1)
      {
        i2 = this.j[0];
        i1 = 1;
      }
      else
      {
        i2 = m + 1;
        i3 = paramArrayOfByte[m];
        i1 = 0;
        m = i2;
        i2 = i3;
      }
      if (this.c > 0)
      {
        i3 = this.j[i1];
        i1 += 1;
      }
      else
      {
        int i4 = m + 1;
        i3 = paramArrayOfByte[m];
        m = i4;
      }
      i2 = (i2 & 0xFF) << 10 | (i3 & 0xFF) << 2;
      this.c -= i1;
      i1 = paramInt + 1;
      arrayOfByte2[paramInt] = arrayOfByte1[(i2 >> 12 & 0x3F)];
      i3 = i1 + 1;
      arrayOfByte2[i1] = arrayOfByte1[(i2 >> 6 & 0x3F)];
      paramInt = i3 + 1;
      arrayOfByte2[i3] = arrayOfByte1[(i2 & 0x3F)];
      if (this.d)
      {
        i1 = paramInt + 1;
        arrayOfByte2[paramInt] = 61;
        paramInt = i1;
      }
      if (this.e)
      {
        i1 = paramInt;
        if (this.f)
        {
          arrayOfByte2[paramInt] = 13;
          i1 = paramInt + 1;
        }
        arrayOfByte2[i1] = 10;
        i1 += 1;
      }
      else
      {
        i1 = paramInt;
      }
      i2 = m;
    }
    else
    {
      i1 = paramInt;
      i2 = m;
      if (this.e)
      {
        i1 = paramInt;
        i2 = m;
        if (paramInt > 0)
        {
          i1 = paramInt;
          i2 = m;
          if (n != 19)
          {
            if (this.f)
            {
              i1 = paramInt + 1;
              arrayOfByte2[paramInt] = 13;
              paramInt = i1;
            }
            i1 = paramInt + 1;
            arrayOfByte2[paramInt] = 10;
            i2 = m;
          }
        }
      }
    }
    if ((!g) && (this.c != 0)) {
      throw new AssertionError();
    }
    if ((!g) && (i2 != i5)) {
      throw new AssertionError();
    }
    this.b = i1;
    this.k = n;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.atl
 * JD-Core Version:    0.7.0.1
 */