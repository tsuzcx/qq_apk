package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;

public class VerifyCreditCardIdentityActivity
  extends QQBrowserActivity
{
  private void e()
  {
    setResult(2001);
    finish();
  }
  
  protected boolean a(WebView paramWebView, String paramString)
  {
    if ((paramWebView == null) || (TextUtils.isEmpty(paramString))) {}
    while (!paramString.startsWith("privacy://authSuccess")) {
      return false;
    }
    e();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCreditCardIdentityActivity
 * JD-Core Version:    0.7.0.1
 */