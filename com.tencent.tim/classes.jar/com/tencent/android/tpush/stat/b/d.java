package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;

public class d
{
  private static SharedPreferences a = null;
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    paramString = b.a(paramContext, "tpush_" + paramString);
    return a(paramContext).getInt(paramString, paramInt);
  }
  
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    paramString = b.a(paramContext, "tpush_" + paramString);
    return a(paramContext).getLong(paramString, paramLong);
  }
  
  static SharedPreferences a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 11) {
          continue;
        }
        a = paramContext.getSharedPreferences(".tpush_mta", 4);
        if (a == null) {
          a = PreferenceManager.getDefaultSharedPreferences(paramContext);
        }
        paramContext = a;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          a = PreferenceManager.getDefaultSharedPreferences(paramContext);
          paramContext = a;
        }
        catch (Throwable paramContext)
        {
          paramContext = null;
        }
        continue;
      }
      finally {}
      return paramContext;
      a = paramContext.getSharedPreferences(".tpush_mta", 0);
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = b.a(paramContext, "tpush_" + paramString1);
    return a(paramContext).getString(paramString1, paramString2);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramString = b.a(paramContext, "tpush_" + paramString);
    paramContext = a(paramContext).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramString = b.a(paramContext, "tpush_" + paramString);
    paramContext = a(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = b.a(paramContext, "tpush_" + paramString1);
    paramContext = a(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b.d
 * JD-Core Version:    0.7.0.1
 */