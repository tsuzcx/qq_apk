package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;

public class Base64
{
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localb.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.b == localb.a.length) {
      return localb.a;
    }
    paramArrayOfByte = new byte[localb.b];
    System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
    return paramArrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localc.d)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localc.e)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localc.f) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localc.a = new byte[i];
      localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((a) || (localc.b == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localc.a;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte, paramInt), "US-ASCII");
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
    extends Base64.a
  {
    private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private int e;
    private int f;
    private final int[] g;
    
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
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.e == 6) {
        return false;
      }
      int i2 = paramInt2 + paramInt1;
      int j = this.e;
      paramInt2 = this.f;
      int i = 0;
      byte[] arrayOfByte = this.a;
      int[] arrayOfInt = this.g;
      int k;
      int m;
      int i1;
      if (paramInt1 < i2)
      {
        k = i;
        m = paramInt2;
        i1 = paramInt1;
        if (j == 0)
        {
          int n = paramInt1;
          for (paramInt1 = paramInt2; n + 4 <= i2; paramInt1 = paramInt2)
          {
            paramInt2 = arrayOfInt[(paramArrayOfByte[n] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(n + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(n + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(n + 3)] & 0xFF)];
            paramInt1 = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            arrayOfByte[(i + 2)] = ((byte)paramInt2);
            arrayOfByte[(i + 1)] = ((byte)(paramInt2 >> 8));
            arrayOfByte[i] = ((byte)(paramInt2 >> 16));
            i += 3;
            n += 4;
          }
          k = i;
          m = paramInt1;
          i1 = n;
          if (n >= i2) {
            paramInt2 = paramInt1;
          }
        }
      }
      for (;;)
      {
        if (!paramBoolean)
        {
          this.e = j;
          this.f = paramInt2;
          this.b = i;
          return true;
          paramInt2 = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
          switch (j)
          {
          }
          label292:
          label577:
          do
          {
            do
            {
              paramInt1 = j;
              paramInt2 = m;
              i = k;
              for (;;)
              {
                j = paramInt1;
                paramInt1 = i1 + 1;
                break;
                if (paramInt2 >= 0)
                {
                  paramInt1 = j + 1;
                  i = k;
                }
                else
                {
                  if (paramInt2 == -1) {
                    break label292;
                  }
                  this.e = 6;
                  return false;
                  if (paramInt2 >= 0)
                  {
                    paramInt2 = m << 6 | paramInt2;
                    paramInt1 = j + 1;
                    i = k;
                  }
                  else
                  {
                    if (paramInt2 == -1) {
                      break label292;
                    }
                    this.e = 6;
                    return false;
                    if (paramInt2 >= 0)
                    {
                      paramInt2 = m << 6 | paramInt2;
                      paramInt1 = j + 1;
                      i = k;
                    }
                    else if (paramInt2 == -2)
                    {
                      arrayOfByte[k] = ((byte)(m >> 4));
                      paramInt1 = 4;
                      i = k + 1;
                      paramInt2 = m;
                    }
                    else
                    {
                      if (paramInt2 == -1) {
                        break label292;
                      }
                      this.e = 6;
                      return false;
                      if (paramInt2 >= 0)
                      {
                        paramInt2 = m << 6 | paramInt2;
                        arrayOfByte[(k + 2)] = ((byte)paramInt2);
                        arrayOfByte[(k + 1)] = ((byte)(paramInt2 >> 8));
                        arrayOfByte[k] = ((byte)(paramInt2 >> 16));
                        i = k + 3;
                        paramInt1 = 0;
                      }
                      else if (paramInt2 == -2)
                      {
                        arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                        arrayOfByte[k] = ((byte)(m >> 10));
                        i = k + 2;
                        paramInt1 = 5;
                        paramInt2 = m;
                      }
                      else
                      {
                        if (paramInt2 == -1) {
                          break label292;
                        }
                        this.e = 6;
                        return false;
                        if (paramInt2 != -2) {
                          break label577;
                        }
                        paramInt1 = j + 1;
                        i = k;
                        paramInt2 = m;
                      }
                    }
                  }
                }
              }
            } while (paramInt2 == -1);
            this.e = 6;
            return false;
          } while (paramInt2 == -1);
          this.e = 6;
          return false;
        }
        paramInt1 = i;
        switch (j)
        {
        default: 
          paramInt1 = i;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            this.e = j;
            this.b = paramInt1;
            return true;
            this.e = 6;
            return false;
            arrayOfByte[i] = ((byte)(paramInt2 >> 4));
            paramInt1 = i + 1;
            continue;
            k = i + 1;
            arrayOfByte[i] = ((byte)(paramInt2 >> 10));
            paramInt1 = k + 1;
            arrayOfByte[k] = ((byte)(paramInt2 >> 2));
          }
        }
        this.e = 6;
        return false;
      }
    }
  }
  
  static class c
    extends Base64.a
  {
    private static final byte[] h;
    private static final byte[] i;
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;
    
    static
    {
      if (!Base64.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        g = bool;
        h = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.d = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.e = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.f = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = h;
        label63:
        this.l = paramArrayOfByte;
        this.j = new byte[2];
        this.c = 0;
        if (!this.e) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.k = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = i;
        break label63;
      }
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.l;
      byte[] arrayOfByte2 = this.a;
      int m = 0;
      int i2 = this.k;
      int i4 = paramInt2 + paramInt1;
      int i1 = -1;
      label62:
      int n;
      switch (this.c)
      {
      default: 
        paramInt2 = paramInt1;
        paramInt1 = i2;
        n = paramInt2;
        if (i1 != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(i1 >> 18 & 0x3F)];
          arrayOfByte2[1] = arrayOfByte1[(i1 >> 12 & 0x3F)];
          arrayOfByte2[2] = arrayOfByte1[(i1 >> 6 & 0x3F)];
          m = 4;
          arrayOfByte2[3] = arrayOfByte1[(i1 & 0x3F)];
          i1 = i2 - 1;
          paramInt1 = i1;
          n = paramInt2;
          if (i1 == 0)
          {
            if (!this.f) {
              break label1226;
            }
            paramInt1 = 5;
            arrayOfByte2[4] = 13;
          }
        }
        break;
      }
      for (;;)
      {
        arrayOfByte2[paramInt1] = 10;
        n = 19;
        paramInt1 += 1;
        for (;;)
        {
          label180:
          if (paramInt2 + 3 <= i4)
          {
            m = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
            arrayOfByte2[paramInt1] = arrayOfByte1[(m >> 18 & 0x3F)];
            arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(m >> 12 & 0x3F)];
            arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(m >> 6 & 0x3F)];
            arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(m & 0x3F)];
            paramInt2 += 3;
            i1 = paramInt1 + 4;
            i2 = n - 1;
            paramInt1 = i2;
            m = i1;
            n = paramInt2;
            if (i2 != 0) {
              break label1210;
            }
            if (!this.f) {
              break label1204;
            }
            paramInt1 = i1 + 1;
            arrayOfByte2[i1] = 13;
          }
          for (;;)
          {
            arrayOfByte2[paramInt1] = 10;
            n = 19;
            paramInt1 += 1;
            break label180;
            paramInt2 = paramInt1;
            break label62;
            if (paramInt1 + 2 > i4) {
              break;
            }
            n = this.j[0];
            paramInt2 = paramInt1 + 1;
            i1 = (n & 0xFF) << 16 | (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[paramInt2] & 0xFF;
            this.c = 0;
            paramInt2 += 1;
            break label62;
            if (paramInt1 + 1 > i4) {
              break;
            }
            n = this.j[0];
            i1 = this.j[1];
            paramInt2 = paramInt1 + 1;
            i1 = (n & 0xFF) << 16 | (i1 & 0xFF) << 8 | paramArrayOfByte[paramInt1] & 0xFF;
            this.c = 0;
            break label62;
            label742:
            int i3;
            if (paramBoolean)
            {
              if (paramInt2 - this.c == i4 - 1)
              {
                if (this.c > 0)
                {
                  paramArrayOfByte = this.j;
                  m = 1;
                  i1 = paramArrayOfByte[0];
                }
                for (;;)
                {
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
                  if ((g) || (this.c == 0)) {
                    break;
                  }
                  throw new AssertionError();
                  i1 = paramArrayOfByte[paramInt2];
                  paramInt2 += 1;
                  m = 0;
                }
              }
              if (paramInt2 - this.c == i4 - 2) {
                if (this.c > 1)
                {
                  byte[] arrayOfByte3 = this.j;
                  i2 = 1;
                  i1 = arrayOfByte3[0];
                  m = paramInt2;
                  paramInt2 = i2;
                  if (this.c <= 0) {
                    break label946;
                  }
                  i2 = this.j[paramInt2];
                  i3 = paramInt2 + 1;
                  paramInt2 = m;
                  m = i3;
                  label769:
                  i1 = (i2 & 0xFF) << 2 | (i1 & 0xFF) << 10;
                  this.c -= m;
                  m = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = arrayOfByte1[(i1 >> 12 & 0x3F)];
                  i2 = m + 1;
                  arrayOfByte2[m] = arrayOfByte1[(i1 >> 6 & 0x3F)];
                  paramInt1 = i2 + 1;
                  arrayOfByte2[i2] = arrayOfByte1[(i1 & 0x3F)];
                  if (!this.d) {
                    break label1201;
                  }
                  m = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 61;
                  paramInt1 = m;
                }
              }
            }
            label1201:
            for (;;)
            {
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
              break;
              i1 = paramArrayOfByte[paramInt2];
              m = paramInt2 + 1;
              paramInt2 = 0;
              break label742;
              label946:
              i2 = paramArrayOfByte[m];
              i3 = m + 1;
              m = paramInt2;
              paramInt2 = i3;
              break label769;
              i1 = paramInt2;
              m = paramInt1;
              if (!this.e) {
                break;
              }
              i1 = paramInt2;
              m = paramInt1;
              if (paramInt1 <= 0) {
                break;
              }
              i1 = paramInt2;
              m = paramInt1;
              if (n == 19) {
                break;
              }
              if (this.f)
              {
                m = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = m;
              }
              for (;;)
              {
                m = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 10;
                i1 = paramInt2;
                break;
                i2 = m;
                if (!g)
                {
                  i2 = m;
                  if (i1 != i4)
                  {
                    throw new AssertionError();
                    if (paramInt2 != i4 - 1) {
                      break label1123;
                    }
                    arrayOfByte1 = this.j;
                    m = this.c;
                    this.c = (m + 1);
                    arrayOfByte1[m] = paramArrayOfByte[paramInt2];
                    i2 = paramInt1;
                  }
                }
                for (;;)
                {
                  this.b = i2;
                  this.k = n;
                  return true;
                  label1123:
                  i2 = paramInt1;
                  if (paramInt2 == i4 - 2)
                  {
                    arrayOfByte1 = this.j;
                    m = this.c;
                    this.c = (m + 1);
                    arrayOfByte1[m] = paramArrayOfByte[paramInt2];
                    arrayOfByte1 = this.j;
                    m = this.c;
                    this.c = (m + 1);
                    arrayOfByte1[m] = paramArrayOfByte[(paramInt2 + 1)];
                    i2 = paramInt1;
                  }
                }
              }
            }
            label1204:
            paramInt1 = i1;
          }
          label1210:
          i1 = paramInt1;
          paramInt1 = m;
          paramInt2 = n;
          n = i1;
        }
        label1226:
        paramInt1 = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.Base64
 * JD-Core Version:    0.7.0.1
 */