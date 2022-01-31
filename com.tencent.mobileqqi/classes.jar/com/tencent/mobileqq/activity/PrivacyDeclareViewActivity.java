package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import dfm;
import java.net.URLDecoder;

public class PrivacyDeclareViewActivity
  extends QQBrowserActivity
  implements DialogInterface.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "PrivacyDeclareViewActivity";
  private static final int jdField_b_of_type_Int = 101;
  private static final int c = 102;
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler = new dfm(this, Looper.getMainLooper());
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_b_of_type_JavaLangString;
  
  private String a(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
    if ("1".equals(paramString1)) {
      if (this.jdField_a_of_type_Boolean)
      {
        localMessage.what = 101;
        localMessage.sendToTarget();
      }
    }
    while (!"0".equals(paramString1))
    {
      return;
      q();
      return;
    }
    localMessage.obj = paramString2;
    localMessage.what = 102;
    localMessage.sendToTarget();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener)
  {
    e();
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, (DialogInterface.OnClickListener)localObject);
    if (!TextUtils.isEmpty(paramString4)) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString4, (DialogInterface.OnClickListener)localObject);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    if (TextUtils.isEmpty(paramString1)) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setDividerGone();
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean f()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
      }
      else
      {
        r();
        finish();
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return true;
  }
  
  private void p()
  {
    setResult(11);
    finish();
  }
  
  private void q()
  {
    setResult(-1);
    finish();
  }
  
  private void r()
  {
    setResult(0);
    finish();
  }
  
  protected void a(int paramInt)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getWindowToken(), 2);
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramWebView == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (!paramString.startsWith("privacy://")) {
          break label283;
        }
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        if (paramString.startsWith("privacy://continueClick"))
        {
          q();
          return true;
        }
        bool1 = bool2;
      } while (!paramString.startsWith("privacy://cancelClick"));
      r();
      return true;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      bool1 = bool2;
    } while (!paramString.startsWith("privacy://ShowMeABox"));
    for (;;)
    {
      int j;
      try
      {
        paramWebView = paramString.split("\\?");
        bool1 = bool2;
        if (paramWebView.length <= 1) {
          break;
        }
        String[] arrayOfString = paramWebView[1].split("&");
        int k = arrayOfString.length;
        j = 0;
        paramWebView = null;
        int i = 0;
        paramString = null;
        if (j >= k) {
          break label294;
        }
        str1 = arrayOfString[j];
        int m = str1.indexOf('=');
        if (m == -1) {
          break label291;
        }
        String str2 = URLDecoder.decode(str1.substring(0, m), "UTF-8");
        str1 = URLDecoder.decode(str1.substring(m + 1), "UTF-8");
        if ("checkbox".equals(str2))
        {
          i = 1;
          paramWebView = str1;
          break label300;
        }
        if (!"language".equals(str2)) {
          break label291;
        }
        if (i == 0) {
          break label285;
        }
        bool1 = bool2;
        if (i == 0) {
          break;
        }
        a(paramWebView, str1);
        return true;
      }
      catch (Exception paramWebView)
      {
        bool1 = bool2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PrivacyDeclareViewActivity", 2, "in privacy browser shouldOverrideUrl, error:" + paramWebView.toString());
      return true;
      label283:
      return false;
      label285:
      paramString = str1;
      break label300;
      label291:
      break label300;
      label294:
      String str1 = paramString;
      continue;
      label300:
      j += 1;
    }
  }
  
  protected void d()
  {
    f();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(false);
    paramBundle = getIntent();
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getIntExtra("key_privacy_start", 0);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_privacy_type", 0);
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_privacy_uin");
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("key_privacy_underage", false);
    }
    for (;;)
    {
      if (i != 1001)
      {
        Log.e("PrivacyDeclareViewActivity", "you must start by PrivacyDeclareHelper class!");
        finish();
      }
      while (!QLog.isColorLevel()) {
        return true;
      }
      QLog.d("PrivacyDeclareViewActivity", 2, "in privacy browser, get:" + this.jdField_a_of_type_Int + " , " + this.jdField_b_of_type_JavaLangString + " , " + this.jdField_a_of_type_Boolean);
      return true;
      i = 0;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (f())) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void l_()
  {
    super.l_();
    this.p.setVisibility(8);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PrivacyDeclareViewActivity
 * JD-Core Version:    0.7.0.1
 */