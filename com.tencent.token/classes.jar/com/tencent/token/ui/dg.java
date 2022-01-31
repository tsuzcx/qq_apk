package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.tencent.token.global.e;

final class dg
  extends WebViewClient
{
  dg(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    e.c("onPageFinished");
    if (this.a.mWebView.canGoBack()) {
      this.a.closetext.setVisibility(0);
    }
    for (;;)
    {
      this.a.mIsRefreshing = false;
      EmbedWebBaseActivity.access$102(this.a, false);
      return;
      this.a.closetext.setVisibility(4);
    }
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {}
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    e.a("url" + paramString);
    return this.a.overrideUrlLoading(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dg
 * JD-Core Version:    0.7.0.1
 */