package com.tencent.mm.algorithm;

import java.util.Arrays;

public class Base64
{
  private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  private static final int[] b;
  
  static
  {
    int[] arrayOfInt = new int[256];
    b = arrayOfInt;
    Arrays.fill(arrayOfInt, -1);
    int j = a.length;
    int i = 0;
    while (i < j)
    {
      b[a[i]] = i;
      i += 1;
    }
    b[61] = 0;
  }
  
  public static final byte[] decode(String paramString)
  {
    if (paramString != null) {
      i = paramString.length();
    } else {
      i = 0;
    }
    if (i == 0) {
      return new byte[0];
    }
    int j = 0;
    for (int k = 0; j < i; k = m)
    {
      m = k;
      if (b[paramString.charAt(j)] < 0) {
        m = k + 1;
      }
      j += 1;
    }
    int m = i - k;
    if (m % 4 != 0) {
      return null;
    }
    j = 0;
    while (i > 1)
    {
      localObject = b;
      k = i - 1;
      if (localObject[paramString.charAt(k)] > 0) {
        break;
      }
      i = k;
      if (paramString.charAt(k) == '=')
      {
        j += 1;
        i = k;
      }
    }
    int i1 = (m * 6 >> 3) - j;
    Object localObject = new byte[i1];
    k = 0;
    int i = 0;
    while (k < i1)
    {
      j = 0;
      m = 0;
      while (j < 4)
      {
        n = b[paramString.charAt(i)];
        if (n >= 0) {
          m |= n << 18 - j * 6;
        } else {
          j -= 1;
        }
        j += 1;
        i += 1;
      }
      int n = k + 1;
      localObject[k] = ((byte)(m >> 16));
      j = n;
      if (n < i1)
      {
        k = n + 1;
        localObject[n] = ((byte)(m >> 8));
        j = k;
        if (k < i1)
        {
          j = k + 1;
          localObject[k] = ((byte)m);
        }
      }
      k = j;
    }
    return localObject;
  }
  
