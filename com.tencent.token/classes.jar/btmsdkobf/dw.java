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
    if (localb.c == 6) {}
    int i;
    for (;;)
    {
      paramInt1 = 0;
      break label689;
      int n = paramInt2 + paramInt1;
      i = localb.c;
      paramInt2 = localb.d;
      byte[] arrayOfByte = localb.a;
      int[] arrayOfInt = localb.e;
      int j = 0;
      paramInt3 = paramInt1;
      paramInt1 = j;
      int m;
      int k;
      for (;;)
      {
        m = paramInt2;
        k = paramInt1;
        if (paramInt3 >= n) {
          break;
        }
        j = paramInt2;
        k = paramInt1;
        m = paramInt3;
        if (i == 0)
        {
          for (;;)
          {
            k = paramInt3 + 4;
            j = paramInt2;
            if (k > n) {
              break;
            }
            paramInt2 = arrayOfInt[(paramArrayOfByte[paramInt3] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(paramInt3 + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(paramInt3 + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(paramInt3 + 3)] & 0xFF)];
            j = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            arrayOfByte[(paramInt1 + 2)] = ((byte)paramInt2);
            arrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8));
            arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 16));
            paramInt1 += 3;
            paramInt3 = k;
          }
          m = j;
          k = paramInt1;
          if (paramInt3 >= n) {
            break;
          }
          m = paramInt3;
          k = paramInt1;
        }
        paramInt1 = m + 1;
        paramInt3 = arrayOfInt[(paramArrayOfByte[m] & 0xFF)];
        switch (i)
        {
        default: 
          paramInt2 = j;
          break;
        case 5: 
          paramInt2 = j;
          if (paramInt3 == -1) {}
          break;
        case 4: 
          if (paramInt3 == -2)
          {
            paramInt2 = j;
          }
          else
          {
            paramInt2 = j;
            if (paramInt3 == -1) {
              break label559;
            }
          }
          break;
        case 3: 
          if (paramInt3 >= 0)
          {
            paramInt2 = j << 6 | paramInt3;
            arrayOfByte[(k + 2)] = ((byte)paramInt2);
            arrayOfByte[(k + 1)] = ((byte)(paramInt2 >> 8));
            arrayOfByte[k] = ((byte)(paramInt2 >> 16));
            j = k + 3;
            paramInt3 = paramInt1;
            i = 0;
            paramInt1 = j;
          }
          else if (paramInt3 == -2)
          {
            arrayOfByte[(k + 1)] = ((byte)(j >> 2));
            arrayOfByte[k] = ((byte)(j >> 10));
            k += 2;
            i = 5;
            paramInt2 = j;
          }
          else
          {
            paramInt2 = j;
            if (paramInt3 == -1) {}
          }
          break;
        case 2: 
          if (paramInt3 < 0)
          {
            if (paramInt3 == -2)
            {
              arrayOfByte[k] = ((byte)(j >> 4));
              k += 1;
              paramInt3 = paramInt1;
              i = 4;
              paramInt2 = j;
              paramInt1 = k;
              continue;
            }
            paramInt2 = j;
            if (paramInt3 == -1) {
              break label559;
            }
          }
          break;
        case 1: 
          if (paramInt3 >= 0)
          {
            paramInt2 = j << 6 | paramInt3;
            i += 1;
          }
          else
          {
            paramInt2 = j;
            if (paramInt3 == -1) {}
          }
          break;
        case 0: 
          if (paramInt3 >= 0)
          {
            i += 1;
            paramInt2 = paramInt3;
          }
          else
          {
            paramInt2 = j;
            if (paramInt3 != -1) {
              break label664;
            }
          }
          label559:
          paramInt3 = paramInt1;
          paramInt1 = k;
        }
      }
      paramInt1 = k;
      switch (i)
      {
      default: 
        paramInt1 = k;
        break;
      case 3: 
        paramInt2 = k + 1;
        arrayOfByte[k] = ((byte)(m >> 10));
        paramInt1 = paramInt2 + 1;
        arrayOfByte[paramInt2] = ((byte)(m >> 2));
        break;
      case 2: 
        arrayOfByte[k] = ((byte)(m >> 4));
        paramInt1 = k + 1;
        break;
      case 1: 
      case 4: 
        label664:
        localb.c = 6;
      }
    }
    localb.c = i;
    localb.b = paramInt1;
    paramInt1 = 1;
    label689:
    if (paramInt1 != 0)
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
    c localc = new c(paramInt3);
    int i = paramInt2 / 3 * 4;
    if (localc.f)
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
    boolean bool = localc.g;
    int m = 1;
    int k = 1;
    i = paramInt3;
    if (bool)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        j = (paramInt2 - 1) / 57;
        if (localc.h) {
          i = 2;
        } else {
          i = 1;
        }
        i = paramInt3 + (j + 1) * i;
      }
    }
    localc.a = new byte[i];
    byte[] arrayOfByte1 = localc.i;
    byte[] arrayOfByte2 = localc.a;
    i = localc.e;
    int n = paramInt2 + paramInt1;
    switch (localc.d)
    {
    default: 
      break;
    case 2: 
      paramInt2 = paramInt1 + 1;
      if (paramInt2 <= n)
      {
        paramInt3 = localc.c[0];
        j = localc.c[1];
        paramInt1 = paramArrayOfByte[paramInt1];
        localc.d = 0;
        paramInt1 = (paramInt3 & 0xFF) << 16 | (j & 0xFF) << 8 | paramInt1 & 0xFF;
      }
      break;
    case 1: 
      if (paramInt1 + 2 <= n)
      {
        paramInt3 = localc.c[0];
        j = paramInt1 + 1;
        paramInt1 = paramArrayOfByte[paramInt1];
        paramInt2 = j + 1;
        paramInt1 = (paramInt3 & 0xFF) << 16 | (paramInt1 & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF;
        localc.d = 0;
      }
      break;
    }
    paramInt3 = -1;
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    if (paramInt1 != -1)
    {
      arrayOfByte2[0] = arrayOfByte1[(paramInt1 >> 18 & 0x3F)];
      arrayOfByte2[1] = arrayOfByte1[(paramInt1 >> 12 & 0x3F)];
      arrayOfByte2[2] = arrayOfByte1[(paramInt1 >> 6 & 0x3F)];
      arrayOfByte2[3] = arrayOfByte1[(paramInt1 & 0x3F)];
      i -= 1;
      if (i == 0)
      {
        if (localc.h)
        {
          paramInt1 = 5;
          arrayOfByte2[4] = 13;
        }
        else
        {
          paramInt1 = 4;
        }
        paramInt3 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt1 = paramInt3;
        i = 19;
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
      paramInt3 = paramInt2 + 3;
      if (paramInt3 > n) {
        break label649;
      }
      j = paramArrayOfByte[paramInt2];
      paramInt2 = (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | (j & 0xFF) << 16 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
      arrayOfByte2[paramInt1] = arrayOfByte1[(paramInt2 >> 18 & 0x3F)];
      arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(paramInt2 >> 12 & 0x3F)];
      arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(paramInt2 >> 6 & 0x3F)];
      arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(paramInt2 & 0x3F)];
      paramInt1 += 4;
      i -= 1;
      if (i == 0)
      {
        if (localc.h)
        {
          paramInt2 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = paramInt2;
        }
        i = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt2 = paramInt3;
        paramInt1 = i;
        break;
      }
      paramInt2 = paramInt3;
    }
    label649:
    if (paramInt2 - localc.d == n - 1)
    {
      if (localc.d > 0)
      {
        j = localc.c[0];
        paramInt3 = k;
      }
      else
      {
        j = paramArrayOfByte[paramInt2];
        paramInt2 += 1;
        paramInt3 = 0;
      }
      j = (j & 0xFF) << 4;
      localc.d -= paramInt3;
      k = paramInt1 + 1;
      arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 6 & 0x3F)];
      paramInt3 = k + 1;
      arrayOfByte2[k] = arrayOfByte1[(j & 0x3F)];
      paramInt1 = paramInt3;
      if (localc.f)
      {
        j = paramInt3 + 1;
        arrayOfByte2[paramInt3] = 61;
        paramInt1 = j + 1;
        arrayOfByte2[j] = 61;
      }
      if (localc.g)
      {
        if (localc.h)
        {
          paramInt3 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 13;
          paramInt1 = paramInt3;
        }
        paramInt3 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 10;
        paramInt1 = paramInt3;
      }
    }
    for (;;)
    {
      paramInt3 = paramInt1;
      j = paramInt2;
      break label1168;
      paramInt3 = paramInt1;
      j = paramInt2;
      break label1168;
      if (paramInt2 - localc.d != n - 2) {
        break label1098;
      }
      if (localc.d > 1)
      {
        j = localc.c[0];
        paramInt3 = m;
      }
      else
      {
        j = paramArrayOfByte[paramInt2];
        paramInt2 += 1;
        paramInt3 = 0;
      }
      if (localc.d > 0)
      {
        paramArrayOfByte = localc.c;
        m = paramInt3 + 1;
        k = paramArrayOfByte[paramInt3];
        paramInt3 = m;
      }
      else
      {
        k = paramArrayOfByte[paramInt2];
        paramInt2 += 1;
      }
      j = (j & 0xFF) << 10 | (k & 0xFF) << 2;
      localc.d -= paramInt3;
      paramInt3 = paramInt1 + 1;
      arrayOfByte2[paramInt1] = arrayOfByte1[(j >> 12 & 0x3F)];
      k = paramInt3 + 1;
      arrayOfByte2[paramInt3] = arrayOfByte1[(j >> 6 & 0x3F)];
      paramInt1 = k + 1;
      arrayOfByte2[k] = arrayOfByte1[(j & 0x3F)];
      if (localc.f)
      {
        paramInt3 = paramInt1 + 1;
        arrayOfByte2[paramInt1] = 61;
        paramInt1 = paramInt3;
      }
      if (!localc.g) {
        break;
      }
      paramInt3 = paramInt1;
      if (localc.h)
      {
        arrayOfByte2[paramInt1] = 13;
        paramInt3 = paramInt1 + 1;
      }
      paramInt1 = paramInt3 + 1;
      arrayOfByte2[paramInt3] = 10;
    }
    paramInt3 = paramInt1;
    int j = paramInt2;
    break label1168;
    label1098:
    paramInt3 = paramInt1;
    j = paramInt2;
    if (localc.g)
    {
      paramInt3 = paramInt1;
      j = paramInt2;
      if (paramInt1 > 0)
      {
        paramInt3 = paramInt1;
        j = paramInt2;
        if (i != 19)
        {
          if (localc.h)
          {
            paramInt3 = paramInt1 + 1;
            arrayOfByte2[paramInt1] = 13;
            paramInt1 = paramInt3;
          }
          paramInt3 = paramInt1 + 1;
          arrayOfByte2[paramInt1] = 10;
          j = paramInt2;
        }
      }
    }
    label1168:
    if ((!c.j) && (localc.d != 0)) {
      throw new AssertionError();
    }
    if ((!c.j) && (j != n)) {
      throw new AssertionError();
    }
    localc.b = paramInt3;
    localc.e = i;
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
  
  static final class b
    extends dw.a
  {
    private static final int[] f = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] g = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    int c;
    int d;
    final int[] e;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {
        paramArrayOfByte = f;
      } else {
        paramArrayOfByte = g;
      }
      this.e = paramArrayOfByte;
      this.c = 0;
      this.d = 0;
    }
  }
  
  static final class c
    extends dw.a
  {
    private static final byte[] k = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
    private static final byte[] l = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
    final byte[] c;
    int d;
    int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    final byte[] i;
    
    public c(int paramInt)
    {
      this.a = null;
      boolean bool2 = true;
      boolean bool1;
      if ((paramInt & 0x1) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.f = bool1;
      if ((paramInt & 0x2) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.g = bool1;
      if ((paramInt & 0x4) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.h = bool1;
      byte[] arrayOfByte;
      if ((paramInt & 0x8) == 0) {
        arrayOfByte = k;
      } else {
        arrayOfByte = l;
      }
      this.i = arrayOfByte;
      this.c = new byte[2];
      this.d = 0;
      if (this.g) {
        paramInt = 19;
      } else {
        paramInt = -1;
      }
      this.e = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dw
 * JD-Core Version:    0.7.0.1
 */