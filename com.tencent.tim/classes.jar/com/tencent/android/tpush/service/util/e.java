package com.tencent.android.tpush.service.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class e
{
  private static SharedPreferences a = null;
  
  static SharedPreferences a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = paramContext.getSharedPreferences(".tpns.vip.service.xml", 0);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!a(paramContext).contains(paramString1)) {
      return paramString2;
    }
    return a(paramContext).getString(paramString1, paramString2);
  }
  
  @SuppressLint({"NewApi"})
  private static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.e
 * JD-Core Version:    0.7.0.1
 */