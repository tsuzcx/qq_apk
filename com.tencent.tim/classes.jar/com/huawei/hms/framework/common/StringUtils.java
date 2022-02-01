package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringUtils
{
  private static final int INIT_CAPACITY = 1024;
  private static final String TAG = "StringUtils";
  
  public static String anonymizeMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (i % 2 == 1) {
        paramString[i] = 42;
      }
      i += 1;
    }
    return new String(paramString);
  }
  
  public static String byte2Str(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", paramArrayOfByte);
    }
    return "";
  }
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    if (paramString == null) {
      return "";
    }
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public static byte[] getBytes(long paramLong)
  {
    return getBytes(String.valueOf(paramLong));
  }
  
  public static byte[] getBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    if (paramString == null) {
      return arrayOfByte;
    }
    try
    {
      paramString = paramString.getBytes("utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Logger.w("StringUtils", "the content has error while it is converted to bytes");
    }
    return arrayOfByte;
  }
  
  public static String getTraceInfo(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramThrowable[i];
      localStringBuilder.append("at ").append(localObject.toString()).append(";");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] str2Byte(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new byte[0];
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", paramString);
    }
    return new byte[0];
  }
  
  public static boolean strEquals(String paramString1, String paramString2)
  {
    return (paramString1 == paramString2) || ((paramString1 != null) && (paramString1.equals(paramString2)));
  }
  
  public static String toLowerCase(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    return paramString.toLowerCase(Locale.ROOT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.common.StringUtils
 * JD-Core Version:    0.7.0.1
 */