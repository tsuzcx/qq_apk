package io.flutter.plugins.webviewflutter;

import Override;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class FlutterWebViewClient$2
  extends WebViewClient
{
  FlutterWebViewClient$2(FlutterWebViewClient paramFlutterWebViewClient) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    FlutterWebViewClient.access$300(this.this$0, paramWebView, paramString);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent) {}
  
  @TargetApi(24)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return FlutterWebViewClient.access$200(this.this$0, paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebViewClient.2
 * JD-Core Version:    0.7.0.1
 */