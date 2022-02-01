package com.android.safeguard;

class f
  extends e
{
  private static final byte[] h = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] i = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  int c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  private final byte[] j;
  private int k;
  private final byte[] l;
  
  public f(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt & 0x1) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    if ((paramInt & 0x2) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if ((paramInt & 0x4) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if ((paramInt & 0x8) == 0) {
      paramArrayOfByte = h;
    } else {
      paramArrayOfByte = i;
    }
    this.l = paramArrayOfByte;
    this.j = new byte[2];
    this.c = 0;
    if (this.e) {
      paramInt = 19;
    } else {
      paramInt = -1;
    }
    this.k = paramInt;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.l;
    byte[] arrayOfByte2 = this.a;
    int n = this.k;
    int i4 = paramInt2 + paramInt1;
    int i1;
    switch (this.c)
    {
    default: 
      break;
    case 2: 
      m = paramInt1 + 1;
      if (m <= i4)
      {
        byte[] arrayOfByte3 = this.j;
        paramInt2 = arrayOfByte3[0];
        i1 = arrayOfByte3[1];
        paramInt1 = paramArrayOfByte[paramInt1];
        this.c = 0;
        paramInt1 = (i1 & 0xFF) << 8 | (paramInt2 & 0xFF) << 16 | paramInt1 & 0xFF;
      }
      break;
    case 1: 
      if (paramInt1 + 2 <= i4)
      {
        paramInt2 = this.j[0];
        i1 = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        m = i1 + 1;
        paramInt1 = (paramInt2 & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | paramArrayOfByte[i1] & 0xFF;
        this.c = 0;
      }
      break;
    }
    paramInt2 = -1;
    int m = paramInt1;
    paramInt1 = paramInt2;
    if (paramInt1 != -1)
    {
      arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
      arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
      arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
      arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
      n -= 1;
      if (n == 0)
      {
        if (this.f)
        {
          paramInt1 = 5;
          arrayOfByte2[4] = 13;
        }
        else
        {
          paramInt1 = 4;
        }
        paramInt2 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        n = 19;
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = 4;
      }
    }
    else
    {
      paramInt1 = 0;
    }
    for (;;)
    {
      int i3 = 0;
      int i2 = 0;
      paramInt2 = m + 3;
      if (paramInt2 > i4)
      {
        if (paramBoolean)
        {
          paramInt2 = this.c;
          if (m - paramInt2 == i4 - 1)
          {
            if (paramInt2 > 0)
            {
              i1 = this.j[0];
              paramInt2 = 1;
            }
            else
            {
              i1 = paramArrayOfByte[m];
              m += 1;
              paramInt2 = i2;
            }
            i1 = (i1 & 0xFF) << 4;
            this.c -= paramInt2;
            i2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 6 & 0x3F)];
            paramInt2 = i2 + 1;
            arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
            paramInt1 = paramInt2;
            if (this.d)
            {
              i1 = paramInt2 + 1;
              arrayOfByte2[paramInt2] = 61;
              paramInt1 = i1 + 1;
              arrayOfByte2[i1] = 61;
            }
            paramInt2 = paramInt1;
            i1 = m;
            if (this.e)
            {
              if (this.f)
              {
                paramInt2 = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = paramInt2;
              }
              paramInt2 = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 10;
              i1 = m;
            }
          }
          else if (m - paramInt2 == i4 - 2)
          {
            if (paramInt2 > 1)
            {
              i1 = this.j[0];
              paramInt2 = 1;
            }
            else
            {
              i1 = paramArrayOfByte[m];
              m += 1;
              paramInt2 = i3;
            }
            if (this.c > 0)
            {
              paramArrayOfByte = this.j;
              i2 = paramInt2 + 1;
              paramInt2 = paramArrayOfByte[paramInt2];
            }
            else
            {
              i3 = paramArrayOfByte[m];
              i2 = paramInt2;
              paramInt2 = i3;
              m += 1;
            }
            paramInt2 = (i1 & 0xFF) << 10 | (paramInt2 & 0xFF) << 2;
            this.c -= i2;
            i1 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = arrayOfByte1[(paramInt2 >> 12 & 0x3F)];
            i2 = i1 + 1;
            arrayOfByte2[i1] = arrayOfByte1[(paramInt2 >> 6 & 0x3F)];
            paramInt1 = i2 + 1;
            arrayOfByte2[i2] = arrayOfByte1[(paramInt2 & 0x3F)];
            if (this.d)
            {
              paramInt2 = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 61;
              paramInt1 = paramInt2;
            }
            if (this.e)
            {
              paramInt2 = paramInt1;
              if (this.f)
              {
                arrayOfByte2[paramInt1] = 13;
                paramInt2 = paramInt1 + 1;
              }
              paramInt1 = paramInt2 + 1;
              arrayOfByte2[paramInt2] = 10;
              paramInt2 = paramInt1;
              i1 = m;
            }
            else
            {
              paramInt2 = paramInt1;
              i1 = m;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            i1 = m;
            if (this.e)
            {
              paramInt2 = paramInt1;
              i1 = m;
              if (paramInt1 > 0)
              {
                paramInt2 = paramInt1;
                i1 = m;
                if (n != 19)
                {
                  if (this.f)
                  {
                    paramInt2 = paramInt1 + 1;
                    arrayOfByte2[paramInt1] = 13;
                    paramInt1 = paramInt2;
                  }
                  paramInt2 = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 10;
                  i1 = m;
                }
              }
            }
          }
          if ((!g) && (this.c != 0)) {
            throw new AssertionError();
          }
          i2 = paramInt2;
          if (!g) {
            if (i1 == i4) {
              i2 = paramInt2;
            } else {
              throw new AssertionError();
            }
          }
        }
        else if (m == i4 - 1)
        {
          arrayOfByte1 = this.j;
          paramInt2 = this.c;
          this.c = (paramInt2 + 1);
          arrayOfByte1[paramInt2] = paramArrayOfByte[m];
          i2 = paramInt1;
        }
        else
        {
          i2 = paramInt1;
          if (m == i4 - 2)
          {
            arrayOfByte1 = this.j;
            paramInt2 = this.c;
            this.c = (paramInt2 + 1);
            arrayOfByte1[paramInt2] = paramArrayOfByte[m];
            paramInt2 = this.c;
            this.c = (paramInt2 + 1);
            arrayOfByte1[paramInt2] = paramArrayOfByte[(m + 1)];
            i2 = paramInt1;
          }
        }
        this.b = i2;
        this.k = n;
        return true;
      }
      i1 = paramArrayOfByte[m];
      m = (paramArrayOfByte[(m + 1)] & 0xFF) << 8 | (i1 & 0xFF) << 16 | paramArrayOfByte[(m + 2)] & 0xFF;
      arrayOfByte2[paramInt1] = arrayOfByte1[(m >> 18 & 0x3F)];
      arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(m >> 12 & 0x3F)];
      arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(m >> 6 & 0x3F)];
      arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(m & 0x3F)];
      paramInt1 += 4;
      n -= 1;
      if (n == 0)
      {
        if (this.f)
        {
          m = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = m;
        }
        m = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        n = 19;
        paramInt1 = m;
      }
      m = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.f
 * JD-Core Version:    0.7.0.1
 */