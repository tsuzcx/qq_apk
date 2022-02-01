package com.tencent.mobileqq.minigame.utils;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class VConsoleLogManager$1
  extends WebViewClient
{
  VConsoleLogManager$1(VConsoleLogManager paramVConsoleLogManager) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    VConsoleLogManager.access$000(this.this$0, true);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.VConsoleLogManager.1
 * JD-Core Version:    0.7.0.1
 */