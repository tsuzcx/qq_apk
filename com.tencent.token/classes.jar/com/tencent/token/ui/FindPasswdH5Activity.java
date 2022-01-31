package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.token.global.c;
import com.tencent.token.global.h;

public class FindPasswdH5Activity
  extends EmbedWebBaseActivity
{
  String url;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent().getStringExtra("captcha_sig");
    h.a("captcha_sig=" + paramBundle);
    switch (c.a())
    {
    default: 
      this.mWebView.loadUrl(getResources().getString(2131231301) + "&key=" + paramBundle);
      return;
    case 0: 
      this.mWebView.loadUrl(getResources().getString(2131231458) + "&key=" + paramBundle);
      return;
    case 1: 
      this.mWebView.loadUrl(getResources().getString(2131231301) + "&key=" + paramBundle);
      return;
    case 2: 
      this.mWebView.loadUrl(getResources().getString(2131230971) + "&key=" + paramBundle);
      return;
    }
    this.mWebView.loadUrl(getResources().getString(2131231118) + "&key=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindPasswdH5Activity
 * JD-Core Version:    0.7.0.1
 */