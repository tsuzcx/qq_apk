package com.huawei.agconnect.config.impl;

public class Hex
{
  private static final char[] hexCode = "0123456789ABCDEF".toCharArray();
  
  private static byte[] decodeHex(char[] paramArrayOfChar)
  {
    int j = 0;
    if ((paramArrayOfChar.length & 0x1) != 0) {
      throw new IllegalArgumentException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[paramArrayOfChar.length >> 1];
    int i = 0;
    while (j < paramArrayOfChar.length)
    {
      int k = Character.digit(paramArrayOfChar[j], 16);
      if (k == -1) {
        throw new IllegalArgumentException("Illegal hexadecimal character at index " + j);
      }
      j += 1;
      int m = Character.digit(paramArrayOfChar[j], 16);
      if (m == -1) {
        throw new IllegalArgumentException("Illegal hexadecimal character at index " + j);
      }
      j += 1;
      arrayOfByte[i] = ((byte)((k << 4 | m) & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] decodeHexString(String paramString)
  {
    return decodeHex(paramString.toCharArray());
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(hexCode[(k >> 4 & 0xF)]);
      localStringBuilder.append(hexCode[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.Hex
 * JD-Core Version:    0.7.0.1
 */