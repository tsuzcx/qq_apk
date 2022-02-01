package com.tencent.android.tpush.service.util;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Md5;

public class d
{
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = e.a(paramContext, a(paramString), null);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ServicePushInfoMd5Pref", "getString", paramContext);
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    return Md5.md5(paramString);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      e.b(paramContext, a(paramString1), paramString2);
      return true;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ServicePushInfoMd5Pref", "putString", paramContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.d
 * JD-Core Version:    0.7.0.1
 */