package com.tencent.qqmail.activity.webviewexplorer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.utilities.log.QMLog;

public abstract class BaseSafeWebViewClient
  extends WebViewClient
{
  private static final String TAG = "BaseSafeWebViewClient";
  
  protected void doSafeUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    try
    {
      doSafeUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "doUpdateVisitedHistory", paramWebView);
    }
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    try
    {
      onSafeFormResubmission(paramWebView, paramMessage1, paramMessage2);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onFormResubmission", paramWebView);
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    try
    {
      onSafeLoadResource(paramWebView, paramString);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onLoadResource", paramWebView);
    }
  }
  
  public void onPageCommitVisible(WebView paramWebView, String paramString)
  {
    try
    {
      onSafePageCommitVisible(paramWebView, paramString);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onPageCommitVisible", paramWebView);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    try
    {
      onSafePageFinished(paramWebView, paramString);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onPageFinished", paramWebView);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    try
    {
      onSafePageStarted(paramWebView, paramString, paramBitmap);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onPageStarted", paramWebView);
    }
  }
  
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    try
    {
      onSafeReceivedClientCertRequest(paramWebView, paramClientCertRequest);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedClientCertRequest", paramWebView);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      onSafeReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedError", paramWebView);
    }
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    try
    {
      onSafeReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedError", paramWebView);
    }
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    try
    {
      onSafeReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedHttpAuthRequest", paramWebView);
    }
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    try
    {
      onSafeReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedHttpError", paramWebView);
    }
  }
  
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      onSafeReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedLoginRequest", paramWebView);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    try
    {
      onSafeReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onReceivedSslError", paramWebView);
    }
  }
  
  protected void onSafeFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    super.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
  }
  
  protected void onSafeLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }
  
  protected void onSafePageCommitVisible(WebView paramWebView, String paramString)
  {
    super.onPageCommitVisible(paramWebView, paramString);
  }
  
  protected void onSafePageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  protected void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  protected void onSafeReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    super.onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
  }
  
  protected void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  protected void onSafeReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
  }
  
  protected void onSafeReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
  
  protected void onSafeReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  protected void onSafeReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    super.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
  }
  
  protected void onSafeReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  protected void onSafeScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    super.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
  }
  
  protected void onSafeTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    super.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
  }
  
  protected void onSafeUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    super.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    try
    {
      onSafeScaleChanged(paramWebView, paramFloat1, paramFloat2);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onScaleChanged", paramWebView);
    }
  }
  
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    try
    {
      onSafeTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onTooManyRedirects", paramWebView);
    }
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    try
    {
      onSafeUnhandledKeyEvent(paramWebView, paramKeyEvent);
      return;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "onUnhandledKeyEvent", paramWebView);
    }
  }
  
  @TargetApi(21)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    try
    {
      paramWebView = shouldSafeInterceptRequest(paramWebView, paramWebResourceRequest);
      return paramWebView;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "shouldInterceptRequest", paramWebView);
    }
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    try
    {
      paramWebView = shouldSafeInterceptRequest(paramWebView, paramString);
      return paramWebView;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "shouldInterceptRequest", paramWebView);
    }
    return null;
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    try
    {
      boolean bool = shouldSafeOverrideKeyEvent(paramWebView, paramKeyEvent);
      return bool;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "shouldOverrideKeyEvent", paramWebView);
    }
    return false;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      boolean bool = shouldSafeOverrideUrlLoading(paramWebView, paramString);
      return bool;
    }
    catch (Throwable paramWebView)
    {
      QMLog.log(6, "BaseSafeWebViewClient", "shouldOverrideUrlLoading", paramWebView);
    }
    return false;
  }
  
  protected WebResourceResponse shouldSafeInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
  
  protected WebResourceResponse shouldSafeInterceptRequest(WebView paramWebView, String paramString)
  {
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  protected boolean shouldSafeOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    return super.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
  }
  
  protected boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient
 * JD-Core Version:    0.7.0.1
 */