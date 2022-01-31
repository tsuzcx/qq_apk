package com.tencent.open.appcommon;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.AppBaseActivity;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.smtt.sdk.WebView;
import hoj;
import hok;
import hol;
import java.io.File;

public abstract class AppViewBaseActivity
  extends AppBaseActivity
  implements Handler.Callback
{
  protected static boolean d = false;
  public static final int e = 1;
  protected static boolean e = false;
  public static final int f = 2;
  protected static boolean f = false;
  public static final int g = 16777216;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final String k = "AppViewBaseActivity";
  public static final int l = 7;
  public static final int m = 8;
  protected static final String m = "file:///android_asset/Page/system/";
  public static final int n = 9;
  protected static final String n = "Meizu_M040";
  public static final int o = 13;
  public static final int p = 14;
  public static final int q = 102;
  public static final int r = 103;
  public static final int s = 104;
  public OpenJsBridge a;
  protected hok a;
  protected hol a;
  public long b;
  public Handler b;
  public long c;
  protected Handler c;
  public long d;
  protected long e;
  public long f;
  public long g;
  protected boolean g;
  public boolean h = false;
  public String l;
  protected String o = "";
  protected String p = "";
  protected String q;
  
  static
  {
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = false;
  }
  
  public AppViewBaseActivity()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidOsHandler = new AppViewBaseActivity.ExtendHandler(this);
    this.jdField_a_of_type_Hol = new hol(this, this);
    this.jdField_a_of_type_Hok = new hok(this, this);
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_d_of_type_Boolean = paramBoolean;
    if (jdField_d_of_type_Boolean)
    {
      Common.b(true);
      return;
    }
    Common.b(false);
  }
  
  public static boolean c()
  {
    return jdField_d_of_type_Boolean;
  }
  
  public static boolean f()
  {
    return jdField_e_of_type_Boolean;
  }
  
  public Handler a()
  {
    return this.jdField_b_of_type_AndroidOsHandler;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    LogUtility.b("opensdk", ">>start verify html>>");
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    ThreadManager.b(new hoj(this, paramObject, paramString2, paramString1));
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    x();
    if (paramBundle == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232129);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131232128);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    if (paramBundle.getString("visible").equals("1"))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (!paramBundle.getString("iconType").equals("0")) {
        break label114;
      }
    }
    label114:
    for (int i1 = 2130838201;; i1 = 2130838202)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i1);
      this.p = paramBundle.getString("callBackKey");
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
    }
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    h();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public String d()
  {
    return "";
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LogUtility.b("TIMESTAMP", "PagePerformance: AppViewBaseActivity oncreate() started!");
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    try
    {
      if ((Build.VERSION.SDK_INT >= 11) && (!"Meizu_M040".equals(paramBundle))) {
        getWindow().addFlags(16777216);
      }
      this.l = getClass().getSimpleName();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      LogUtility.b("LaunchTime", "APP_" + this.l + "_onCreate：" + this.jdField_b_of_type_Long);
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this);
      p();
      if (!jdField_f_of_type_Boolean) {
        i2 = Common.a();
      }
    }
    catch (Exception paramBundle)
    {
      try
      {
        int i2;
        i1 = CommonDataAdapter.a().a().getPackageManager().getPackageInfo(CommonDataAdapter.a().a().getPackageName(), 0).versionCode;
        paramBundle = Common.o();
        String str = CommonDataAdapter.a().d();
        LogUtility.c("AppViewBaseActivity", "checkIsFirstEnter appTabVersionInSD=" + i2 + " qzoneVersion=" + i1 + " agentVersionRecord=" + paramBundle + " agentVersion=" + str);
        if ((i2 != i1) || (!paramBundle.equals(str)))
        {
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          Common.a(i1);
          Common.c(str);
          this.h = true;
          jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge = new OpenJsBridge();
          return true;
          paramBundle = paramBundle;
          LogUtility.c("AppViewBaseActivity", "FLAG_HARDWARE_ACCELERATED>>>", paramBundle);
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          int i1 = 0;
          continue;
          if (Common.b())
          {
            LogUtility.c("AppViewBaseActivity", "checkIsFirstEnter clearcache");
            jdField_d_of_type_Boolean = true;
            Common.b(false);
          }
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_c_of_type_AndroidOsHandler != null)
    {
      this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_c_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge != null)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(null);
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Hol.a();
    this.jdField_a_of_type_Hok.a();
  }
  
  public void doOnPause()
  {
    jdField_e_of_type_Boolean = false;
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    MyAppApi.a().a(this);
    CallBackEvent.a().a(true);
    TaskThread.a().a(this.jdField_c_of_type_AndroidOsHandler);
    if (c())
    {
      LogUtility.c("AppViewBaseActivity", "do reload view");
      l();
      b(false);
    }
    jdField_e_of_type_Boolean = true;
    LogUtility.b("TIMESTAMP", "PagePerformance: AppViewBaseActivity onresume() finished!");
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_e_of_type_Long != 0L) {
      localStringBuilder.append("&firstEnter=" + this.jdField_e_of_type_Long);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      localStringBuilder.append("&onCreate=" + this.jdField_b_of_type_Long);
    }
    if (this.jdField_c_of_type_Long != 0L) {
      localStringBuilder.append("&onPageStart=" + this.jdField_c_of_type_Long);
    }
    if (this.jdField_d_of_type_Long != 0L) {
      localStringBuilder.append("&onPageFinish=" + this.jdField_d_of_type_Long);
    }
    if ((this.jdField_f_of_type_Long != 0L) && (this.jdField_g_of_type_Long != 0L)) {
      localStringBuilder.append("&startVerify=" + this.jdField_f_of_type_Long + "&endVerify=" + this.jdField_g_of_type_Long);
    }
    return localStringBuilder.toString();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    default: 
      return false;
    case 1: 
      LogUtility.c("AppViewBaseActivity", "receive md5");
      TaskThread.a().a(1);
      return true;
    case 2: 
      TaskThread.a().a(2);
      TaskThread.a().a(1);
      return true;
    case 6: 
      TaskThread.a().a(6);
      return true;
    case 3: 
      l();
      return true;
    case 4: 
      h();
      return true;
    }
    LogUtility.c("AppViewBaseActivity", "receive UPDATED_SYSTEM_FILE msg");
    b(true);
    return true;
  }
  
  protected abstract void l();
  
  protected void p()
  {
    TaskThread.a().a(this.jdField_c_of_type_AndroidOsHandler);
  }
  
  public void q()
  {
    if (!new File(Common.e()).exists())
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
  }
  
  public boolean showPreview()
  {
    f(2130903101);
    ((TextView)findViewById(2131231196)).setText(2131560530);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.AppViewBaseActivity
 * JD-Core Version:    0.7.0.1
 */