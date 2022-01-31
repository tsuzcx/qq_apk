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
    if (paramString != null) {}
    for (int i = paramString.length(); i == 0; i = 0) {
      return new byte[0];
    }
    int k = 0;
    for (int j = 0; k < i; j = m)
    {
      m = j;
      if (b[paramString.charAt(k)] < 0) {
        m = j + 1;
      }
      k += 1;
    }
    if ((i - j) % 4 != 0) {
      return null;
    }
    k = i;
    int m = 0;
    int n;
    while (k > 1)
    {
      localObject = b;
      n = k - 1;
      if (localObject[paramString.charAt(n)] > 0) {
        break;
      }
      k = n;
      if (paramString.charAt(n) == '=')
      {
        m += 1;
        k = n;
      }
    }
    int i1 = ((i - j) * 6 >> 3) - m;
    Object localObject = new byte[i1];
    k = 0;
    i = 0;
    if (k < i1)
    {
      m = 0;
      n = 0;
      j = i;
      i = n;
      if (i < 4)
      {
        n = b[paramString.charAt(j)];
        if (n >= 0) {
          m |= n << 18 - i * 6;
        }
        for (;;)
        {
          i += 1;
          j += 1;
          break;
          i -= 1;
        }
      }
      n = k + 1;
      localObject[k] = ((byte)(m >> 16));
      i = n;
      if (n < i1)
      {
        i = n + 1;
        localObject[n] = ((byte)(m >> 8));
        if (i >= i1) {
          break label293;
        }
        k = i + 1;
        localObject[i] = ((byte)m);
        i = k;
      }
    }
    label293:
    for (;;)
    {
      k = i;
      i = j;
      break;
      return localObject;
    }
  }
  
  public static final byte[] decode(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    int j = 0;
    for (int i = 0; j < m; i = k)
    {
      k = i;
      if (b[(paramArrayOfByte[j] & 0xFF)] < 0) {
        k = i + 1;
      }
      j += 1;
    }
    if ((m - i) % 4 != 0) {
      return null;
    }
    j = m;
    int k = 0;
    int n;
    while (j > 1)
    {
      localObject = b;
      n = j - 1;
      if (localObject[(paramArrayOfByte[n] & 0xFF)] > 0) {
        break;
      }
      j = n;
      if (paramArrayOfByte[n] == 61)
      {
        k += 1;
        j = n;
      }
    }
    int i1 = ((m - i) * 6 >> 3) - k;
    Object localObject = new byte[i1];
    k = 0;
    i = 0;
    if (k < i1)
    {
      m = 0;
      n = 0;
      j = i;
      i = n;
      if (i < 4)
      {
        n = b[(paramArrayOfByte[j] & 0xFF)];
        if (n >= 0) {
          m |= n << 18 - i * 6;
        }
        for (;;)
        {
          i += 1;
          j += 1;
          break;
          i -= 1;
        }
      }
      n = k + 1;
      localObject[k] = ((byte)(m >> 16));
      i = n;
      if (n < i1)
      {
        i = n + 1;
        localObject[n] = ((byte)(m >> 8));
        if (i >= i1) {
          break label276;
        }
        k = i + 1;
        localObject[i] = ((byte)m);
        i = k;
      }
    }
    label276:
    for (;;)
    {
      k = i;
      i = j;
      break;
      return localObject;
    }
  }
  
  public static final byte[] decode(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null) {}
    for (int i = paramArrayOfChar.length; i == 0; i = 0) {
      return new byte[0];
    }
    int k = 0;
    for (int j = 0; k < i; j = m)
    {
      m = j;
      if (b[paramArrayOfChar[k]] < 0) {
        m = j + 1;
      }
      k += 1;
    }
    if ((i - j) % 4 != 0) {
      return null;
    }
    k = i;
    int m = 0;
    int n;
    while (k > 1)
    {
      localObject = b;
      n = k - 1;
      if (localObject[paramArrayOfChar[n]] > 0) {
        break;
      }
      k = n;
      if (paramArrayOfChar[n] == '=')
      {
        m += 1;
        k = n;
      }
    }
    int i1 = ((i - j) * 6 >> 3) - m;
    Object localObject = new byte[i1];
    k = 0;
    i = 0;
    if (k < i1)
    {
      m = 0;
      n = 0;
      j = i;
      i = n;
      if (i < 4)
      {
        n = b[paramArrayOfChar[j]];
        if (n >= 0) {
          m |= n << 18 - i * 6;
        }
        for (;;)
        {
          i += 1;
          j += 1;
          break;
          i -= 1;
        }
      }
      n = k + 1;
      localObject[k] = ((byte)(m >> 16));
      i = n;
      if (n < i1)
      {
        i = n + 1;
        localObject[n] = ((byte)(m >> 8));
        if (i >= i1) {
          break label283;
        }
        k = i + 1;
        localObject[i] = ((byte)m);
        i = k;
      }
    }
    label283:
    for (;;)
    {
      k = i;
      i = j;
      break;
      return localObject;
    }
  }
  
  public static final byte[] decodeFast(String paramString)
  {
    int i2 = 0;
    int k = paramString.length();
    if (k == 0) {
      return new byte[0];
    }
    int n = k - 1;
    int i = 0;
    while ((i < n) && (b[(paramString.charAt(i) & 0xFF)] < 0)) {
      i += 1;
    }
    for (;;)
    {
      if ((n > 0) && (b[(paramString.charAt(n) & 0xFF)] < 0))
      {
        n -= 1;
      }
      else
      {
        int j;
        int m;
        if (paramString.charAt(n) == '=') {
          if (paramString.charAt(n - 1) == '=')
          {
            j = 2;
            m = n - i + 1;
            if (k <= 76) {
              break label388;
            }
            if (paramString.charAt(76) != '\r') {
              break label383;
            }
            k = m / 78;
          }
        }
        label140:
        int i6;
        byte[] arrayOfByte;
        int i3;
        label388:
        for (int i1 = k << 1;; i1 = 0)
        {
          i6 = ((m - i1) * 6 >> 3) - j;
          arrayOfByte = new byte[i6];
          int i7 = i6 / 3;
          m = 0;
          k = 0;
          while (k < i7 * 3)
          {
            int[] arrayOfInt = b;
            int i4 = i + 1;
            i = arrayOfInt[paramString.charAt(i)];
            arrayOfInt = b;
            i3 = i4 + 1;
            i4 = arrayOfInt[paramString.charAt(i4)];
            arrayOfInt = b;
            int i5 = i3 + 1;
            int i8 = arrayOfInt[paramString.charAt(i3)];
            arrayOfInt = b;
            i3 = i5 + 1;
            i = i8 << 6 | i << 18 | i4 << 12 | arrayOfInt[paramString.charAt(i5)];
            i4 = k + 1;
            arrayOfByte[k] = ((byte)(i >> 16));
            k = i4 + 1;
            arrayOfByte[i4] = ((byte)(i >> 8));
            i4 = k + 1;
            arrayOfByte[k] = ((byte)i);
            i = i3;
            k = i4;
            if (i1 > 0)
            {
              i5 = m + 1;
              m = i5;
              i = i3;
              k = i4;
              if (i5 == 19)
              {
                i = i3 + 2;
                m = 0;
                k = i4;
              }
            }
          }
          j = 1;
          break;
          j = 0;
          break;
          label383:
          k = 0;
          break label140;
        }
        if (k < i6)
        {
          i1 = i;
          m = 0;
          i = i2;
          for (;;)
          {
            i2 = i;
            if (i1 > n - j) {
              break;
            }
            i3 = b[paramString.charAt(i1)];
            i = i2 + 1;
            m = i3 << 18 - i2 * 6 | m;
            i1 += 1;
          }
          j = 16;
          i = k;
          while (i < i6)
          {
            arrayOfByte[i] = ((byte)(m >> j));
            j -= 8;
            i += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  public static final byte[] decodeFast(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int k = paramArrayOfByte.length;
    if (k == 0) {
      return new byte[0];
    }
    int n = k - 1;
    int i = 0;
    while ((i < n) && (b[(paramArrayOfByte[i] & 0xFF)] < 0)) {
      i += 1;
    }
    for (;;)
    {
      if ((n > 0) && (b[(paramArrayOfByte[n] & 0xFF)] < 0))
      {
        n -= 1;
      }
      else
      {
        int j;
        int m;
        if (paramArrayOfByte[n] == 61) {
          if (paramArrayOfByte[(n - 1)] == 61)
          {
            j = 2;
            m = n - i + 1;
            if (k <= 76) {
              break label368;
            }
            if (paramArrayOfByte[76] != 13) {
              break label363;
            }
            k = m / 78;
          }
        }
        label128:
        int i6;
        byte[] arrayOfByte;
        int i3;
        label363:
        label368:
        for (int i1 = k << 1;; i1 = 0)
        {
          i6 = ((m - i1) * 6 >> 3) - j;
          arrayOfByte = new byte[i6];
          int i7 = i6 / 3;
          m = 0;
          k = 0;
          while (k < i7 * 3)
          {
            int[] arrayOfInt = b;
            int i4 = i + 1;
            i = arrayOfInt[paramArrayOfByte[i]];
            arrayOfInt = b;
            i3 = i4 + 1;
            i4 = arrayOfInt[paramArrayOfByte[i4]];
            arrayOfInt = b;
            int i5 = i3 + 1;
            int i8 = arrayOfInt[paramArrayOfByte[i3]];
            arrayOfInt = b;
            i3 = i5 + 1;
            i = i8 << 6 | i << 18 | i4 << 12 | arrayOfInt[paramArrayOfByte[i5]];
            i4 = k + 1;
            arrayOfByte[k] = ((byte)(i >> 16));
            k = i4 + 1;
            arrayOfByte[i4] = ((byte)(i >> 8));
            i4 = k + 1;
            arrayOfByte[k] = ((byte)i);
            i = i3;
            k = i4;
            if (i1 > 0)
            {
              i5 = m + 1;
              m = i5;
              i = i3;
              k = i4;
              if (i5 == 19)
              {
                i = i3 + 2;
                m = 0;
                k = i4;
              }
            }
          }
          j = 1;
          break;
          j = 0;
          break;
          k = 0;
          break label128;
        }
        if (k < i6)
        {
          i1 = i;
          m = 0;
          i = i2;
          for (;;)
          {
            i2 = i;
            if (i1 > n - j) {
              break;
            }
            i3 = b[paramArrayOfByte[i1]];
            i = i2 + 1;
            m = i3 << 18 - i2 * 6 | m;
            i1 += 1;
          }
          j = 16;
          i = k;
          while (i < i6)
          {
            arrayOfByte[i] = ((byte)(m >> j));
            j -= 8;
            i += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  public static final byte[] decodeFast(char[] paramArrayOfChar)
  {
    int i2 = 0;
    int k = paramArrayOfChar.length;
    if (k == 0) {
      return new byte[0];
    }
    int n = k - 1;
    int i = 0;
    while ((i < n) && (b[paramArrayOfChar[i]] < 0)) {
      i += 1;
    }
    for (;;)
    {
      if ((n > 0) && (b[paramArrayOfChar[n]] < 0))
      {
        n -= 1;
      }
      else
      {
        int j;
        int m;
        if (paramArrayOfChar[n] == '=') {
          if (paramArrayOfChar[(n - 1)] == '=')
          {
            j = 2;
            m = n - i + 1;
            if (k <= 76) {
              break label360;
            }
            if (paramArrayOfChar[76] != '\r') {
              break label355;
            }
            k = m / 78;
          }
        }
        label120:
        int i6;
        byte[] arrayOfByte;
        int i3;
        label355:
        label360:
        for (int i1 = k << 1;; i1 = 0)
        {
          i6 = ((m - i1) * 6 >> 3) - j;
          arrayOfByte = new byte[i6];
          int i7 = i6 / 3;
          m = 0;
          k = 0;
          while (k < i7 * 3)
          {
            int[] arrayOfInt = b;
            int i4 = i + 1;
            i = arrayOfInt[paramArrayOfChar[i]];
            arrayOfInt = b;
            i3 = i4 + 1;
            i4 = arrayOfInt[paramArrayOfChar[i4]];
            arrayOfInt = b;
            int i5 = i3 + 1;
            int i8 = arrayOfInt[paramArrayOfChar[i3]];
            arrayOfInt = b;
            i3 = i5 + 1;
            i = i8 << 6 | i << 18 | i4 << 12 | arrayOfInt[paramArrayOfChar[i5]];
            i4 = k + 1;
            arrayOfByte[k] = ((byte)(i >> 16));
            k = i4 + 1;
            arrayOfByte[i4] = ((byte)(i >> 8));
            i4 = k + 1;
            arrayOfByte[k] = ((byte)i);
            i = i3;
            k = i4;
            if (i1 > 0)
            {
              i5 = m + 1;
              m = i5;
              i = i3;
              k = i4;
              if (i5 == 19)
              {
                i = i3 + 2;
                m = 0;
                k = i4;
              }
            }
          }
          j = 1;
          break;
          j = 0;
          break;
          k = 0;
          break label120;
        }
        if (k < i6)
        {
          i1 = i;
          m = 0;
          i = i2;
          for (;;)
          {
            i2 = i;
            if (i1 > n - j) {
              break;
            }
            i3 = b[paramArrayOfChar[i1]];
            i = i2 + 1;
            m = i3 << 18 - i2 * 6 | m;
            i1 += 1;
          }
          j = 16;
          i = k;
          while (i < i6)
          {
            arrayOfByte[i] = ((byte)(m >> j));
            j -= 8;
            i += 1;
          }
        }
        return arrayOfByte;
      }
    }
  }
  
  public static final byte[] encodeToByte(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramArrayOfByte != null) {}
    for (int m = paramArrayOfByte.length; m == 0; m = 0) {
      return new byte[0];
    }
    int i5 = m / 3 * 3;
    int k = (m - 1) / 3 + 1 << 2;
    if (paramBoolean) {}
    int i6;
    byte[] arrayOfByte;
    int n;
    for (int j = (k - 1) / 76 << 1;; j = 0)
    {
      i6 = k + j;
      arrayOfByte = new byte[i6];
      j = 0;
      k = 0;
      n = 0;
      while (n < i5)
      {
        int i2 = n + 1;
        n = paramArrayOfByte[n];
        int i3 = i2 + 1;
        int i4 = paramArrayOfByte[i2];
        i2 = i3 + 1;
        n = (i4 & 0xFF) << 8 | (n & 0xFF) << 16 | paramArrayOfByte[i3] & 0xFF;
        i3 = k + 1;
        arrayOfByte[k] = ((byte)a[(n >>> 18 & 0x3F)]);
        k = i3 + 1;
        arrayOfByte[i3] = ((byte)a[(n >>> 12 & 0x3F)]);
        i4 = k + 1;
        arrayOfByte[k] = ((byte)a[(n >>> 6 & 0x3F)]);
        i3 = i4 + 1;
        arrayOfByte[i4] = ((byte)a[(n & 0x3F)]);
        k = i3;
        n = i2;
        if (paramBoolean)
        {
          i4 = j + 1;
          j = i4;
          k = i3;
          n = i2;
          if (i4 == 19)
          {
            j = i4;
            k = i3;
            n = i2;
            if (i3 < i6 - 2)
            {
              j = i3 + 1;
              arrayOfByte[i3] = 13;
              arrayOfByte[j] = 10;
              k = j + 1;
              j = 0;
              n = i2;
            }
          }
        }
      }
    }
    k = m - i5;
    if (k > 0)
    {
      n = paramArrayOfByte[i5];
      j = i1;
      if (k == 2) {
        j = (paramArrayOfByte[(m - 1)] & 0xFF) << 2;
      }
      j |= (n & 0xFF) << 10;
      arrayOfByte[(i6 - 4)] = ((byte)a[(j >> 12)]);
      arrayOfByte[(i6 - 3)] = ((byte)a[(j >>> 6 & 0x3F)]);
      if (k != 2) {
        break label455;
      }
    }
    label455:
    for (int i = (byte)a[(j & 0x3F)];; i = 61)
    {
      arrayOfByte[(i6 - 2)] = i;
      arrayOfByte[(i6 - 1)] = 61;
      return arrayOfByte;
    }
  }
  
  public static final char[] encodeToChar(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramArrayOfByte != null) {}
    for (int m = paramArrayOfByte.length; m == 0; m = 0) {
      return new char[0];
    }
    int i5 = m / 3 * 3;
    int k = (m - 1) / 3 + 1 << 2;
    if (paramBoolean) {}
    int i6;
    char[] arrayOfChar;
    int n;
    for (int j = (k - 1) / 76 << 1;; j = 0)
    {
      i6 = k + j;
      arrayOfChar = new char[i6];
      j = 0;
      k = 0;
      n = 0;
      while (n < i5)
      {
        int i2 = n + 1;
        n = paramArrayOfByte[n];
        int i3 = i2 + 1;
        int i4 = paramArrayOfByte[i2];
        i2 = i3 + 1;
        n = (i4 & 0xFF) << 8 | (n & 0xFF) << 16 | paramArrayOfByte[i3] & 0xFF;
        i3 = k + 1;
        arrayOfChar[k] = a[(n >>> 18 & 0x3F)];
        k = i3 + 1;
        arrayOfChar[i3] = a[(n >>> 12 & 0x3F)];
        i4 = k + 1;
        arrayOfChar[k] = a[(n >>> 6 & 0x3F)];
        i3 = i4 + 1;
        arrayOfChar[i4] = a[(n & 0x3F)];
        k = i3;
        n = i2;
        if (paramBoolean)
        {
          i4 = j + 1;
          j = i4;
          k = i3;
          n = i2;
          if (i4 == 19)
          {
            j = i4;
            k = i3;
            n = i2;
            if (i3 < i6 - 2)
            {
              j = i3 + 1;
              arrayOfChar[i3] = '\r';
              arrayOfChar[j] = '\n';
              k = j + 1;
              j = 0;
              n = i2;
            }
          }
        }
      }
    }
    k = m - i5;
    if (k > 0)
    {
      n = paramArrayOfByte[i5];
      j = i1;
      if (k == 2) {
        j = (paramArrayOfByte[(m - 1)] & 0xFF) << 2;
      }
      j |= (n & 0xFF) << 10;
      arrayOfChar[(i6 - 4)] = a[(j >> 12)];
      arrayOfChar[(i6 - 3)] = a[(j >>> 6 & 0x3F)];
      if (k != 2) {
        break label448;
      }
    }
    label448:
    for (int i = a[(j & 0x3F)];; i = 61)
    {
      arrayOfChar[(i6 - 2)] = i;
      arrayOfChar[(i6 - 1)] = '=';
      return arrayOfChar;
    }
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