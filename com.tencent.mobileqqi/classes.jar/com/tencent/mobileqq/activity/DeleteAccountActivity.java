package com.tencent.mobileqq.activity;

import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;

public class DeleteAccountActivity
  extends QQBrowserActivity
{
  protected boolean a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if (paramString.equals("delete://logoutSuccess"))
    {
      Toast.makeText(this, 2131563357, 0).show();
      setResult(1);
      finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DeleteAccountActivity
 * JD-Core Version:    0.7.0.1
 */