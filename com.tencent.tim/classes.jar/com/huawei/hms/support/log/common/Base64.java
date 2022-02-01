package com.huawei.hms.support.log.common;

public final class Base64
{
  private static final char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47, 61 };
  private static final byte[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  private static int a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < paramString.length())
    {
      int m = paramString.charAt(i);
      int k;
      if (m <= 255)
      {
        k = j;
        if (b[m] >= 0) {}
      }
      else
      {
        k = j - 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static byte[] decode(String paramString)
  {
    int k = a(paramString);
    int j = k / 4 * 3;
    int i = j;
    if (k % 4 == 3) {
      i = j + 2;
    }
    j = i;
    if (k % 4 == 2) {
      j = i + 1;
    }
    byte[] arrayOfByte = new byte[j];
    k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i3;
    if (k < paramString.length())
    {
      i = paramString.charAt(k);
      if (i > 255)
      {
        i3 = -1;
        label77:
        i2 = m;
        i = n;
        j = i1;
        if (i3 >= 0)
        {
          j = i1 + 6;
          i = n << 6 | i3;
          if (j < 8) {
            break label179;
          }
          j -= 8;
          arrayOfByte[m] = ((byte)(i >> j & 0xFF));
        }
      }
    }
    label179:
    for (int i2 = m + 1;; i2 = m)
    {
      k += 1;
      m = i2;
      n = i;
      i1 = j;
      break;
      i3 = b[i];
      break label77;
      if (m != arrayOfByte.length) {
        return new byte[0];
      }
      return arrayOfByte;
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static String encode(byte[] paramArrayOfByte, int paramInt)
  {
    char[] arrayOfChar1 = new char[(paramInt + 2) / 3 * 4];
    int j = 0;
    int i = 0;
    int m;
    if (i < paramInt)
    {
      m = (paramArrayOfByte[i] & 0xFF) << 8;
      if (i + 1 >= paramInt) {
        break label231;
      }
      m |= paramArrayOfByte[(i + 1)] & 0xFF;
    }
    label208:
    label231:
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (i + 2 < paramInt) {
        m |= paramArrayOfByte[(i + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        char[] arrayOfChar2 = a;
        if (n != 0)
        {
          n = m & 0x3F;
          label104:
          arrayOfChar1[(j + 3)] = arrayOfChar2[n];
          m >>= 6;
          arrayOfChar2 = a;
          if (k == 0) {
            break label208;
          }
        }
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfChar1[(j + 2)] = arrayOfChar2[k];
          k = m >> 6;
          arrayOfChar1[(j + 1)] = a[(k & 0x3F)];
          arrayOfChar1[(j + 0)] = a[(k >> 6 & 0x3F)];
          j += 4;
          i += 3;
          break;
          n = 64;
          break label104;
        }
        return new String(arrayOfChar1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.log.common.Base64
 * JD-Core Version:    0.7.0.1
 */