  public static final byte[] decode(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    int i = 0;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (b[(paramArrayOfByte[i] & 0xFF)] < 0) {
        k = j + 1;
      }
      i += 1;
    }
    int n = m - j;
    if (n % 4 != 0) {
      return null;
    }
    j = 0;
    i = m;
    while (i > 1)
    {
      localObject = b;
      k = i - 1;
      if (localObject[(paramArrayOfByte[k] & 0xFF)] > 0) {
        break;
      }
      i = k;
      if (paramArrayOfByte[k] == 61)
      {
        j += 1;
        i = k;
      }
    }
    int i1 = (n * 6 >> 3) - j;
    Object localObject = new byte[i1];
    int k = 0;
    i = 0;
    while (k < i1)
    {
      j = 0;
      m = 0;
      while (j < 4)
      {
        n = b[(paramArrayOfByte[i] & 0xFF)];
        if (n >= 0) {
          m |= n << 18 - j * 6;
        } else {
          j -= 1;
        }
        j += 1;
        i += 1;
      }
      n = k + 1;
      localObject[k] = ((byte)(m >> 16));
      j = n;
      if (n < i1)
      {
        k = n + 1;
        localObject[n] = ((byte)(m >> 8));
        j = k;
        if (k < i1)
        {
          j = k + 1;
          localObject[k] = ((byte)m);
        }
      }
      k = j;
    }
    return localObject;
  }
  
  public static final byte[] decode(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {
      i = paramArrayOfChar.length;
    } else {
      i = 0;
    }
    if (i == 0) {
      return new byte[0];
    }
    int j = 0;
    for (int k = 0; j < i; k = m)
    {
      m = k;
      if (b[paramArrayOfChar[j]] < 0) {
        m = k + 1;
      }
      j += 1;
    }
    int m = i - k;
    if (m % 4 != 0) {
      return null;
    }
    j = 0;
    while (i > 1)
    {
      localObject = b;
      k = i - 1;
      if (localObject[paramArrayOfChar[k]] > 0) {
        break;
      }
      i = k;
      if (paramArrayOfChar[k] == '=')
      {
        j += 1;
        i = k;
      }
    }
    int i1 = (m * 6 >> 3) - j;
    Object localObject = new byte[i1];
    k = 0;
    int i = 0;
    while (k < i1)
    {
      j = 0;
      m = 0;
      while (j < 4)
      {
        n = b[paramArrayOfChar[i]];
        if (n >= 0) {
          m |= n << 18 - j * 6;
        } else {
          j -= 1;
        }
        j += 1;
        i += 1;
      }
      int n = k + 1;
      localObject[k] = ((byte)(m >> 16));
      j = n;
      if (n < i1)
      {
        k = n + 1;
        localObject[n] = ((byte)(m >> 8));
        j = k;
        if (k < i1)
        {
          j = k + 1;
          localObject[k] = ((byte)m);
        }
      }
      k = j;
    }
    return localObject;
  }
  
  public static final byte[] decodeFast(String paramString)
  {
    int k = paramString.length();
    int i2 = 0;
    if (k == 0) {
      return new byte[0];
    }
    int i = k - 1;
    int j = 0;
    int n;
    for (;;)
    {
      n = i;
      if (j >= i) {
        break;
      }
      n = i;
      if (b[(paramString.charAt(j) & 0xFF)] >= 0) {
        break;
      }
      j += 1;
    }
    while ((n > 0) && (b[(paramString.charAt(n) & 0xFF)] < 0)) {
      n -= 1;
    }
    if (paramString.charAt(n) == '=')
    {
      if (paramString.charAt(n - 1) == '=') {
        i = 2;
      } else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    int m = n - j + 1;
    int i1;
    if (k > 76)
    {
      if (paramString.charAt(76) == '\r') {
        k = m / 78;
      } else {
        k = 0;
      }
      i1 = k << 1;
    }
    else
    {
      i1 = 0;
    }
    int i4 = ((m - i1) * 6 >> 3) - i;
    byte[] arrayOfByte = new byte[i4];
    int i5 = i4 / 3;
    int i3 = 0;
    k = 0;
    m = j;
    for (j = i3; j < i5 * 3; j = i3 + 1)
    {
      int[] arrayOfInt = b;
      int i6 = m + 1;
      i3 = arrayOfInt[paramString.charAt(m)];
      arrayOfInt = b;
      m = i6 + 1;
      i6 = arrayOfInt[paramString.charAt(i6)];
      arrayOfInt = b;
      int i7 = m + 1;
      int i8 = arrayOfInt[paramString.charAt(m)];
      arrayOfInt = b;
      m = i7 + 1;
      i6 = i3 << 18 | i6 << 12 | i8 << 6 | arrayOfInt[paramString.charAt(i7)];
      i7 = j + 1;
      arrayOfByte[j] = ((byte)(i6 >> 16));
      i3 = i7 + 1;
      arrayOfByte[i7] = ((byte)(i6 >> 8));
      arrayOfByte[i3] = ((byte)i6);
      j = k;
      if (i1 > 0)
      {
        k += 1;
        j = k;
        if (k == 19)
        {
          m += 2;
          k = 0;
          continue;
        }
      }
      k = j;
    }
    if (j < i4)
    {
      i1 = 0;
      k = i2;
      while (m <= n - i)
      {
        k |= b[paramString.charAt(m)] << 18 - i1 * 6;
        i1 += 1;
        m += 1;
      }
      i = 16;
      while (j < i4)
      {
        arrayOfByte[j] = ((byte)(k >> i));
        i -= 8;
        j += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static final byte[] decodeFast(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int i2 = 0;
    if (k == 0) {
      return new byte[0];
    }
    int i = k - 1;
    int j = 0;
    int n;
    for (;;)
    {
      n = i;
      if (j >= i) {
        break;
      }
      n = i;
      if (b[(paramArrayOfByte[j] & 0xFF)] >= 0) {
        break;
      }
      j += 1;
    }
    while ((n > 0) && (b[(paramArrayOfByte[n] & 0xFF)] < 0)) {
      n -= 1;
    }
    if (paramArrayOfByte[n] == 61)
    {
      if (paramArrayOfByte[(n - 1)] == 61) {
        i = 2;
      } else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    int m = n - j + 1;
    int i1;
    if (k > 76)
    {
      if (paramArrayOfByte[76] == 13) {
        k = m / 78;
      } else {
        k = 0;
      }
      i1 = k << 1;
    }
    else
    {
      i1 = 0;
    }
    int i4 = ((m - i1) * 6 >> 3) - i;
    byte[] arrayOfByte = new byte[i4];
    int i5 = i4 / 3;
    int i3 = 0;
    k = 0;
    m = j;
    for (j = i3; j < i5 * 3; j = i3 + 1)
    {
      int[] arrayOfInt = b;
      int i6 = m + 1;
      i3 = arrayOfInt[paramArrayOfByte[m]];
      m = i6 + 1;
      i6 = arrayOfInt[paramArrayOfByte[i6]];
      int i7 = m + 1;
      int i8 = arrayOfInt[paramArrayOfByte[m]];
      m = i7 + 1;
      i6 = i3 << 18 | i6 << 12 | i8 << 6 | arrayOfInt[paramArrayOfByte[i7]];
      i7 = j + 1;
      arrayOfByte[j] = ((byte)(i6 >> 16));
      i3 = i7 + 1;
      arrayOfByte[i7] = ((byte)(i6 >> 8));
      arrayOfByte[i3] = ((byte)i6);
      j = k;
      if (i1 > 0)
      {
        k += 1;
        j = k;
        if (k == 19)
        {
          m += 2;
          k = 0;
          continue;
        }
      }
      k = j;
    }
    if (j < i4)
    {
      i1 = 0;
      k = i2;
      while (m <= n - i)
      {
        k |= b[paramArrayOfByte[m]] << 18 - i1 * 6;
        i1 += 1;
        m += 1;
      }
      i = 16;
      while (j < i4)
      {
        arrayOfByte[j] = ((byte)(k >> i));
        i -= 8;
        j += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static final byte[] decodeFast(char[] paramArrayOfChar)
  {
    int k = paramArrayOfChar.length;
    int i2 = 0;
    if (k == 0) {
      return new byte[0];
    }
    int i = k - 1;
    int j = 0;
    int n;
    for (;;)
    {
      n = i;
      if (j >= i) {
        break;
      }
      n = i;
      if (b[paramArrayOfChar[j]] >= 0) {
        break;
      }
      j += 1;
    }
    while ((n > 0) && (b[paramArrayOfChar[n]] < 0)) {
      n -= 1;
    }
    if (paramArrayOfChar[n] == '=')
    {
      if (paramArrayOfChar[(n - 1)] == '=') {
        i = 2;
      } else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    int m = n - j + 1;
    int i1;
    if (k > 76)
    {
      if (paramArrayOfChar[76] == '\r') {
        k = m / 78;
      } else {
        k = 0;
      }
      i1 = k << 1;
    }
    else
    {
      i1 = 0;
    }
    int i4 = ((m - i1) * 6 >> 3) - i;
    byte[] arrayOfByte = new byte[i4];
    int i5 = i4 / 3;
    int i3 = 0;
    k = 0;
    m = j;
    for (j = i3; j < i5 * 3; j = i3 + 1)
    {
      int[] arrayOfInt = b;
      int i6 = m + 1;
      i3 = arrayOfInt[paramArrayOfChar[m]];
      m = i6 + 1;
      i6 = arrayOfInt[paramArrayOfChar[i6]];
      int i7 = m + 1;
      int i8 = arrayOfInt[paramArrayOfChar[m]];
      m = i7 + 1;
      i6 = i3 << 18 | i6 << 12 | i8 << 6 | arrayOfInt[paramArrayOfChar[i7]];
      i7 = j + 1;
      arrayOfByte[j] = ((byte)(i6 >> 16));
      i3 = i7 + 1;
      arrayOfByte[i7] = ((byte)(i6 >> 8));
      arrayOfByte[i3] = ((byte)i6);
      j = k;
      if (i1 > 0)
      {
        k += 1;
        j = k;
        if (k == 19)
        {
          m += 2;
          k = 0;
          continue;
        }
      }
      k = j;
    }
    if (j < i4)
    {
      i1 = 0;
      k = i2;
      while (m <= n - i)
      {
        k |= b[paramArrayOfChar[m]] << 18 - i1 * 6;
        i1 += 1;
        m += 1;
      }
      i = 16;
      while (j < i4)
      {
        arrayOfByte[j] = ((byte)(k >> i));
        i -= 8;
        j += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static final byte[] encodeToByte(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i2 = 0;
    int m;
    if (paramArrayOfByte != null) {
      m = paramArrayOfByte.length;
    } else {
      m = 0;
    }
    if (m == 0) {
      return new byte[0];
    }
    int i4 = m / 3 * 3;
    int i3 = m - 1;
    int k = i3 / 3 + 1 << 2;
    int j;
    if (paramBoolean) {
      j = (k - 1) / 76 << 1;
    } else {
      j = 0;
    }
    int i5 = k + j;
    byte[] arrayOfByte = new byte[i5];
    int i1 = 0;
    k = 0;
    for (int n = 0; i1 < i4; n = j)
    {
      j = i1 + 1;
      i1 = paramArrayOfByte[i1];
      int i6 = j + 1;
      j = (i1 & 0xFF) << 16 | (paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[i6] & 0xFF;
      i1 = k + 1;
      char[] arrayOfChar = a;
      arrayOfByte[k] = ((byte)arrayOfChar[(j >>> 18 & 0x3F)]);
      k = i1 + 1;
      arrayOfByte[i1] = ((byte)arrayOfChar[(j >>> 12 & 0x3F)]);
      int i7 = k + 1;
      arrayOfByte[k] = ((byte)arrayOfChar[(j >>> 6 & 0x3F)]);
      i1 = i7 + 1;
      arrayOfByte[i7] = ((byte)arrayOfChar[(j & 0x3F)]);
      k = i1;
      j = n;
      if (paramBoolean)
      {
        n += 1;
        k = i1;
        j = n;
        if (n == 19)
        {
          k = i1;
          j = n;
          if (i1 < i5 - 2)
          {
            j = i1 + 1;
            arrayOfByte[i1] = 13;
            k = j + 1;
            arrayOfByte[j] = 10;
            j = 0;
          }
        }
      }
      i1 = i6 + 1;
    }
    k = m - i4;
    if (k > 0)
    {
      m = paramArrayOfByte[i4];
      j = i2;
      if (k == 2) {
        j = (paramArrayOfByte[i3] & 0xFF) << 2;
      }
      j = (m & 0xFF) << 10 | j;
      paramArrayOfByte = a;
      arrayOfByte[(i5 - 4)] = ((byte)paramArrayOfByte[(j >> 12)]);
      arrayOfByte[(i5 - 3)] = ((byte)paramArrayOfByte[(j >>> 6 & 0x3F)]);
      int i;
      if (k == 2) {
        i = (byte)paramArrayOfByte[(j & 0x3F)];
      } else {
        i = 61;
      }
      arrayOfByte[(i5 - 2)] = i;
      arrayOfByte[(i5 - 1)] = 61;
    }
    return arrayOfByte;
  }
  
  public static final char[] encodeToChar(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i2 = 0;
    int m;
    if (paramArrayOfByte != null) {
      m = paramArrayOfByte.length;
    } else {
      m = 0;
    }
    if (m == 0) {
      return new char[0];
    }
    int i4 = m / 3 * 3;
    int i3 = m - 1;
    int k = i3 / 3 + 1 << 2;
    int j;
    if (paramBoolean) {
      j = (k - 1) / 76 << 1;
    } else {
      j = 0;
    }
    int i5 = k + j;
    char[] arrayOfChar1 = new char[i5];
    int i1 = 0;
    k = 0;
    for (int n = 0; i1 < i4; n = j)
    {
      j = i1 + 1;
      i1 = paramArrayOfByte[i1];
      int i6 = j + 1;
      j = (i1 & 0xFF) << 16 | (paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[i6] & 0xFF;
      i1 = k + 1;
      char[] arrayOfChar2 = a;
      arrayOfChar1[k] = arrayOfChar2[(j >>> 18 & 0x3F)];
      k = i1 + 1;
      arrayOfChar1[i1] = arrayOfChar2[(j >>> 12 & 0x3F)];
      int i7 = k + 1;
      arrayOfChar1[k] = arrayOfChar2[(j >>> 6 & 0x3F)];
      i1 = i7 + 1;
      arrayOfChar1[i7] = arrayOfChar2[(j & 0x3F)];
      k = i1;
      j = n;
      if (paramBoolean)
      {
        n += 1;
        k = i1;
        j = n;
        if (n == 19)
        {
          k = i1;
          j = n;
          if (i1 < i5 - 2)
          {
            j = i1 + 1;
            arrayOfChar1[i1] = '\r';
            k = j + 1;
            arrayOfChar1[j] = '\n';
            j = 0;
          }
        }
      }
      i1 = i6 + 1;
    }
    k = m - i4;
    if (k > 0)
    {
      m = paramArrayOfByte[i4];
      j = i2;
      if (k == 2) {
        j = (paramArrayOfByte[i3] & 0xFF) << 2;
      }
      j = (m & 0xFF) << 10 | j;
      paramArrayOfByte = a;
      arrayOfChar1[(i5 - 4)] = paramArrayOfByte[(j >> 12)];
      arrayOfChar1[(i5 - 3)] = paramArrayOfByte[(j >>> 6 & 0x3F)];
      int i;
      if (k == 2) {
        i = paramArrayOfByte[(j & 0x3F)];
      } else {
        i = 61;
      }
      arrayOfChar1[(i5 - 2)] = i;
      arrayOfChar1[(i5 - 1)] = '=';
    }
    return arrayOfChar1;
  }
  
  public static final String encodeToString(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new String(encodeToChar(paramArrayOfByte, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.Base64
 * JD-Core Version:    0.7.0.1
 */