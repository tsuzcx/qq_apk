package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import buw;
import bux;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class QzonePlugin
  extends WebViewPlugin
{
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  private String c;
  
  private void a()
  {
    new Handler().post(new bux(this));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (this.c == null)) {}
    while ((this.c != null) && (this.b != null) && (this.b.equals(this.c))) {
      return;
    }
    new Handler().post(new buw(this, paramArrayOfByte));
    this.b = this.c;
  }
  
  public boolean a(String paramString)
  {
    Intent localIntent = this.mRuntime.a().getIntent();
    Bundle localBundle = localIntent.getExtras();
    byte[] arrayOfByte = localBundle.getByteArray("post_data");
    boolean bool = localBundle.getBoolean("UrlorData", true);
    this.c = paramString;
    if (localBundle.getString("originalURL") != null) {
      this.c = localBundle.getString("originalURL");
    }
    if (arrayOfByte == null)
    {
      if (bool) {
        return false;
      }
      a();
      return true;
    }
    a(arrayOfByte);
    localIntent.removeExtra("post_data");
    return true;
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if ((paramInt == 12) && (this.jdField_a_of_type_JavaLangString != null) && (!"".equals(this.jdField_a_of_type_JavaLangString)))
    {
      paramString = new Intent();
      paramString.setAction(this.jdField_a_of_type_JavaLangString);
      paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", this.jdField_a_of_type_Boolean);
      if ("com.tencent.mobileqq.opencenter.vipInfo".equals(this.jdField_a_of_type_JavaLangString)) {
        paramString.putExtra("key_pay_action_result", ((QQBrowserActivity)this.mRuntime.a()).c());
      }
      this.mRuntime.a().sendBroadcast(paramString);
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase("pay://requestQzoneOpenVip")))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    if ((this.mRuntime.a().getIntent().getBooleanExtra("fromQZone", false)) && ((paramString2.equals("http")) || (paramString2.equals("https")))) {
      return a(paramString1);
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    if (this.mRuntime.a().getIntent() != null) {
      this.jdField_a_of_type_JavaLangString = this.mRuntime.a().getIntent().getStringExtra("broadcastAction");
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin
 * JD-Core Version:    0.7.0.1
 */