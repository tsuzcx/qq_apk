package com.tencent.smtt.sdk;

import Override;
import android.annotation.TargetApi;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

class e
  extends SystemWebChromeClient
{
  e(WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramWebView, paramWebChromeClient);
  }
  
  @TargetApi(7)
  public void onHideCustomView()
  {
    this.a.onHideCustomView();
  }
  
  @Override
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  @Override
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  @Deprecated
  @TargetApi(14)
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.a.onShowCustomView(paramView, paramInt, new SystemWebChromeClient.b(this, paramCustomViewCallback));
  }
  
  @TargetApi(7)
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.a.onShowCustomView(paramView, new SystemWebChromeClient.b(this, paramCustomViewCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.e
 * JD-Core Version:    0.7.0.1
 */