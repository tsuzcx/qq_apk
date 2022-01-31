package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import etx;
import ety;

public class PerformanceReportUtils
{
  public static final int a = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static final String a = "actFPSRecent";
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { l, m, n, o, p, q, r, s };
  public static final int b = 1;
  private static long b = 0L;
  public static final String b = "actFPSFriend";
  public static final int c = 3000;
  private static long c = 0L;
  public static final String c = "actFPSAIO";
  public static final int d = 3;
  private static long d = 0L;
  public static final String d = "actFPSFriendSystemMsg";
  public static final int e = 4;
  public static final String e = "actFPSFriendSystemMsg";
  public static final int f = 5;
  private static final String f = PerformanceReportUtils.class.getSimpleName();
  public static final int g = 6;
  private static String g;
  public static final int h = 7;
  private static String h;
  private static String i;
  private static String j;
  private static final String k = "1";
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static String t;
  private static final String u = "param_FPS";
  private static final String v = "aioBusiness";
  
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
    p = "actUISwitchUserAlbum";
    q = "actUISwitchQunAlbum";
    r = "actUISwitchUserHome";
    s = "actUISwitchShareAlbum";
    t = "";
  }
  
  public static String a()
  {
    long l1 = 0L;
    if (FontManager.d) {
      l1 = 0L | 0x200;
    }
    long l2 = l1;
    if (BubbleManager.a) {
      l2 = l1 | 0x100;
    }
    return String.valueOf(l2);
  }
  
  public static void a()
  {
    FontManager.d = false;
    BubbleManager.a = false;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    new etx(paramInt, paramLong, paramString).execute(new Void[0]);
  }
  
  public static void a(Intent paramIntent, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramIntent.getLongExtra("key_time_record", -1L);
    if (l2 != -1L)
    {
      paramIntent.removeExtra("key_time_record");
      a(BaseApplicationImpl.getContext(), paramString, paramInt, l1 - l2);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    new ety(paramString1, paramInt, paramString2).execute(new Void[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PerformanceReportUtils
 * JD-Core Version:    0.7.0.1
 */