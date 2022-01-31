package com.tencent.open.appcenter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.jsp.AppShareJavaScript;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.AppClient.MsgCenterListener;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.InterfaceRegisterUtils;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DBInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.appcommon.js.ImageCacheInterface;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import hod;
import hoe;
import hof;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class QZoneAppCenterActivity
  extends AppViewBaseActivity
{
  public static final String c;
  protected static String d = "file:///android_asset/Page/system/qapp_social_apps.html";
  protected FrameLayout a;
  protected BaseJsCallBack a;
  public WebView a;
  public String e = "";
  public String f;
  protected String g;
  
  static
  {
    jdField_c_of_type_JavaLangString = QZoneAppCenterActivity.class.getSimpleName();
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    InterfaceRegisterUtils.a(paramWebView, paramString);
    g();
  }
  
  public void a(String paramString)
  {
    if (AppClient.a == null) {
      return;
    }
    AppClient.MsgCenterListener localMsgCenterListener = (AppClient.MsgCenterListener)AppClient.a.get();
    if (localMsgCenterListener != null)
    {
      if (!paramString.equals("0")) {
        break label42;
      }
      localMsgCenterListener.a(true);
    }
    for (;;)
    {
      AppClient.a = null;
      return;
      label42:
      localMsgCenterListener.a(false);
    }
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return true;
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(4);
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack != null) {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.timePointParams = e();
    }
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    try
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected boolean b(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      this.g = paramIntent.getString("channelId");
      if ((paramIntent.containsKey("sendTime")) && (paramIntent.containsKey("autoType")))
      {
        this.e = paramIntent.getString("sendTime");
        this.f = String.valueOf(paramIntent.getInt("autoType"));
        LogUtility.c(jdField_c_of_type_JavaLangString, "getParamsFromIntent  | " + this.e + " | " + this.f);
        CommonDataAdapter.a().b(paramIntent.getLong("uinRestore", 0L));
        return true;
      }
    }
    return false;
  }
  
  public String c()
  {
    return "&push=" + this.e + "&auto=" + this.f + "&channelId=" + this.g + "&platform=" + CommonDataAdapter.a().g();
  }
  
  public String d()
  {
    return c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_l_of_type_JavaLangString = getClass().getSimpleName();
    i();
    j();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      InterfaceRegisterUtils.a(this.jdField_a_of_type_ComTencentSmttSdkWebView);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearCache(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
      this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:QzoneApp.fire('resume');void(0);");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
      {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.setParams(c());
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(d);
        q();
        continue;
        if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
        {
          this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.setParams(c());
          File localFile = new File(Common.c());
          if ((Common.a()) && (localFile.exists()))
          {
            LogUtility.c(jdField_c_of_type_JavaLangString, "load from sdcard");
            this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("file:///" + Common.c());
          }
          else
          {
            LogUtility.c(jdField_c_of_type_JavaLangString, "load from asset");
            this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(d);
          }
        }
      }
    }
  }
  
  protected void i()
  {
    setContentView(2130903330);
    x();
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131560958);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new hod(this));
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("应用消息");
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new hoe(this));
  }
  
  protected void j()
  {
    k();
    b(getIntent());
    a(Common.e(), "file:///" + Common.c(), "");
  }
  
  @TargetApi(11)
  protected void k()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(this);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocus();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocusFromTouch();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(this.jdField_a_of_type_Hol);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setOnLongClickListener(new hof(this));
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    ((WebSettings)localObject).setAllowFileAccess(true);
    ((WebSettings)localObject).setJavaScriptCanOpenWindowsAutomatically(true);
    ((WebSettings)localObject).setLoadsImagesAutomatically(true);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setPluginsEnabled(true);
    ((WebSettings)localObject).setCacheMode(-1);
    ((WebSettings)localObject).setBuiltInZoomControls(false);
    ((WebSettings)localObject).setUserAgent(((WebSettings)localObject).getUserAgentString() + " ApiLevel/" + Build.VERSION.SDK_INT + " QQ/" + CommonDataAdapter.a().b() + " Agent/" + CommonDataAdapter.a().d());
    ((WebSettings)localObject).setCacheMode(1);
    if (Build.VERSION.SDK_INT > 7)
    {
      ((WebSettings)localObject).setPluginState(WebSettings.PluginState.ON);
      ((WebSettings)localObject).setDatabaseEnabled(true);
      ((WebSettings)localObject).setDatabasePath(getApplicationContext().getDir("storage", 2).getPath());
      ((WebSettings)localObject).setDomStorageEnabled(true);
      ((WebSettings)localObject).setAppCacheEnabled(true);
      ((WebSettings)localObject).setAppCachePath(getApplicationContext().getDir("cache", 2).getPath());
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(this.jdField_a_of_type_Hok);
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack = new BaseJsCallBack(this);
    DownloadInterface localDownloadInterface = new DownloadInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    DBInterface localDBInterface = new DBInterface(this, "applist.db", 2);
    ImageCacheInterface localImageCacheInterface = new ImageCacheInterface(this.jdField_a_of_type_ComTencentSmttSdkWebView);
    AppInterface localAppInterface = new AppInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    HttpInterface localHttpInterface = new HttpInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    ((List)localObject).add(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack);
    ((List)localObject).add(localDownloadInterface);
    ((List)localObject).add(localDBInterface);
    ((List)localObject).add(localImageCacheInterface);
    ((List)localObject).add(localHttpInterface);
    ((List)localObject).add(localAppInterface);
    if (new File(Common.c()).exists()) {
      InterfaceRegisterUtils.a((List)localObject, this.jdField_a_of_type_ComTencentSmttSdkWebView, "file:///" + Common.c(), this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(new AppShareJavaScript(this), "QQApi");
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232111));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentSmttSdkWebView);
      return;
      InterfaceRegisterUtils.a((List)localObject, this.jdField_a_of_type_ComTencentSmttSdkWebView, d, this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge);
    }
  }
  
  protected void l()
  {
    String str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
    LogUtility.c(jdField_c_of_type_JavaLangString, "reloadView;currentUrl=" + str + "; isReloadView()=" + c());
    if (c())
    {
      b(false);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearCache(true);
    }
    a(Common.e(), str, null);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    getIntent().putExtra("isReported", false);
    if (b(paramIntent)) {
      l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcenter.QZoneAppCenterActivity
 * JD-Core Version:    0.7.0.1
 */