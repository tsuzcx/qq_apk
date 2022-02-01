package com.tencent.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class apw
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  public static String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 3);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append(a[(k >> 4)]);
      localStringBuilder.append(a[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apw
 * JD-Core Version:    0.7.0.1
 */