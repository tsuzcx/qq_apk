package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.tencent.token.global.h;

class ec
  extends WebViewClient
{
  ec(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    h.c("onPageFinished");
    if (this.a.mWebView.canGoBack()) {
      this.a.closetext.setVisibility(0);
    }
    for (;;)
    {
      if ((paramWebView != null) && (paramWebView.getTitle() != null) && (paramWebView.getTitle().length() > 0) && (this.a.mDynamicTitle)) {
        this.a.setTitle(paramWebView.getTitle());
      }
      return;
      this.a.closetext.setVisibility(4);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    h.a("url" + paramString + ",override=");
    return this.a.overrideUrlLoading(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ec
 * JD-Core Version:    0.7.0.1
 */