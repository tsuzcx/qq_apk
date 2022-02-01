package com.tencent.android.tpush.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.d.a.b;
import com.tencent.android.tpush.d.a.e;
import com.tencent.android.tpush.d.a.f;
import com.tencent.android.tpush.d.a.g;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;

public class d
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  public static String f = "";
  public static Boolean g = Boolean.valueOf(false);
  public static String h = "";
  private static volatile d i = null;
  private static volatile c j = null;
  private Boolean k;
  private Context l = null;
  private int m = -1;
  
  private d(Context paramContext)
  {
    this.l = paramContext;
    if (j == null)
    {
      if ((h.a(paramContext).c()) && (XGPushConfig.isNotTryFcm(paramContext)))
      {
        TLogger.e("OtherPushManager", "USE FCM");
        XGPushConfig.setNotTryFcm(paramContext, false);
        j = new com.tencent.android.tpush.d.a.a();
      }
    }
    else {
      return;
    }
    paramContext = g();
    if (com.tencent.android.tpush.f.a.b(this.l))
    {
      TLogger.ii("OtherPushManager", "USE XgSys");
      j = new g(this.l);
      return;
    }
    if ((ChannelUtils.isBrandXiaoMi()) || (ChannelUtils.isBrandBlackShark()))
    {
      TLogger.ii("OtherPushManager", "USE xiaomi");
      j = new com.tencent.android.tpush.d.a.d();
      return;
    }
    if ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor()))
    {
      TLogger.ii("OtherPushManager", "USE huawei");
      j = new b();
      return;
    }
    if (ChannelUtils.isBrandMeiZu())
    {
      TLogger.ii("OtherPushManager", "USE meizu");
      j = new com.tencent.android.tpush.d.a.c();
      return;
    }
    if (("oppo".equals(paramContext)) || ("oneplus".equals(paramContext)) || ("realme".equals(paramContext)))
    {
      TLogger.ii("OtherPushManager", "USE oppo");
      j = new e();
      return;
    }
    if ("vivo".equals(paramContext))
    {
      TLogger.ii("OtherPushManager", "USE vivo");
      j = new f();
      return;
    }
    TLogger.ii("OtherPushManager", "deviceType: " + paramContext);
  }
  
  public static d a(Context paramContext)
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new d(paramContext);
      }
      return i;
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a = paramString;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      str1 = SharePrefsUtil.getString(paramContext, "other_push_error_code", "");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          String str1;
          if (paramString2.equals(str1)) {
            return;
          }
          SharePrefsUtil.setString(paramContext, "other_push_error_code", paramString2);
          return;
        }
        catch (Throwable paramContext)
        {
          String str2;
          TLogger.w(paramString1, "save returnMsg error: " + paramContext.getMessage());
        }
        localThrowable = localThrowable;
        TLogger.dd(paramString1, "read returnMsg from sp error: " + localThrowable.getMessage());
        str2 = "";
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    g = Boolean.valueOf(paramBoolean);
  }
  
  public static void a(d paramd, c paramc)
  {
    i = paramd;
    j = paramc;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    b = paramString;
  }
  
  public static void c(Context paramContext, String paramString)
  {
    c = paramString;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    d = paramString;
  }
  
  public static void e(Context paramContext, String paramString)
  {
    e = paramString;
  }
  
  public static void f(Context paramContext, String paramString)
  {
    f = paramString;
  }
  
  public static String g()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = str2.trim().toLowerCase();
    }
    return str1;
  }
  
  public static String h()
  {
    return TGlobalHelper.getDM(null);
  }
  
  public boolean a()
  {
    if ((j == null) || (this.l == null)) {
      return false;
    }
    return j.d(this.l);
  }
  
  public boolean b()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (j != null)
    {
      if (this.l != null) {
        break label23;
      }
      bool2 = bool1;
    }
    label23:
    do
    {
      return bool2;
      bool1 = bool3;
      if (j.e(this.l) == 8) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!bool1);
    TLogger.ii("OtherPushManager", "UseXgSysDevice!");
    return bool1;
  }
  
  public void c()
  {
    if ((j != null) && (this.l != null) && (j.d(this.l))) {
      j.a(this.l);
    }
  }
  
  public void d()
  {
    if ((j != null) && (this.l != null) && (j.d(this.l))) {
      j.b(this.l);
    }
  }
  
  public int e()
  {
    if ((j != null) && (this.l != null) && (j.d(this.l))) {
      return j.e(this.l);
    }
    return -1;
  }
  
  public String f()
  {
    if ((j != null) && (this.l != null) && (j.d(this.l))) {
      return j.c(this.l);
    }
    return null;
  }
  
  public String i()
  {
    if (j != null) {
      return j.a();
    }
    return null;
  }
  
  public boolean j()
  {
    if ((j != null) && (this.l != null))
    {
      if (this.k == null) {
        this.k = Boolean.valueOf(j.d(this.l));
      }
      return this.k.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.d
 * JD-Core Version:    0.7.0.1
 */