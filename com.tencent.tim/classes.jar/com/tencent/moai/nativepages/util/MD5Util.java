package com.tencent.moai.nativepages.util;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

public class MD5Util
{
  protected static ThreadLocal<MessageDigest> TLS_digest = new MD5Util.1();
  protected static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = hexDigits[((paramByte & 0xF0) >> 4)];
    char c2 = hexDigits[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  @Deprecated
  public static String getFileMD5String(File paramFile)
    throws IOException
  {
    return MD5.getMD5(paramFile);
  }
  
  public static String getMD5String(String paramString)
  {
    return getMD5String(paramString.getBytes());
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    return bufferToHex(((MessageDigest)TLS_digest.get()).digest(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.MD5Util
 * JD-Core Version:    0.7.0.1
 */