package com.tencent.qqlive.module.videoreport.inject.webview.webclient;

import android.graphics.Bitmap;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class ReportX5CoreWebViewClient
  extends WebViewClient
{
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    JsInjector.getInstance().onPageStarted(paramWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebViewClient
 * JD-Core Version:    0.7.0.1
 */