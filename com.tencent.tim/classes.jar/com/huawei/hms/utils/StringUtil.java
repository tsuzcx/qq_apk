package com.huawei.hms.utils;

public class StringUtil
{
  public static String addByteForNum(String paramString, int paramInt, char paramChar)
  {
    int i = paramString.length();
    if (i == paramInt) {
      return paramString;
    }
    if (i > paramInt) {
      return paramString.substring(i - paramInt);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    while (i < paramInt)
    {
      localStringBuffer.append(paramChar);
      i += 1;
    }
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  public static String objDesc(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getName() + '@' + Integer.toHexString(paramObject.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */