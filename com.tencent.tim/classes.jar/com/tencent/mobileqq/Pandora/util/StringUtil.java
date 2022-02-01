package com.tencent.mobileqq.Pandora.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil
{
  public static String listToString(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append((String)paramList.get(i));
      localStringBuilder.append(paramString);
      i += 1;
    }
    localStringBuilder.delete(localStringBuilder.lastIndexOf(paramString), localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public static List<String> split(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return new ArrayList();
    }
    return Arrays.asList(paramString1.split(paramString2));
  }
  
  public static long stringToLong(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      return l;
    }
    catch (Exception paramString2)
    {
      Log.e(paramString1, "StringTolong is exception :", paramString2);
    }
    return 0L;
  }
  
  public static byte[] toByteArray(String paramString)
  {
    int i = 0;
    paramString = paramString.toLowerCase();
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int j = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)((byte)(Character.digit(paramString.charAt(j), 16) & 0xFF) << 4 | (byte)(Character.digit(paramString.charAt(j + 1), 16) & 0xFF)));
      j += 2;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */