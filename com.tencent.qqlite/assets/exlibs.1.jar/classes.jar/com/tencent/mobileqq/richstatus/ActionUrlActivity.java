package com.tencent.mobileqq.richstatus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.widget.ProtectedWebView;
import eaz;
import eba;
import java.io.File;

public class ActionUrlActivity
  extends IphoneTitleBarActivity
{
  public static final String a;
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private JsBridge jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge;
  private StatusJsHandler jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler;
  private ProtectedWebView jdField_a_of_type_ComTencentWidgetProtectedWebView;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = ActionUrlActivity.class.getSimpleName();
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298961));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView = new ProtectedWebView(BaseApplicationImpl.a);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetProtectedWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setScrollBarStyle(0);
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentWidgetProtectedWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " " + "QQ/4.6");
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDatabasePath(getApplicationContext().getDir("database", 0).getPath());
    localWebSettings.setDomStorageEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebViewClient(new eba(this, null));
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.setWebChromeClient(new eaz(this, null));
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge = new JsBridge();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler = new StatusJsHandler(this, this.jdField_a_of_type_ComTencentWidgetProtectedWebView, null);
    this.jdField_a_of_type_ComTencentMobileqqJsbridgeJsBridge.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusJsHandler, "statusJsHandler");
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131298962));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131298963));
    this.jdField_b_of_type_JavaLangString = this.h.getText().toString();
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296648);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetProtectedWebView.canGoBack()) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.stopLoading();
      label17:
      this.jdField_a_of_type_ComTencentWidgetProtectedWebView.goBack();
      return true;
      return super.a();
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903705);
    c();
    this.jdField_a_of_type_ComTencentWidgetProtectedWebView.loadUrl(getIntent().getStringExtra("key_params_qq"));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionUrlActivity
 * JD-Core Version:    0.7.0.1
 */