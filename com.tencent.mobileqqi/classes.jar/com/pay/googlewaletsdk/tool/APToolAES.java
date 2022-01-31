package com.pay.googlewaletsdk.tool;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class APToolAES
{
  public static String decPress(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 5;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuffer.toString();
      }
      int j = (byte)(paramArrayOfByte[i] >> 4 & 0xF);
      int k = (byte)(paramArrayOfByte[i] & 0xF);
      localStringBuffer.append(j);
      localStringBuffer.append(k);
      i += 1;
    }
  }
  
  public static String decryptAES(byte[] paramArrayOfByte, String paramString)
  {
    byte[] arrayOfByte = (byte[])null;
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, paramString);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return new String(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
    }
  }
  
  public static String decryptDES(byte[] paramArrayOfByte, String paramString)
  {
    byte[] arrayOfByte = (byte[])null;
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, paramString);
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return new String(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
    }
  }
  
  public static String doDecode(String paramString1, String paramString2)
  {
    return decryptAES(parseHexStr2Byte(paramString1), paramString2);
  }
  
  public static String doEncode(String paramString1, String paramString2)
  {
    for (paramString1 = new String(paramString1);; paramString1 = paramString1 + "a") {
      if (paramString1.length() % 16 == 0) {
        return encryptAES(paramString1, paramString2);
      }
    }
  }
  
  public static String encryptAES(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = (byte[])null;
    try
    {
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(1, paramString2);
      paramString2 = localCipher.doFinal(paramString1.getBytes());
      if (paramString2 != null) {
        paramString1 = new String(parseByte2HexStr(paramString2));
      }
      return paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        paramString2 = arrayOfByte;
      }
    }
  }
  
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
  
  public static byte[] parseHexStr2Byte(String paramString)
  {
    Object localObject;
    if (paramString.length() < 1)
    {
      localObject = null;
      return localObject;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= paramString.length() / 2) {
        break;
      }
      arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(i * 2, i * 2 + 1), 16) * 16 + Integer.parseInt(paramString.substring(i * 2 + 1, i * 2 + 2), 16)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewaletsdk.tool.APToolAES
 * JD-Core Version:    0.7.0.1
 */