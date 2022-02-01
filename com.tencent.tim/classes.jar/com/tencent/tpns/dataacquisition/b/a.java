package com.tencent.tpns.dataacquisition.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public class a
{
  private static boolean a = true;
  
  public static void a(Object paramObject)
  {
    if (a) {
      Log.w("TPush-DataAcq", "" + paramObject);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    Log.e("TPush-DataAcq", "" + paramString, paramThrowable);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      a("checkPermission error", paramContext);
    }
    return false;
  }
  
  public static void b(Object paramObject)
  {
    Log.e("TPush-DataAcq", "" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.dataacquisition.b.a
 * JD-Core Version:    0.7.0.1
 */