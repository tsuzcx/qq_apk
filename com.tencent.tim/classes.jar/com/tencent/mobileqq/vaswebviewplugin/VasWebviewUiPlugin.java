package com.tencent.mobileqq.vaswebviewplugin;

import acfp;
import afjy;
import aiiw;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import aqmq;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class VasWebviewUiPlugin
  extends VasBasePlugin
{
  private static final String TAG = "VasWebviewUiPlugin";
  protected QQBrowserActivity activity;
  protected boolean isHomePageWatingBind;
  
  public VasWebviewUiPlugin()
  {
    this.mPluginNameSpace = String.valueOf(getPluginBusiness());
  }
  
  protected void OnActivityCreate() {}
  
  void OnActivityDestroy()
  {
    if (aiiw.ckt) {
      aiiw.a(false, null, false);
    }
    if (aiiw.wakeLock != null) {
      aiiw.wakeLock = null;
    }
  }
  
  protected void OnActivityPause()
  {
    if (aiiw.ckt) {
      aiiw.a(false, null, true);
    }
  }
  
  void OnActivityResume()
  {
    if (aiiw.ckt) {
      aiiw.a(true, this.mRuntime.getActivity(), true);
    }
  }
  
  protected String decodeUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUiPlugin", 2, "decodeUrl:" + paramString);
    }
    String str1 = paramString.replace("[uin]", this.activity.getAppRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", "3.4.4.3058").replace("[sid]", "").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
    Intent localIntent = this.activity.getIntent();
    String str2 = localIntent.getStringExtra("updateTime");
    paramString = str1;
    if (str2 != null)
    {
      paramString = str1;
      if (str2.length() > 0) {
        paramString = str1.replace("[updateTime]", str2);
      }
    }
    String str3 = localIntent.getStringExtra("adTag");
    str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      if (str2.length() > 0) {
        str1 = paramString.replace("[adTag]", str3);
      }
    }
    return str1.replace("[updateFlag]", Boolean.valueOf(localIntent.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + localIntent.getIntExtra("updateId", 0)).replace("[density]", ThemeUtil.getThemeDensity(this.activity));
  }
  
  void doAfterFinish() {}
  
  void doBeforeFinish() {}
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.activity == null) || ((this.business & getPluginBusiness()) == 0L)) {
      return false;
    }
    String str = "Web_uiplugin_step_" + paramLong;
    aqmq.track(null, str);
    if (paramLong == 1L) {}
    for (;;)
    {
      boolean bool;
      try
      {
        OnActivityCreate();
        bool = excuteEvent(paramString, paramLong, paramMap);
        return bool;
        if (paramLong == 8589934596L)
        {
          OnActivityDestroy();
          continue;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
        if (paramLong == 2L)
        {
          OnActivityResume();
          continue;
        }
      }
      finally
      {
        aqmq.track(str, null);
      }
      if (paramLong == 8589934597L)
      {
        OnActivityPause();
      }
      else if (paramLong != 8589934595L)
      {
        if (paramLong == 8589934600L)
        {
          bool = onActivityResult(((Integer)paramMap.get("requestCode")).intValue(), ((Integer)paramMap.get("resultCode")).intValue(), (Intent)paramMap.get("data"));
          aqmq.track(str, null);
          return bool;
        }
        if (paramLong == 8589934598L) {
          doBeforeFinish();
        } else if (paramLong == 8589934599L) {
          doAfterFinish();
        }
      }
    }
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.getActivity() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.getActivity());
    }
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.business != 0L) && ((getPluginBusiness() & this.business) == 0L)) {}
    do
    {
      return;
      if (afjy.a().ajq()) {
        break;
      }
    } while (!paramBoolean2);
    Toast.makeText(BaseApplication.getContext(), acfp.m(2131716322), 0).show();
    return;
    if (paramBoolean1)
    {
      afjy.a().cr(paramBundle);
      return;
    }
    afjy.a().cq(paramBundle);
  }
  
  protected void webviewLoadUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUiPlugin", 2, "now try open url: " + paramString);
    }
    if (this.mRuntime.getWebView() != null)
    {
      this.mRuntime.getWebView().loadUrl(paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new VasWebviewUiPlugin.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
 * JD-Core Version:    0.7.0.1
 */