package com.tencent.commonsdk.util;

import java.lang.reflect.Field;

public class StringUtils
{
  static volatile boolean reflactCharArrayResult = true;
  static volatile boolean reflactDataResult;
  static Field sCountField;
  static Field sValueField = null;
  
  static
  {
    sCountField = null;
    reflactDataResult = true;
  }
  
  public static char[] getStringValue(StringBuilder paramStringBuilder)
  {
    try
    {
      if (sValueField == null)
      {
        sValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        sValueField.setAccessible(true);
      }
      paramStringBuilder = (char[])sValueField.get(paramStringBuilder);
      return paramStringBuilder;
    }
    catch (NoSuchFieldException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramStringBuilder)
    {
      for (;;)
      {
        paramStringBuilder.printStackTrace();
      }
    }
    catch (IllegalAccessException paramStringBuilder)
    {
      for (;;)
      {
        paramStringBuilder.printStackTrace();
      }
    }
  }
  
  public static String newStringWithData(char[] paramArrayOfChar)
  {
    try
    {
      String str = new String();
      if (reflactDataResult)
      {
        if (sValueField == null)
        {
          sValueField = String.class.getDeclaredField("value");
          sValueField.setAccessible(true);
        }
        if (sCountField == null)
        {
          sCountField = String.class.getDeclaredField("count");
          sCountField.setAccessible(true);
        }
        sValueField.set(str, paramArrayOfChar);
        sCountField.set(str, Integer.valueOf(paramArrayOfChar.length));
        return str;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      reflactDataResult = false;
      return new String(paramArrayOfChar);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public static char[] reflactCharArray(String paramString)
  {
    try
    {
      if (reflactCharArrayResult)
      {
        if (sValueField == null)
        {
          sValueField = String.class.getDeclaredField("value");
          sValueField.setAccessible(true);
        }
        paramString = (char[])sValueField.get(paramString);
        return paramString;
      }
    }
    catch (NoSuchFieldException paramString)
    {
      paramString.printStackTrace();
      reflactCharArrayResult = false;
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.StringUtils
 * JD-Core Version:    0.7.0.1
 */