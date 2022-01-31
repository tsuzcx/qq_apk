package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

public class HexUtil
{
  public static final byte[] a;
  private static final char[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public static byte a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return (byte)(paramChar - '0');
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return (byte)(paramChar - 'a' + 10);
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return (byte)(paramChar - 'A' + 10);
    }
    return 0;
  }
  
  public static byte a(String paramString)
  {
    byte b2 = 0;
    byte b1 = b2;
    if (paramString != null)
    {
      b1 = b2;
      if (paramString.length() == 1) {
        b1 = a(paramString.charAt(0));
      }
    }
    return b1;
  }
  
  public static String a(byte paramByte)
  {
    int i = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramByte = (byte)(paramByte >>> 4);
    return new String(new char[] { jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)], i });
  }
  
  public static String a(String paramString)
  {
    return new String(a(paramString));
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2 + 0)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "bytes = null or bytes.length = 0");
      }
      return;
      break label249;
    }
    label22:
    StringBuilder localStringBuilder1 = new StringBuilder((paramArrayOfByte.length + 15) / 16 * 73 + 85);
    localStringBuilder1.append("buf size: " + paramArrayOfByte.length).append("\r\n");
    localStringBuilder1.append("______00_01_02_03_04_05_06_07_08_09_0A_0B_0C_0D_0E_0F\r\n");
    StringBuilder localStringBuilder2 = new StringBuilder(32);
    localStringBuilder2.append(" ");
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j < paramArrayOfByte.length)
      {
        if (i == 0) {
          localStringBuilder1.append(String.format("%04x: ", new Object[] { Integer.valueOf(j) }));
        }
        localStringBuilder1.append(String.format("%02x ", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
        if ((paramArrayOfByte[j] >= 32) && (paramArrayOfByte[j] <= 127)) {
          localStringBuilder2.append(String.format("%c", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
        }
      }
      for (;;)
      {
        int m = i + 1;
        i = m;
        if (m < 16) {
          break label305;
        }
        localStringBuilder1.append(localStringBuilder2.toString()).append("\r\n");
        localStringBuilder2.setLength(1);
        if (k == 0) {
          break label303;
        }
        label249:
        if (!QLog.isColorLevel()) {
          break label22;
        }
        QLog.i(paramString, 2, localStringBuilder1.toString());
        return;
        localStringBuilder2.append(".");
        continue;
        if (i == 0) {
          break;
        }
        localStringBuilder1.append("   ");
        localStringBuilder2.append(" ");
        k = 1;
      }
      label303:
      i = 0;
      label305:
      j += 1;
    }
  }
  
  public static void a(String[] paramArrayOfString)
  {
    System.currentTimeMillis();
    int i = 0;
    while (i < 1000000)
    {
      paramArrayOfString = "234" + i;
      if (!new String(a(a(paramArrayOfString.getBytes()))).equals(paramArrayOfString)) {}
      i += 1;
    }
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return jdField_a_of_type_ArrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      char c1 = paramString.charAt(i * 2);
      char c2 = paramString.charAt(i * 2 + 1);
      arrayOfByte[i] = ((byte)(a(c1) * 16 + a(c2)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString)
  {
    return a(paramString.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HexUtil
 * JD-Core Version:    0.7.0.1
 */