package com.tencent.beacon.c;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.base.util.c;
import com.tencent.qmsp.sdk.u.U;

public class a
{
  private static boolean a = false;
  private static String b = "load_so";
  private static String c = "load_so_version";
  private static String d = "beacon_so_beacon";
  
  private static int a(Context paramContext)
  {
    return b(paramContext).getInt(b, 0);
  }
  
  public static String a(Context paramContext, int paramInt1, Activity paramActivity, String paramString, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      String str;
      try
      {
        str = com.tencent.beacon.a.c.b.a();
        if (!c(paramContext).equals(str))
        {
          c.d("[audit] app update", new Object[0]);
          a(paramContext, str);
          a(paramContext, 0);
          c.a("[audit] last load so occur fetal error cnt: %s", new Object[] { Integer.valueOf(i) });
          if (i >= paramInt2)
          {
            d.b().a("502", "[audit] load so error count over max!");
            c.b("[audit] !!!!!!!!!!LOADERROR!!!!!!!!!! ", new Object[0]);
            paramActivity = "LOADERROR";
            if ((paramActivity == null) || (paramActivity.isEmpty())) {
              d.b().a("501", "[audit] audit run fail! result is empty!");
            }
            return paramActivity;
          }
        }
        else
        {
          i = a(paramContext);
          continue;
        }
      }
      finally {}
      try
      {
        if (!a)
        {
          a(paramContext, i + 1);
          c.d("[audit] load libBeacon.so success", new Object[0]);
          a = true;
        }
        str = U.a(paramContext, paramInt1, paramActivity, paramString);
        paramActivity = str;
      }
      catch (Throwable paramActivity)
      {
        a(paramContext, paramActivity);
        paramActivity = "NOLIB";
        continue;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        try
        {
          a = true;
          paramActivity = U.a(paramContext, paramInt1, paramActivity, paramString);
        }
        catch (Throwable paramActivity)
        {
          a(paramContext, paramActivity);
          paramActivity = "NOLIB";
        }
        continue;
      }
      a(paramContext, 0);
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    paramContext = b(paramContext).edit();
    if (com.tencent.beacon.base.util.b.a(paramContext)) {
      paramContext.putInt(b, paramInt).apply();
    }
  }
  
  private static void a(Context paramContext, String paramString)
  {
    paramContext = b(paramContext).edit();
    if (com.tencent.beacon.base.util.b.a(paramContext)) {
      paramContext.putString(c, paramString).apply();
    }
  }
  
  private static void a(Context paramContext, Throwable paramThrowable)
  {
    c.b("[audit] libBeacon.so load failed!", new Object[0]);
    c.a(paramThrowable);
    d.b().a("501", "[audit] libBeacon.so load failed!", paramThrowable);
  }
  
  private static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences(d, 0);
  }
  
  private static String c(Context paramContext)
  {
    return b(paramContext).getString(c, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.c.a
 * JD-Core Version:    0.7.0.1
 */