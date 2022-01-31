package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;

class SmttWebViewClient
  extends X5ProxyWebViewClient
{
  private WebViewClient mClient;
  private WebView mWebView;
  
  public SmttWebViewClient(WebViewWizardBase paramWebViewWizardBase, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    super(paramWebViewWizardBase);
    this.mWebView = paramWebView;
    this.mClient = paramWebViewClient;
    this.mClient.mX5Client = this;
  }
  
  public void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.doUpdateVisitedHistory(this.mWebView, paramString, paramBoolean);
  }
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onFormResubmission(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onLoadResource(this.mWebView, paramString);
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    paramIX5WebViewBase = this.mWebView;
    paramIX5WebViewBase.mPv += 1;
    this.mClient.onPageFinished(this.mWebView, paramString);
    this.mWebView.hideSplashLogo();
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onPageStarted(this.mWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedError(this.mWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedHttpAuthRequest(this.mWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedLoginRequest(this.mWebView, paramString1, paramString2, paramString3);
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onReceivedSslError(this.mWebView, paramSslErrorHandler, paramSslError);
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onScaleChanged(this.mWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onTooManyRedirects(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    this.mClient.onUnhandledKeyEvent(this.mWebView, paramKeyEvent);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldInterceptRequest(this.mWebView, paramString);
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldOverrideKeyEvent(this.mWebView, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    this.mWebView.setX5WebView(paramIX5WebViewBase);
    return this.mClient.shouldOverrideUrlLoading(this.mWebView, paramString);
  }
  
  public void super_onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(this.mWebView.getX5WebView(), 0, 0, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebViewClient
 * JD-Core Version:    0.7.0.1
 */