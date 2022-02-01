package wf7;

class de$c
  extends de.a
{
  private static final byte[] kb = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] kc = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private int count;
  private final byte[] kd;
  int ke;
  public final boolean kf;
  public final boolean kg;
  public final boolean kh;
  private final byte[] ki;
  
  public de$c(int paramInt, byte[] paramArrayOfByte)
  {
    this.jW = paramArrayOfByte;
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt & 0x1) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.kf = bool1;
    if ((paramInt & 0x2) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.kg = bool1;
    if ((paramInt & 0x4) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.kh = bool1;
    if ((paramInt & 0x8) == 0) {
      paramArrayOfByte = kb;
    } else {
      paramArrayOfByte = kc;
    }
    this.ki = paramArrayOfByte;
    this.kd = new byte[2];
    this.ke = 0;
    if (this.kg) {
      paramInt = 19;
    } else {
      paramInt = -1;
    }
    this.count = paramInt;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.ki;
    byte[] arrayOfByte2 = this.jW;
    int j = this.count;
    int i1 = paramInt2 + paramInt1;
    paramInt2 = this.ke;
    int n = 0;
    int m = 0;
    int k;
    if (paramInt2 != 0) {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          paramInt2 = paramInt1 + 1;
          if (paramInt2 <= i1)
          {
            byte[] arrayOfByte3 = this.kd;
            i = arrayOfByte3[0];
            k = arrayOfByte3[1];
            paramInt1 = paramArrayOfByte[paramInt1];
            this.ke = 0;
            paramInt1 = (k & 0xFF) << 8 | (i & 0xFF) << 16 | paramInt1 & 0xFF;
            break label191;
          }
        }
      }
      else if (paramInt1 + 2 <= i1)
      {
        i = this.kd[0];
        k = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        paramInt2 = k + 1;
        paramInt1 = (i & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | paramArrayOfByte[k] & 0xFF;
        this.ke = 0;
        break label191;
      }
    }
    int i = -1;
    paramInt2 = paramInt1;
    paramInt1 = i;
    label191:
    if (paramInt1 != -1)
    {
      arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
      arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
      arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
      arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
      j -= 1;
      if (j == 0)
      {
        if (this.kh)
        {
          paramInt1 = 5;
          arrayOfByte2[4] = 13;
        }
        else
        {
          paramInt1 = 4;
        }
        i = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt1 = i;
        j = 19;
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
      i = paramInt2 + 3;
      if (i > i1) {
        break label480;
      }
      k = paramArrayOfByte[paramInt2];
      paramInt2 = (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | (k & 0xFF) << 16 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
      arrayOfByte2[paramInt1] = arrayOfByte1[(paramInt2 >> 18 & 0x3F)];
      arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(paramInt2 >> 12 & 0x3F)];
      arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(paramInt2 >> 6 & 0x3F)];
      arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(paramInt2 & 0x3F)];
      paramInt1 += 4;
      j -= 1;
      if (j == 0)
      {
        if (this.kh)
        {
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = paramInt2;
        }
        j = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt2 = i;
        paramInt1 = j;
        break;
      }
      paramInt2 = i;
    }
    label480:
    if (paramBoolean)
    {
      i = this.ke;
      if (paramInt2 - i == i1 - 1)
      {
        if (i > 0)
        {
          k = this.kd[0];
          i = 1;
        }
        else
        {
          k = paramArrayOfByte[paramInt2];
          paramInt2 += 1;
          i = m;
        }
        k = (k & 0xFF) << 4;
        this.ke -= i;
        m = paramInt1 + 1;
        arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 6 & 0x3F)];
        i = m + 1;
        arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
        paramInt1 = i;
        if (this.kf)
        {
          k = i + 1;
          arrayOfByte2[i] = 61;
          paramInt1 = k + 1;
          arrayOfByte2[k] = 61;
        }
        i = paramInt1;
        k = paramInt2;
        if (this.kg)
        {
          if (this.kh)
          {
            i = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = i;
          }
          i = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          k = paramInt2;
        }
      }
      else if (paramInt2 - i == i1 - 2)
      {
        if (i > 1)
        {
          k = this.kd[0];
          i = 1;
        }
        else
        {
          k = paramArrayOfByte[paramInt2];
          paramInt2 += 1;
          i = n;
        }
        if (this.ke > 0)
        {
          paramArrayOfByte = this.kd;
          n = i + 1;
          m = paramArrayOfByte[i];
          i = n;
        }
        else
        {
          n = paramInt2 + 1;
          m = paramArrayOfByte[paramInt2];
          paramInt2 = n;
        }
        k = (k & 0xFF) << 10 | (m & 0xFF) << 2;
        this.ke -= i;
        i = paramInt1 + 1;
        arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 12 & 0x3F)];
        m = i + 1;
        arrayOfByte2[i] = arrayOfByte1[(k >> 6 & 0x3F)];
        paramInt1 = m + 1;
        arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
        if (this.kf)
        {
          i = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 61;
          paramInt1 = i;
        }
        i = paramInt1;
        if (this.kg)
        {
          i = paramInt1;
          if (this.kh)
          {
            arrayOfByte2[paramInt1] = 13;
            i = paramInt1 + 1;
          }
          arrayOfByte2[i] = 10;
          i += 1;
        }
        k = paramInt2;
      }
      else
      {
        i = paramInt1;
        k = paramInt2;
        if (this.kg)
        {
          i = paramInt1;
          k = paramInt2;
          if (paramInt1 > 0)
          {
            i = paramInt1;
            k = paramInt2;
            if (j != 19)
            {
              if (this.kh)
              {
                i = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = i;
              }
              i = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 10;
              k = paramInt2;
            }
          }
        }
      }
      if ((!cF) && (this.ke != 0)) {
        throw new AssertionError();
      }
      m = i;
      if (!cF) {
        if (k == i1) {
          m = i;
        } else {
          throw new AssertionError();
        }
      }
    }
    else if (paramInt2 == i1 - 1)
    {
      arrayOfByte1 = this.kd;
      i = this.ke;
      this.ke = (i + 1);
      arrayOfByte1[i] = paramArrayOfByte[paramInt2];
      m = paramInt1;
    }
    else
    {
      m = paramInt1;
      if (paramInt2 == i1 - 2)
      {
        arrayOfByte1 = this.kd;
        i = this.ke;
        this.ke = (i + 1);
        arrayOfByte1[i] = paramArrayOfByte[paramInt2];
        i = this.ke;
        this.ke = (i + 1);
        arrayOfByte1[i] = paramArrayOfByte[(paramInt2 + 1)];
        m = paramInt1;
      }
    }
    this.jX = m;
    this.count = j;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.de.c
 * JD-Core Version:    0.7.0.1
 */