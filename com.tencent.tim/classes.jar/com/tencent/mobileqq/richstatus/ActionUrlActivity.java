package com.tencent.mobileqq.richstatus;

import Override;
import aiim;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.ProtectedWebView;
import java.io.File;

public class ActionUrlActivity
  extends IphoneTitleBarActivity
{
  private View Gx;
  private aiim jdField_a_of_type_Aiim;
  private StatusJsHandler jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler;
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  private String bZV;
  private View iX;
  private ProgressBar mProgressBar;
  private RelativeLayout mRootView;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void initUI()
  {
    this.mRootView = ((RelativeLayout)findViewById(2131381368));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView = new ProtectedWebView(BaseApplicationImpl.sApplication);
    this.mRootView.addView(this.jdField_a_of_type_ComTencentWidgetProtectedWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setScrollBarStyle(0);
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentWidgetProtectedWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + "QQ/5.2");
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
    localWebSettings.setDomStorageEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebViewClient(new b(null));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebChromeClient(new a(null));
    this.jdField_a_of_type_Aiim = new aiim();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler = new StatusJsHandler(this, this.jdField_a_of_type_ComTencentWidgetProtectedWebView, null);
    this.jdField_a_of_type_Aiim.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler, "statusJsHandler");
    this.Gx = ((LinearLayout)findViewById(2131381364));
    this.Gx.setVisibility(0);
    this.mProgressBar = ((ProgressBar)findViewById(2131381365));
    this.bZV = this.leftView.getText().toString();
    this.iX = findViewById(2131371159);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.iX.setVisibility(0);
    }
  }
  
  void dMY()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack())
    {
      this.leftView.setText(2131721490);
      return;
    }
    this.leftView.setText(this.bZV);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563301);
    initUI();
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.loadUrl(getIntent().getStringExtra("key_params_qq"));
    this.mProgressBar.setVisibility(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.mRootView != null) {
        this.mRootView.removeAllViews();
      }
      try
      {
        label18:
        this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
        try
        {
          label25:
          this.jdField_a_of_type_ComTencentWidgetProtectedWebView.clearView();
          try
          {
            label32:
            this.jdField_a_of_type_ComTencentWidgetProtectedWebView.destroy();
            return;
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          break label32;
        }
      }
      catch (Exception localException3)
      {
        break label25;
      }
    }
    catch (Exception localException4)
    {
      break label18;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack()) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      label17:
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.goBack();
      return true;
      return super.onBackEvent();
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  class a
    extends WebChromeClient
  {
    private a() {}
    
    @Override
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
        return true;
      }
      return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      super.onProgressChanged(paramWebView, paramInt);
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      ActionUrlActivity.this.setTitle(paramString);
      ActionUrlActivity.this.dMY();
    }
  }
  
  class b
    extends WebViewClient
  {
    private b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      ActionUrlActivity.a(ActionUrlActivity.this).setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
      ActionUrlActivity.this.dMY();
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      ActionUrlActivity.a(ActionUrlActivity.this).setVisibility(0);
      ActionUrlActivity.a(ActionUrlActivity.this).setVisibility(8);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      ActionUrlActivity.a(ActionUrlActivity.this).clearView();
      ActionUrlActivity.a(ActionUrlActivity.this).setVisibility(8);
      ActionUrlActivity.a(ActionUrlActivity.this).setVisibility(0);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return ActionUrlActivity.a(ActionUrlActivity.this).b(paramWebView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionUrlActivity
 * JD-Core Version:    0.7.0.1
 */