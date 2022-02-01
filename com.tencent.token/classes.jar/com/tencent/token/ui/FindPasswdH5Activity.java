package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.token.global.c;
import com.tencent.token.global.g;

public class FindPasswdH5Activity
  extends EmbedWebBaseActivity
{
  String url;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    paramBundle = getIntent().getStringExtra("captcha_sig");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("captcha_sig=");
    ((StringBuilder)localObject).append(paramBundle);
    g.a(((StringBuilder)localObject).toString());
    switch (c.a())
    {
    default: 
      localObject = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493444));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    case 3: 
      localObject = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493261));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    case 2: 
      localObject = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493114));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    case 1: 
      localObject = this.mWebView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131493444));
      localStringBuilder.append("&key=");
      localStringBuilder.append(paramBundle);
      ((WebView)localObject).loadUrl(localStringBuilder.toString());
      return;
    }
    localObject = this.mWebView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getString(2131493603));
    localStringBuilder.append("&key=");
    localStringBuilder.append(paramBundle);
    ((WebView)localObject).loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FindPasswdH5Activity
 * JD-Core Version:    0.7.0.1
 */