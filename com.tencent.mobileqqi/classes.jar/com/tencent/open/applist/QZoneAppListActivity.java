package com.tencent.open.applist;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.jsp.AppShareJavaScript;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.InterfaceRegisterUtils;
import com.tencent.open.appcommon.TaskThread;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DBInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.appcommon.js.ImageCacheInterface;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCacheService;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import hle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QZoneAppListActivity
  extends AppViewBaseActivity
{
  protected static final String c = "QZoneAppListActivity";
  protected static String d = "file:///android_asset/Page/system/qapp_center_index.htm";
  protected FrameLayout a;
  protected BaseJsCallBack a;
  public WebView a;
  protected List a;
  protected boolean a;
  protected View c;
  
  public QZoneAppListActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 500L);
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    InterfaceRegisterUtils.a(paramWebView, paramString);
    g();
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new hle(this));
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 500L);
    if (this.h)
    {
      this.h = false;
      TaskThread.a().a(14);
    }
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
  
  public String d()
  {
    return "";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    LogUtility.b("TIMESTAMP", "PagePerformance: appstore indexpage oncreate()!");
    Common.a();
    super.doOnCreate(paramBundle);
    this.jdField_l_of_type_JavaLangString = getClass().getSimpleName();
    j();
    if (!this.h) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    for (;;)
    {
      i();
      return true;
      LogUtility.b("QZoneAppListActivity", "..first login,we will check md5 after loadUrl ");
    }
  }
  
  public void doOnDestroy()
  {
    HttpCacheService.a().b();
    TaskThread.a().b();
    JsCallbackManager.a().a();
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      InterfaceRegisterUtils.a(this.jdField_a_of_type_ComTencentSmttSdkWebView);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearCache(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
      this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    InterfaceRegisterUtils.a();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:QzoneApp.fire('pause');void(0);");
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:QzoneApp.fire('resume');void(0);");
    }
    for (;;)
    {
      LogUtility.b("TIMESTAMP", "PagePerformance: appstore indexpage onresume finish!");
      return;
      this.jdField_a_of_type_Boolean = false;
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
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        continue;
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          continue;
          LogUtility.b("opensdk", ">>verify load url=" + d);
          if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
          {
            this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(d);
            q();
            continue;
            if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
              if (this.h)
              {
                this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(d);
                LogUtility.c("QZoneAppListActivity", "first enter load webview from asset " + d);
              }
              else
              {
                File localFile = new File(Common.d());
                LogUtility.c("QZoneAppListActivity", "load check>>" + localFile.getAbsolutePath());
                if ((Common.a()) && (localFile.exists()))
                {
                  LogUtility.c("QZoneAppListActivity", "load webview from sd " + localFile.getAbsolutePath());
                  this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("file:///" + Common.d());
                }
                else
                {
                  LogUtility.c("QZoneAppListActivity", "load webview from asset " + d);
                  this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(d);
                  continue;
                  if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
                    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(d);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void i()
  {
    k();
    if (this.h)
    {
      a(Common.e(), d, null);
      return;
    }
    a(Common.e(), "file:///" + Common.d(), "");
  }
  
  protected void j()
  {
    setContentView(2130903332);
    x();
    e();
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("应用宝");
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131232116);
  }
  
  @TargetApi(11)
  protected void k()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(getApplicationContext());
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocus();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.requestFocusFromTouch();
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(this.jdField_a_of_type_Hkh);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebChromeClient(this.jdField_a_of_type_Hkg);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.setOnCreateContextMenuListener(null);
    this.jdField_a_of_type_ComTencentSmttSdkWebView.getView().setOnLongClickListener(null);
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings();
    ((WebSettings)localObject).setAllowFileAccess(true);
    ((WebSettings)localObject).setJavaScriptCanOpenWindowsAutomatically(true);
    ((WebSettings)localObject).setLoadsImagesAutomatically(true);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setPluginsEnabled(true);
    ((WebSettings)localObject).setCacheMode(-1);
    ((WebSettings)localObject).setBuiltInZoomControls(false);
    ((WebSettings)localObject).setUserAgent(((WebSettings)localObject).getUserAgentString() + " ApiLevel/" + Build.VERSION.SDK_INT + " QQ/" + CommonDataAdapter.a().b() + " Agent/" + CommonDataAdapter.a().d());
    if (Build.VERSION.SDK_INT > 7)
    {
      ((WebSettings)localObject).setPluginState(WebSettings.PluginState.ON);
      ((WebSettings)localObject).setDatabaseEnabled(true);
      ((WebSettings)localObject).setDatabasePath(getApplicationContext().getDir("storage", 2).getPath());
      ((WebSettings)localObject).setDomStorageEnabled(true);
      ((WebSettings)localObject).setAppCacheEnabled(true);
      ((WebSettings)localObject).setAppCachePath(getApplicationContext().getDir("cache", 2).getPath());
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack = new BaseJsCallBack(this);
    localObject = new DownloadInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    HttpInterface localHttpInterface = new HttpInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    DBInterface localDBInterface = new DBInterface(this, "applist.db", 2);
    ImageCacheInterface localImageCacheInterface = new ImageCacheInterface(this.jdField_a_of_type_ComTencentSmttSdkWebView);
    AppInterface localAppInterface = new AppInterface(this, this.jdField_a_of_type_ComTencentSmttSdkWebView);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localHttpInterface);
    this.jdField_a_of_type_JavaUtilList.add(localDBInterface);
    this.jdField_a_of_type_JavaUtilList.add(localImageCacheInterface);
    this.jdField_a_of_type_JavaUtilList.add(localAppInterface);
    if (new File(Common.d()).exists()) {
      InterfaceRegisterUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentSmttSdkWebView, "file:///" + Common.d(), this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(new AppShareJavaScript(this), "QQApi");
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibility");
        this.jdField_a_of_type_ComTencentSmttSdkWebView.removeJavascriptInterface("accessibilityTraversal");
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232114));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentSmttSdkWebView);
      if ((this.h) && (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack != null)) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.setParams("&isFirstEnter=1");
      }
      return;
      InterfaceRegisterUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentSmttSdkWebView, d, this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge);
    }
  }
  
  protected void l()
  {
    String str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
    LogUtility.c("IphoneTitleBarActivity", "reloadView;currentUrl=" + str + "; isReloadView()=" + c());
    if (c())
    {
      b(false);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.clearCache(true);
    }
    a(Common.e(), str, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity
 * JD-Core Version:    0.7.0.1
 */