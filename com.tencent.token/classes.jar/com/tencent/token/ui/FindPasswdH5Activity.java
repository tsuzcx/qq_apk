package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.token.xr;
import com.tencent.token.xv;

public class FindPasswdH5Activity
  extends EmbedWebBaseActivity
{
  String url;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent().getStringExtra("captcha_sig");
    xv.a("captcha_sig=".concat(String.valueOf(paramBundle)));
    switch (xr.a())
    {
    default: 
      localWebView = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493452));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      localWebView.loadUrl(localStringBuilder.toString());
      return;
    case 3: 
      localWebView = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493263));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      localWebView.loadUrl(localStringBuilder.toString());
      return;
    case 2: 
      localWebView = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493116));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      localWebView.loadUrl(localStringBuilder.toString());
      return;
    case 1: 
      localWebView = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493452));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      localWebView.loadUrl(localStringBuilder.toString());
      return;
    }
    WebView localWebView = this.mWebView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getString(2131493612));
    localStringBuilder.append("&key=");
    localStringBuilder.append(paramBundle);
    localWebView.loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindPasswdH5Activity
 * JD-Core Version:    0.7.0.1
 */