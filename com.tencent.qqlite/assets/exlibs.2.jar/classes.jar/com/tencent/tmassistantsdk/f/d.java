package com.tencent.tmassistantsdk.f;

final class d
  extends b
{
  private static final byte[] f;
  private static final byte[] g;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  private final byte[] h;
  private int i;
  private int j;
  private final byte[] k;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      f = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      g = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      return;
    }
  }
  
  public d(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = null;
    boolean bool1;
    if ((paramInt & 0x1) == 0)
    {
      bool1 = true;
      this.c = bool1;
      if ((paramInt & 0x2) != 0) {
        break label101;
      }
      bool1 = true;
      label33:
      this.d = bool1;
      if ((paramInt & 0x4) == 0) {
        break label106;
      }
      bool1 = bool2;
      label47:
      this.e = bool1;
      if ((paramInt & 0x8) != 0) {
        break label111;
      }
      paramArrayOfByte = f;
      label63:
      this.k = paramArrayOfByte;
      this.h = new byte[2];
      this.i = 0;
      if (!this.d) {
        break label118;
      }
    }
    label101:
    label106:
    label111:
    label118:
    for (paramInt = 19;; paramInt = -1)
    {
      this.j = paramInt;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label33;
      bool1 = false;
      break label47;
      paramArrayOfByte = g;
      break label63;
    }
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.k;
    byte[] arrayOfByte2 = this.a;
    int n = 0;
    int m = this.j;
    int i3 = paramInt2 + paramInt1;
    int i1;
    switch (this.i)
    {
    default: 
      i1 = -1;
      paramInt2 = paramInt1;
      paramInt1 = i1;
      label64:
      if (paramInt1 != -1)
      {
        arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
        arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
        arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
        n = 4;
        arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
        m -= 1;
        if (m == 0)
        {
          paramInt1 = n;
          if (this.e)
          {
            paramInt1 = 5;
            arrayOfByte2[4] = 13;
          }
          n = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          m = 19;
          paramInt1 = n;
        }
      }
      break;
    }
    for (;;)
    {
      label172:
      if (paramInt2 + 3 <= i3)
      {
        n = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
        arrayOfByte2[paramInt1] = arrayOfByte1[(n >> 18 & 0x3F)];
        arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(n >> 12 & 0x3F)];
        arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(n >> 6 & 0x3F)];
        arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(n & 0x3F)];
        paramInt2 += 3;
        paramInt1 += 4;
        m -= 1;
        if (m != 0) {
          break label1063;
        }
        if (!this.e) {
          break label1060;
        }
        m = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 13;
        paramInt1 = m;
      }
      label1057:
      label1060:
      for (;;)
      {
        m = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        n = 19;
        paramInt1 = m;
        m = n;
        break label172;
        i1 = -1;
        paramInt2 = paramInt1;
        paramInt1 = i1;
        break label64;
        if (paramInt1 + 2 > i3) {
          break;
        }
        i1 = this.h[0];
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        int i2 = paramArrayOfByte[paramInt2];
        this.i = 0;
        paramInt1 = (i1 & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | i2 & 0xFF;
        paramInt2 += 1;
        break label64;
        if (paramInt1 + 1 > i3) {
          break;
        }
        i1 = this.h[0];
        i2 = this.h[1];
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        this.i = 0;
        paramInt1 = (i1 & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramInt1 & 0xFF;
        break label64;
        if (paramInt2 - this.i == i3 - 1)
        {
          if (this.i > 0)
          {
            paramArrayOfByte = this.h;
            n = 1;
            i1 = paramArrayOfByte[0];
          }
          for (;;)
          {
            i1 = (i1 & 0xFF) << 4;
            this.i -= n;
            i2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 6 & 0x3F)];
            n = i2 + 1;
            arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
            paramInt1 = n;
            if (this.c)
            {
              i1 = n + 1;
              arrayOfByte2[n] = 61;
              paramInt1 = i1 + 1;
              arrayOfByte2[i1] = 61;
            }
            n = paramInt1;
            if (this.d)
            {
              n = paramInt1;
              if (this.e)
              {
                arrayOfByte2[paramInt1] = 13;
                n = paramInt1 + 1;
              }
              arrayOfByte2[n] = 10;
              n += 1;
            }
            i1 = paramInt2;
            if ((l) || (this.i == 0)) {
              break;
            }
            throw new AssertionError();
            i1 = paramArrayOfByte[paramInt2];
            paramInt2 += 1;
            n = 0;
          }
        }
        if (paramInt2 - this.i == i3 - 2) {
          if (this.i > 1)
          {
            byte[] arrayOfByte3 = this.h;
            n = 1;
            i1 = arrayOfByte3[0];
            label734:
            if (this.i <= 0) {
              break label933;
            }
            i2 = this.h[n];
            n += 1;
            label756:
            i1 = (i2 & 0xFF) << 2 | (i1 & 0xFF) << 10;
            this.i -= n;
            n = paramInt1 + 1;
            arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 12 & 0x3F)];
            i2 = n + 1;
            arrayOfByte2[n] = arrayOfByte1[(i1 >> 6 & 0x3F)];
            paramInt1 = i2 + 1;
            arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
            if (!this.c) {
              break label1057;
            }
            n = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 61;
            paramInt1 = n;
          }
        }
        for (;;)
        {
          n = paramInt1;
          if (this.d)
          {
            n = paramInt1;
            if (this.e)
            {
              arrayOfByte2[paramInt1] = 13;
              n = paramInt1 + 1;
            }
            arrayOfByte2[n] = 10;
            n += 1;
          }
          i1 = paramInt2;
          break;
          i1 = paramArrayOfByte[paramInt2];
          paramInt2 += 1;
          n = 0;
          break label734;
          label933:
          i2 = paramArrayOfByte[paramInt2];
          paramInt2 += 1;
          break label756;
          i1 = paramInt2;
          n = paramInt1;
          if (!this.d) {
            break;
          }
          i1 = paramInt2;
          n = paramInt1;
          if (paramInt1 <= 0) {
            break;
          }
          i1 = paramInt2;
          n = paramInt1;
          if (m == 19) {
            break;
          }
          if (this.e)
          {
            n = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = n;
          }
          for (;;)
          {
            n = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 10;
            i1 = paramInt2;
            break;
            if ((!l) && (i1 != i3)) {
              throw new AssertionError();
            }
            this.b = n;
            this.j = m;
            return true;
          }
        }
      }
      label1063:
      continue;
      paramInt1 = 4;
      continue;
      paramInt1 = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.d
 * JD-Core Version:    0.7.0.1
 */