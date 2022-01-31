package com.tencent.captchasdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class i
  extends WebViewClient
{
  i(h paramh) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
      paramWebView.getContext().startActivity(paramString);
      return true;
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.i
 * JD-Core Version:    0.7.0.1
 */