package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hcb;
import hcc;

public class PerformanceReportUtils
{
  public static final int a = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static final String a = "actFPSRecent";
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { l, m, n, o };
  public static final int b = 1;
  private static long b = 0L;
  public static final String b = "actFPSFriend";
  public static final int c = 3000;
  private static long c = 0L;
  public static final String c = "actFPSAIO";
  public static final int d = 3;
  private static long d = 0L;
  public static final String d = "actFPSFriendSystemMsg";
  public static final String e = "actFPSFriendSystemMsg";
  private static final String f = PerformanceReportUtils.class.getSimpleName();
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static final String k = "1";
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static final String q = "param_FPS";
  
  static
  {
    jdField_a_of_type_Long = 14400000L;
    g = "uiswitchinterval";
    h = "uiswitchflag";
    i = "fpsinterval";
    j = "fpsflag";
    l = "actUISwitchC2C";
    m = "actUISwitchGroup";
    n = "actUISwitchDiscuss";
    o = "actUISwitchQzone";
    p = "";
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    new hcb(paramInt, paramLong, paramString).execute(new Void[0]);
  }
  
  public static void a(String paramString, int paramInt)
  {
    new hcc(paramString, paramInt).execute(new Void[0]);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(f, 4, "reportFPS saveCompleteTime ：tag:" + paramString + ",time:" + paramLong);
    }
    if ("actFPSAIO".equals(paramString)) {
      b = paramLong;
    }
    do
    {
      return;
      if ("actFPSRecent".equals(paramString))
      {
        c = paramLong;
        return;
      }
    } while (!"actFPSFriend".equals(paramString));
    d = paramLong;
  }
  
  private static SharedPreferences b()
  {
    Context localContext = BaseApplication.getContext();
    String str = f;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0) {
      return localContext.getSharedPreferences(str, i1);
    }
  }
  
  private static boolean b(String paramString)
  {
    long l1;
    if ("actFPSAIO".equals(paramString)) {
      l1 = b;
    }
    for (;;)
    {
      if (l1 == 0L) {}
      while ((float)(SystemClock.uptimeMillis() - l1) / 1000.0F >= 10.0F)
      {
        return false;
        if ("actFPSRecent".equals(paramString))
        {
          l1 = c;
          break;
        }
        if (!"actFPSFriend".equals(paramString)) {
          break label70;
        }
        l1 = d;
        break;
      }
      return true;
      label70:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PerformanceReportUtils
 * JD-Core Version:    0.7.0.1
 */