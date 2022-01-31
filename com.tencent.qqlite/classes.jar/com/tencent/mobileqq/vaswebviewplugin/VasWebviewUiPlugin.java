package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class VasWebviewUiPlugin
  extends VasBasePlugin
{
  private static final String TAG = "VasWebviewUiPlugin";
  protected QQBrowserActivity activity;
  protected boolean isHomePageWatingBind = false;
  
  void OnActivityCreate() {}
  
  void OnActivityDestroy()
  {
    if (DeviceApiPlugin.jdField_a_of_type_Boolean) {
      DeviceApiPlugin.a(false, null, false);
    }
    if (DeviceApiPlugin.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
      DeviceApiPlugin.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
  }
  
  void OnActivityPause()
  {
    if (DeviceApiPlugin.jdField_a_of_type_Boolean) {
      DeviceApiPlugin.a(false, null, true);
    }
  }
  
  void OnActivityResume()
  {
    if (DeviceApiPlugin.jdField_a_of_type_Boolean) {
      DeviceApiPlugin.a(true, this.mRuntime.a(), true);
    }
  }
  
  protected String decodeUrl(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUiPlugin", 2, "decodeUrl:" + paramString);
    }
    String str1 = paramString.replace("[uin]", this.activity.getAppRuntime().getAccount()).replace("[client]", "androidQQ");
    paramString = str1;
    if (paramBoolean) {
      paramString = str1.replace("[version]", "5.3.1.544");
    }
    str1 = paramString.replace("[version]", "3.3.0.544").replace("[sid]", "").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
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
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    return false;
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if ((this.activity == null) || ((this.business & getPluginBusiness()) == 0L)) {
      return false;
    }
    String str = "Web_uiplugin_step_" + paramInt;
    StartupTracker.a(null, str);
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        bool = excuteEvent(paramString, paramInt, paramMap);
        return bool;
        OnActivityCreate();
        continue;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
        OnActivityDestroy();
        continue;
      }
      finally
      {
        StartupTracker.a(str, null);
      }
      OnActivityResume();
      continue;
      OnActivityPause();
      continue;
      boolean bool = onActivityResult(((Integer)paramMap.get("requestCode")).intValue(), ((Integer)paramMap.get("resultCode")).intValue(), (Intent)paramMap.get("data"));
      StartupTracker.a(str, null);
      return bool;
      doBeforeFinish();
      continue;
      doAfterFinish();
    }
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() instanceof QQBrowserActivity)) {
      this.activity = ((QQBrowserActivity)this.mRuntime.a());
    }
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.business != 0L) && ((getPluginBusiness() & this.business) == 0L)) {}
    do
    {
      return;
      if (WebIPCOperator.getInstance().isServiceClientBinded()) {
        break;
      }
    } while (!paramBoolean2);
    Toast.makeText(this.mRuntime.a(), "正在初始化服务，请稍候尝试", 0).show();
    return;
    if (paramBoolean1)
    {
      WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(paramBundle);
      return;
    }
    WebIPCOperator.getInstance().sendServiceIpcReq(paramBundle);
  }
  
  protected void webviewLoadUrl(String paramString)
  {
    this.mRuntime.a().loadUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
 * JD-Core Version:    0.7.0.1
 */