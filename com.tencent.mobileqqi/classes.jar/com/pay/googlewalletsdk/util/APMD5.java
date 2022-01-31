package com.pay.googlewalletsdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class APMD5
{
  public static String parseByte2HexStr(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuffer.toString();
      }
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = '0' + str2;
      }
      localStringBuffer.append(str1.toUpperCase());
      i += 1;
    }
  }
  
  public static String toMd5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = parseByte2HexStr(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.APMD5
 * JD-Core Version:    0.7.0.1
 */