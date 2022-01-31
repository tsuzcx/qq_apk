package com.tencent.qqprotect.singleupdate;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5FileUtil
{
  protected static MessageDigest a;
  protected static char[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    jdField_a_of_type_JavaSecurityMessageDigest = null;
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  public static String a(File paramFile)
  {
    paramFile = new FileInputStream(paramFile).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, paramFile.length());
    jdField_a_of_type_JavaSecurityMessageDigest.update(paramFile);
    return b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
  }
  
  public static String a(String paramString)
  {
    return a(paramString.getBytes());
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
    return b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
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
    char c1 = jdField_a_of_type_ArrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return a(paramString1).equals(paramString2);
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.MD5FileUtil
 * JD-Core Version:    0.7.0.1
 */