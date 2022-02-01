package com.tencent.mobileqq.troop.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity.TopBarBtnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import gtm;
import gtn;
import java.net.URLEncoder;

public abstract class TroopCreateBaseActivity
  extends QQBrowserActivity
{
  private static final int a = 1;
  static final String b = "&ver=%d&clientversion=%s";
  public Dialog a;
  
  protected static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = URLEncoder.encode(h());
    return paramString + String.format("&ver=%d&clientversion=%s", new Object[] { Integer.valueOf(1), str });
  }
  
  protected static String h()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      localObject = ((PackageInfo)localObject).versionName + "." + ((PackageInfo)localObject).versionCode;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return "";
  }
  
  protected void a(int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWindowToken(), 2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString2 = paramString2.replace("\"", "\\\"");
    paramString1 = "javascript:" + paramString1 + "(\"" + paramString2 + "\")";
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString1);
  }
  
  protected void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = "javascript:" + paramString + "()";
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener.onClick(this.k);
      return true;
    }
    return false;
  }
  
  protected void c(String paramString)
  {
    p();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, d());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new gtm(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new gtn(this, paramString3);
    DialogUtil.a(this, 230, paramString1, paramString2, 2131561746, 2131562539, paramString3, paramString3).show();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      return;
    }
    finish();
  }
  
  protected void l_()
  {
    super.l_();
    this.p.setVisibility(8);
    a(false);
    this.k.setOnClickListener(new QQBrowserActivity.TopBarBtnClickListener(this, 0, null));
  }
  
  void p()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void q()
  {
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getChildCount();
    localCustomWebView.setFocusableInTouchMode(true);
    localCustomWebView.setFocusable(true);
    localCustomWebView.requestFocus();
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(localCustomWebView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity
 * JD-Core Version:    0.7.0.1
 */