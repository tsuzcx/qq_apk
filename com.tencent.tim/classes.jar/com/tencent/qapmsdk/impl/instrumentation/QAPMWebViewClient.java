package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qapmsdk.webview.WebViewX5Proxy;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

public class QAPMWebViewClient
  extends WebViewClient
{
  private boolean isAddJavascript = false;
  private String mainPageUrl;
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return;
      this.mainPageUrl = paramString;
      WebViewX5Proxy.getInstance().setCodeTypeIsX5(false);
    } while ((!WebViewX5Proxy.getInstance().getWebViewMonitorState()) || (paramWebView.getTag(33554432) != null));
    paramWebView.addJavascriptInterface(QAPMJavaScriptBridge.getInstance(), "QAPMAndroidJsBridge");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
  }
  
  @TargetApi(23)
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMWebViewClient
 * JD-Core Version:    0.7.0.1
 */