package com.tencent.tpns.baseapi.base;

import android.content.Context;
import com.tencent.tpns.baseapi.crosssp.a;
import com.tencent.tpns.baseapi.crosssp.a.a;

public class PushPreferences
{
  private static a a = null;
  
  static a a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = a.a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext).a(paramString, paramBoolean);
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    return a(paramContext).a(paramString, paramFloat);
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext).a(paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).a(paramString, paramLong);
  }
  
  public static Object getObject(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).b(paramString1, paramString2);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).a(paramString1, paramString2);
  }
  
  public static void putBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = a(paramContext).a();
    paramContext.a(paramString, paramBoolean);
    paramContext.b();
  }
  
  public static void putFloat(Context paramContext, String paramString, float paramFloat)
  {
    paramContext = a(paramContext).a();
    paramContext.a(paramString, paramFloat);
    paramContext.b();
  }
  
  public static void putInt(Context paramContext, String paramString, int paramInt)
  {
    paramContext = a(paramContext).a();
    paramContext.a(paramString, paramInt);
    paramContext.b();
  }
  
  public static void putLong(Context paramContext, String paramString, long paramLong)
  {
    paramContext = a(paramContext).a();
    paramContext.a(paramString, paramLong);
    paramContext.b();
  }
  
  public static void putString(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext).a();
    paramContext.a(paramString1, paramString2);
    paramContext.b();
  }
  
  public static void remove(Context paramContext, String paramString)
  {
    if (a(paramContext) != null)
    {
      paramContext = a(paramContext).a();
      paramContext.a(paramString);
      paramContext.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.PushPreferences
 * JD-Core Version:    0.7.0.1
 */