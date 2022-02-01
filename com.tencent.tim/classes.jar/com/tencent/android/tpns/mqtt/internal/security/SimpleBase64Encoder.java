package com.tencent.android.tpns.mqtt.internal.security;

public class SimpleBase64Encoder
{
  private static final char[] PWDCHARS_ARRAY = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
  private static final String PWDCHARS_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  
  public static byte[] decode(String paramString)
  {
    paramString = paramString.getBytes();
    int k = paramString.length;
    byte[] arrayOfByte = new byte[k * 3 / 4];
    int j = 0;
    int i = 0;
    long l;
    int m;
    while (k >= 4)
    {
      l = from64(paramString, j, 4);
      k -= 4;
      m = j + 4;
      j = 2;
      while (j >= 0)
      {
        arrayOfByte[(i + j)] = ((byte)(int)(0xFF & l));
        l >>= 8;
        j -= 1;
      }
      i += 3;
      j = m;
    }
    if (k == 3)
    {
      l = from64(paramString, j, 3);
      m = 1;
      while (m >= 0)
      {
        arrayOfByte[(i + m)] = ((byte)(int)(0xFF & l));
        l >>= 8;
        m -= 1;
      }
    }
    if (k == 2) {
      arrayOfByte[i] = ((byte)(int)(from64(paramString, j, 2) & 0xFF));
    }
    return arrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer((i + 2) / 3 * 4);
    int j = 0;
    while (i >= 3)
    {
      localStringBuffer.append(to64((paramArrayOfByte[j] & 0xFF) << 16 | (paramArrayOfByte[(j + 1)] & 0xFF) << 8 | paramArrayOfByte[(j + 2)] & 0xFF, 4));
      j += 3;
      i -= 3;
    }
    if (i == 2) {
      localStringBuffer.append(to64((paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[(j + 1)] & 0xFF, 3));
    }
    if (i == 1) {
      localStringBuffer.append(to64(paramArrayOfByte[j] & 0xFF, 2));
    }
    return localStringBuffer.toString();
  }
  
  private static final long from64(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    long l3 = 0L;
    int i = paramInt2;
    paramInt2 = j;
    if (i > 0)
    {
      i -= 1;
      j = paramArrayOfByte[paramInt1];
      if (j != 47) {
        break label156;
      }
    }
    label156:
    for (long l2 = 1L;; l2 = 0L)
    {
      long l1 = l2;
      if (j >= 48)
      {
        l1 = l2;
        if (j <= 57) {
          l1 = j + 2 - 48;
        }
      }
      l2 = l1;
      if (j >= 65)
      {
        l2 = l1;
        if (j <= 90) {
          l2 = j + 12 - 65;
        }
      }
      l1 = l2;
      if (j >= 97)
      {
        l1 = l2;
        if (j <= 122) {
          l1 = j + 38 - 97;
        }
      }
      l3 += (l1 << paramInt2);
      paramInt2 += 6;
      paramInt1 += 1;
      break;
      return l3;
    }
  }
  
  private static final String to64(long paramLong, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    while (paramInt > 0)
    {
      paramInt -= 1;
      localStringBuffer.append(PWDCHARS_ARRAY[((int)(0x3F & paramLong))]);
      paramLong >>= 6;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.security.SimpleBase64Encoder
 * JD-Core Version:    0.7.0.1
 */