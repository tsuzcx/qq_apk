package btmsdkobf;

import java.io.UnsupportedEncodingException;

public class dw
{
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localb.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localb.b == localb.a.length) {
        return localb.a;
      }
      paramArrayOfByte = new byte[localb.b];
      System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    if (localc.d)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      default: 
        paramInt3 = i;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      case 1: 
        paramInt3 = i + 2;
      }
    }
    i = paramInt3;
    if (localc.e)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        int j = (paramInt2 - 1) / 57;
        if (localc.f) {
          i = 2;
        } else {
          i = 1;
        }
        i = paramInt3 + (j + 1) * i;
      }
    }
    localc.a = new byte[i];
    localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
    return localc.a;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
  }
  
  static class b
    extends dw.a
  {
    private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private int e;
    private int f;
    private final int[] g;
    
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
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int m = this.e;
      if (m == 6) {
        return false;
      }
      int i2 = paramInt2 + paramInt1;
      int j = this.f;
      byte[] arrayOfByte = this.a;
      int[] arrayOfInt = this.g;
      paramInt2 = 0;
      int i = paramInt1;
      paramInt1 = j;
      int k;
      for (;;)
      {
        k = paramInt1;
        j = paramInt2;
        if (i >= i2) {
          break;
        }
        k = paramInt1;
        j = paramInt2;
        int n = i;
        if (m == 0)
        {
          for (;;)
          {
            k = i + 4;
            if (k > i2) {
              break;
            }
            j = arrayOfInt[(paramArrayOfByte[i] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(i + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(i + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(i + 3)] & 0xFF)];
            paramInt1 = j;
            if (j < 0) {
              break;
            }
            arrayOfByte[(paramInt2 + 2)] = ((byte)j);
            arrayOfByte[(paramInt2 + 1)] = ((byte)(j >> 8));
            arrayOfByte[paramInt2] = ((byte)(j >> 16));
            paramInt2 += 3;
            i = k;
            paramInt1 = j;
          }
          k = paramInt1;
          j = paramInt2;
          n = i;
          if (i >= i2)
          {
            k = paramInt1;
            j = paramInt2;
            break;
          }
        }
        int i1 = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
        switch (m)
        {
        default: 
          paramInt1 = m;
          i = k;
          paramInt2 = j;
          break;
        case 5: 
          paramInt1 = m;
          i = k;
          paramInt2 = j;
          if (i1 == -1) {
            break label646;
          }
          this.e = 6;
          return false;
        case 4: 
          if (i1 == -2)
          {
            paramInt1 = m + 1;
            i = k;
            paramInt2 = j;
            break label646;
          }
          paramInt1 = m;
          i = k;
          paramInt2 = j;
          if (i1 == -1) {
            break label646;
          }
          this.e = 6;
          return false;
        case 3: 
          if (i1 >= 0)
          {
            i = i1 | k << 6;
            arrayOfByte[(j + 2)] = ((byte)i);
            arrayOfByte[(j + 1)] = ((byte)(i >> 8));
            arrayOfByte[j] = ((byte)(i >> 16));
            paramInt2 = j + 3;
            paramInt1 = 0;
            break label646;
          }
          if (i1 == -2)
          {
            arrayOfByte[(j + 1)] = ((byte)(k >> 2));
            arrayOfByte[j] = ((byte)(k >> 10));
            paramInt2 = j + 2;
            paramInt1 = 5;
            i = k;
            break label646;
          }
          paramInt1 = m;
          i = k;
          paramInt2 = j;
          if (i1 == -1) {
            break label646;
          }
          this.e = 6;
          return false;
        case 2: 
          if (i1 < 0)
          {
            if (i1 == -2)
            {
              arrayOfByte[j] = ((byte)(k >> 4));
              paramInt2 = j + 1;
              paramInt1 = 4;
              i = k;
              break label646;
            }
            paramInt1 = m;
            i = k;
            paramInt2 = j;
            if (i1 == -1) {
              break label646;
            }
            this.e = 6;
            return false;
          }
        case 1: 
          if (i1 >= 0)
          {
            paramInt1 = i1 | k << 6;
            break label606;
          }
          paramInt1 = m;
          i = k;
          paramInt2 = j;
          if (i1 == -1) {
            break label646;
          }
          this.e = 6;
          return false;
        }
        if (i1 >= 0)
        {
          paramInt1 = i1;
          label606:
          paramInt2 = m + 1;
          i = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
        else
        {
          paramInt1 = m;
          i = k;
          paramInt2 = j;
          if (i1 != -1)
          {
            this.e = 6;
            return false;
          }
        }
        label646:
        j = n + 1;
        m = paramInt1;
        paramInt1 = i;
        i = j;
      }
      if (!paramBoolean)
      {
        this.e = m;
        this.f = k;
        paramInt1 = j;
      }
      for (;;)
      {
        this.b = paramInt1;
        return true;
        paramInt1 = j;
        switch (m)
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
        this.e = m;
      }
    }
  }
  
  static class c
    extends dw.a
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
    
    public c(int paramInt, byte[] paramArrayOfByte)
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
      paramInt2 = this.c;
      int i3 = 0;
      int i2 = 0;
      int i1;
      switch (paramInt2)
      {
      default: 
        break;
      case 2: 
        paramInt2 = paramInt1 + 1;
        if (paramInt2 <= i4)
        {
          byte[] arrayOfByte3 = this.j;
          m = arrayOfByte3[0];
          i1 = arrayOfByte3[1];
          paramInt1 = paramArrayOfByte[paramInt1];
          this.c = 0;
          paramInt1 = (i1 & 0xFF) << 8 | (m & 0xFF) << 16 | paramInt1 & 0xFF;
        }
        break;
      case 1: 
        if (paramInt1 + 2 <= i4)
        {
          m = this.j[0];
          i1 = paramInt1 + 1;
          paramInt1 = paramArrayOfByte[paramInt1];
          paramInt2 = i1 + 1;
          paramInt1 = (m & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | paramArrayOfByte[i1] & 0xFF;
          this.c = 0;
        }
        break;
      }
      int m = -1;
      paramInt2 = paramInt1;
      paramInt1 = m;
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
          m = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          paramInt1 = m;
          n = 19;
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
        m = paramInt2 + 3;
        if (m > i4) {
          break label492;
        }
        i1 = paramArrayOfByte[paramInt2];
        paramInt2 = (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | (i1 & 0xFF) << 16 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
        arrayOfByte2[paramInt1] = arrayOfByte1[(paramInt2 >> 18 & 0x3F)];
        arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(paramInt2 >> 12 & 0x3F)];
        arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(paramInt2 >> 6 & 0x3F)];
        arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(paramInt2 & 0x3F)];
        paramInt1 += 4;
        n -= 1;
        if (n == 0)
        {
          if (this.f)
          {
            paramInt2 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = paramInt2;
          }
          n = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          paramInt2 = m;
          paramInt1 = n;
          break;
        }
        paramInt2 = m;
      }
      label492:
      if (paramBoolean)
      {
        m = this.c;
        if (paramInt2 - m == i4 - 1)
        {
          if (m > 0)
          {
            i1 = this.j[0];
            m = 1;
          }
          else
          {
            i1 = paramArrayOfByte[paramInt2];
            paramInt2 += 1;
            m = i2;
          }
          i1 = (i1 & 0xFF) << 4;
          this.c -= m;
          i2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 6 & 0x3F)];
          m = i2 + 1;
          arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
          paramInt1 = m;
          if (this.d)
          {
            i1 = m + 1;
            arrayOfByte2[m] = 61;
            paramInt1 = i1 + 1;
            arrayOfByte2[i1] = 61;
          }
          m = paramInt1;
          i1 = paramInt2;
          if (this.e)
          {
            if (this.f)
            {
              m = paramInt1 + 1;
              arrayOfByte2[paramInt1] = 13;
              paramInt1 = m;
            }
            m = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 10;
            i1 = paramInt2;
          }
        }
        else if (paramInt2 - m == i4 - 2)
        {
          if (m > 1)
          {
            i1 = this.j[0];
            m = 1;
          }
          else
          {
            i1 = paramArrayOfByte[paramInt2];
            paramInt2 += 1;
            m = i3;
          }
          if (this.c > 0)
          {
            paramArrayOfByte = this.j;
            i2 = m + 1;
            m = paramArrayOfByte[m];
          }
          else
          {
            i3 = paramArrayOfByte[paramInt2];
            i2 = m;
            m = i3;
            paramInt2 += 1;
          }
          m = (i1 & 0xFF) << 10 | (m & 0xFF) << 2;
          this.c -= i2;
          i1 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = arrayOfByte1[(m >> 12 & 0x3F)];
          i2 = i1 + 1;
          arrayOfByte2[i1] = arrayOfByte1[(m >> 6 & 0x3F)];
          paramInt1 = i2 + 1;
          arrayOfByte2[i2] = arrayOfByte1[(m & 0x3F)];
          if (this.d)
          {
            m = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 61;
            paramInt1 = m;
          }
          m = paramInt1;
          if (this.e)
          {
            m = paramInt1;
            if (this.f)
            {
              arrayOfByte2[paramInt1] = 13;
              m = paramInt1 + 1;
            }
            arrayOfByte2[m] = 10;
            m += 1;
          }
          i1 = paramInt2;
        }
        else
        {
          m = paramInt1;
          i1 = paramInt2;
          if (this.e)
          {
            m = paramInt1;
            i1 = paramInt2;
            if (paramInt1 > 0)
            {
              m = paramInt1;
              i1 = paramInt2;
              if (n != 19)
              {
                if (this.f)
                {
                  m = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 13;
                  paramInt1 = m;
                }
                m = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 10;
                i1 = paramInt2;
              }
            }
          }
        }
        if ((!g) && (this.c != 0)) {
          throw new AssertionError();
        }
        i2 = m;
        if (!g) {
          if (i1 == i4) {
            i2 = m;
          } else {
            throw new AssertionError();
          }
        }
      }
      else if (paramInt2 == i4 - 1)
      {
        arrayOfByte1 = this.j;
        m = this.c;
        this.c = (m + 1);
        arrayOfByte1[m] = paramArrayOfByte[paramInt2];
        i2 = paramInt1;
      }
      else
      {
        i2 = paramInt1;
        if (paramInt2 == i4 - 2)
        {
          arrayOfByte1 = this.j;
          m = this.c;
          this.c = (m + 1);
          arrayOfByte1[m] = paramArrayOfByte[paramInt2];
          m = this.c;
          this.c = (m + 1);
          arrayOfByte1[m] = paramArrayOfByte[(paramInt2 + 1)];
          i2 = paramInt1;
        }
      }
      this.b = i2;
      this.k = n;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dw
 * JD-Core Version:    0.7.0.1
 */