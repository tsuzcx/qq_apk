package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;

public class PushMd5Pref
{
  private static String a(String paramString)
  {
    return Md5.md5(paramString);
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    try
    {
      paramFloat = PushPreferences.getFloat(paramContext, a(paramString), paramFloat);
      return paramFloat;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "getFloat", paramContext);
    }
    return 0.0F;
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramInt = PushPreferences.getInt(paramContext, a(paramString), paramInt);
      return paramInt;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "getInt", paramContext);
    }
    return 0;
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    try
    {
      paramLong = PushPreferences.getLong(paramContext, a(paramString), paramLong);
      return paramLong;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "getLong", paramContext);
    }
    return 0L;
  }
  
  public static String getString(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    String str1;
    try
    {
      String str2 = (String)MemoryCacheManager.get(paramString);
      str1 = str2;
      if (str2 != null) {
        return str1;
      }
      paramContext = PushPreferences.getString(paramContext, a(paramString), null);
      MemoryCacheManager.put(paramString, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "getString", paramContext);
      str1 = "";
    }
    paramContext = PushPreferences.getString(paramContext, a(paramString), null);
    return paramContext;
    return str1;
  }
  
  public static boolean putFloat(Context paramContext, String paramString, float paramFloat)
  {
    try
    {
      PushPreferences.putFloat(paramContext, a(paramString), paramFloat);
      return true;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "putFloat", paramContext);
    }
    return false;
  }
  
  public static boolean putInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      PushPreferences.putInt(paramContext, a(paramString), paramInt);
      return true;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "putInt", paramContext);
    }
    return false;
  }
  
  public static boolean putLong(Context paramContext, String paramString, long paramLong)
  {
    try
    {
      PushPreferences.putLong(paramContext, a(paramString), paramLong);
      return false;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Logger.e("PushMd5Pref", "putLong", paramContext);
      }
    }
  }
  
  public static boolean putString(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      String str = (String)MemoryCacheManager.get(paramString1);
      if ((str != null) && (paramString2 != null) && (str.equals(paramString2))) {
        return true;
      }
      MemoryCacheManager.put(paramString1, paramString2);
      PushPreferences.putString(paramContext, a(paramString1), paramString2);
      return true;
    }
    catch (Throwable paramContext)
    {
      Logger.e("PushMd5Pref", "putString", paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.PushMd5Pref
 * JD-Core Version:    0.7.0.1
 */