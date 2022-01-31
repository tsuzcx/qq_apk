package com.tencent.token.utils;

public class b
{
  public static final byte[] a;
  public static final byte[] b;
  private static final byte[] d;
  private static final byte[] e;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      a = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      d = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, a, true);
  }
  
  public static String a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    paramArrayOfByte1 = a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, 2147483647);
    paramInt1 = paramArrayOfByte1.length;
    for (;;)
    {
      if ((paramBoolean) || (paramInt1 <= 0) || (paramArrayOfByte1[(paramInt1 - 1)] != 61)) {
        return new String(paramArrayOfByte1, 0, paramInt1);
      }
      paramInt1 -= 1;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = (paramInt2 + 2) / 3 * 4;
    byte[] arrayOfByte = new byte[i + i / paramInt3];
    int j = 0;
    i = 0;
    int k = 0;
    while (k < paramInt2 - 2)
    {
      m = paramArrayOfByte1[(k + paramInt1)] << 24 >>> 8 | paramArrayOfByte1[(k + 1 + paramInt1)] << 24 >>> 16 | paramArrayOfByte1[(k + 2 + paramInt1)] << 24 >>> 24;
      arrayOfByte[i] = paramArrayOfByte2[(m >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(m >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = paramArrayOfByte2[(m >>> 6 & 0x3F)];
      arrayOfByte[(i + 3)] = paramArrayOfByte2[(m & 0x3F)];
      int n = j + 4;
      j = n;
      m = i;
      if (n == paramInt3)
      {
        arrayOfByte[(i + 4)] = 10;
        m = i + 1;
        j = 0;
      }
      k += 3;
      i = m + 4;
    }
    int m = i;
    if (k < paramInt2)
    {
      a(paramArrayOfByte1, k + paramInt1, paramInt2 - k, arrayOfByte, i, paramArrayOfByte2);
      paramInt1 = i;
      if (j + 4 == paramInt3)
      {
        arrayOfByte[(i + 4)] = 10;
        paramInt1 = i + 1;
      }
      m = paramInt1 + 4;
    }
    if ((!c) && (m != arrayOfByte.length)) {
      throw new AssertionError();
    }
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, byte[] paramArrayOfByte3)
  {
    int k = 0;
    int i;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label18:
      if (paramInt2 <= 1) {
        break label100;
      }
    }
    label100:
    for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; j = 0)
    {
      if (paramInt2 > 2) {
        k = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = k | j | i;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        i = 0;
        break label18;
      }
    }
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = paramArrayOfByte3[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = paramArrayOfByte3[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = paramArrayOfByte3[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.b
 * JD-Core Version:    0.7.0.1
 */