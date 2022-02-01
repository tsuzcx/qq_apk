package com.tencent.manager.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class b
{
  protected static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static MessageDigest b = null;
  
  static
  {
    try
    {
      b = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  public static String a(File paramFile)
  {
    paramFile = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramFile.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      b.update(arrayOfByte, 0, i);
    }
    paramFile.close();
    return a(b.digest());
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = a[((paramByte & 0xF0) >> 4)];
    char c2 = a[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.b
 * JD-Core Version:    0.7.0.1
 */