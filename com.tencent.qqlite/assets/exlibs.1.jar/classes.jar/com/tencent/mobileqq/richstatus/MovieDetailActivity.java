package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.ProtectedWebView;
import edh;
import edi;
import java.io.File;
import mqq.app.AppRuntime;

public class MovieDetailActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "k_same_tuin";
  private static final String jdField_b_of_type_JavaLangString = "Q.richstatus.";
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private JsBridge jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge;
  private StatusJsHandler jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler;
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  private View jdField_b_of_type_AndroidViewView;
  private String c;
  private String d;
  
  public static boolean a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    StatusManager localStatusManager = (StatusManager)paramBaseActivity.getAppRuntime().getManager(14);
    if (localStatusManager == null) {
      return false;
    }
    return localStatusManager.a(paramBaseActivity, paramString1, paramInt1, paramInt2, paramString2);
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack())
    {
      c();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      label30:
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.goBack();
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  private void d()
  {
    Object localObject = (RelativeLayout)findViewById(2131298936);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView = new ProtectedWebView(BaseApplicationImpl.a);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentWidgetProtectedWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setScrollBarStyle(0);
    localObject = this.jdField_a_of_type_ComTencentWidgetProtectedWebView.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + " " + "QQ/4.6");
    ((WebSettings)localObject).setDatabaseEnabled(true);
    ((WebSettings)localObject).setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
    ((WebSettings)localObject).setDomStorageEnabled(true);
    ((WebSettings)localObject).setGeolocationEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebViewClient(new edi(this, null));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebChromeClient(new edh(this, null));
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge = new JsBridge();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler = new StatusJsHandler(this, this.jdField_a_of_type_ComTencentWidgetProtectedWebView, null);
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler, "statusJsHandler");
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131298937));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131298938));
    this.b = findViewById(2131296651);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.b.setVisibility(0);
    }
  }
  
  private void e()
  {
    this.c = getIntent().getStringExtra("key_params_qq");
    this.d = getIntent().getStringExtra("k_same_tuin");
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.loadUrl(this.c);
  }
  
  public boolean a()
  {
    if (c()) {
      return true;
    }
    return super.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack())
    {
      this.h.setText(2131363123);
      return;
    }
    this.h.setText(getIntent().getStringExtra("leftViewText"));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903697);
    d();
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      try
      {
        label11:
        this.jdField_a_of_type_ComTencentWidgetProtectedWebView.clearView();
        try
        {
          label18:
          this.jdField_a_of_type_ComTencentWidgetProtectedWebView.destroy();
          return;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        break label18;
      }
    }
    catch (Exception localException3)
    {
      break label11;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 4) || (paramKeyEvent.getAction() == 0)) && (c())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.MovieDetailActivity
 * JD-Core Version:    0.7.0.1
 */