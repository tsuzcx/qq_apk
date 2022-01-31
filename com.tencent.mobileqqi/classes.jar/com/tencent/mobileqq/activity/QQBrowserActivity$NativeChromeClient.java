package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import dbu;

public class QQBrowserActivity$NativeChromeClient
  extends WebChromeClient
{
  private View jdField_a_of_type_AndroidViewView;
  private IX5WebChromeClient.CustomViewCallback jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public QQBrowserActivity$NativeChromeClient(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).getText().toString();
      QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setText(2131560958);
      return;
    }
    QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.b == null) {
      this.b = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2130904048, null);
    }
    return this.b;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    super.onConsoleMessage(paramConsoleMessage);
    return !QLog.isColorLevel();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    paramGeolocationPermissionsCallback.invoke(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString, "publicAccount.getLocation"), false);
  }
  
  public void onHideCustomView()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.removeView(this.jdField_a_of_type_AndroidViewView);
      label31:
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback.onCustomViewHidden();
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.b = null;
      a(false);
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.T != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.T.length() > 0)) {}
    while (paramString == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.j)
    {
      QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).postDelayed(new dbu(this, paramString), 50L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setTitle(paramString);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.addView(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = paramCustomViewCallback;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b.setVisibility(0);
  }
  
  public void openFileChooser(ValueCallback paramValueCallback)
  {
    openFileChooser(paramValueCallback, "");
  }
  
  public void openFileChooser(ValueCallback paramValueCallback, String paramString)
  {
    QQBrowserActivity.jdField_a_of_type_AndroidWebkitValueCallback = paramValueCallback;
    paramValueCallback = new Intent("android.intent.action.GET_CONTENT");
    paramValueCallback.addCategory("android.intent.category.OPENABLE");
    paramValueCallback.setType("*/*");
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.startActivityForResult(Intent.createChooser(paramValueCallback, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131562638)), 0);
  }
  
  public void openFileChooser(ValueCallback paramValueCallback, String paramString1, String paramString2)
  {
    openFileChooser(paramValueCallback, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.NativeChromeClient
 * JD-Core Version:    0.7.0.1
 */