package com.tencent.token;

import java.io.UnsupportedEncodingException;

final class amu
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] b = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }
  
  private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfByte1.length + 2) / 3 * 4];
    int k = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int i = 0;
    int j = 0;
    int m;
    while (i < k)
    {
      m = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[i] & 0xFF) >> 2)];
      j = m + 1;
      int i1 = paramArrayOfByte1[i];
      int n = i + 1;
      arrayOfByte[m] = paramArrayOfByte2[((i1 & 0x3) << 4 | (paramArrayOfByte1[n] & 0xFF) >> 4)];
      m = j + 1;
      i1 = paramArrayOfByte1[n];
      n = i + 2;
      arrayOfByte[j] = paramArrayOfByte2[((i1 & 0xF) << 2 | (paramArrayOfByte1[n] & 0xFF) >> 6)];
      j = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[(paramArrayOfByte1[n] & 0x3F)];
      i += 3;
    }
    switch (paramArrayOfByte1.length % 3)
    {
    default: 
      break;
    case 2: 
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xFF) >> 2)];
      j = i + 1;
      m = paramArrayOfByte1[k];
      k += 1;
      arrayOfByte[i] = paramArrayOfByte2[((m & 0x3) << 4 | (paramArrayOfByte1[k] & 0xFF) >> 4)];
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xF) << 2)];
      arrayOfByte[(j + 1)] = 61;
      break;
    case 1: 
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xFF) >> 2)];
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0x3) << 4)];
      arrayOfByte[j] = 61;
      arrayOfByte[(j + 1)] = 61;
    }
    try
    {
      paramArrayOfByte1 = new String(arrayOfByte, "US-ASCII");
      return paramArrayOfByte1;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      throw new AssertionError(paramArrayOfByte1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amu
 * JD-Core Version:    0.7.0.1
 */