package com.tencent.moai.nativepages.util;

import android.text.TextUtils;

public class StringUtil
{
  public static double getDouble(String paramString, double paramDouble)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramDouble;
      }
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramDouble;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    return TextUtils.isEmpty(paramString);
  }
  
  public static String nullAs(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static float safeParseDouble(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0.0F;
      }
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
  
  public static int safeParseInt(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */