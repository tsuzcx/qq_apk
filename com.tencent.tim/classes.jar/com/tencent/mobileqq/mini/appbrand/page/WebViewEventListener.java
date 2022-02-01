package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.webview.JsRuntime;

public abstract interface WebViewEventListener
{
  public abstract void onWebViewEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract String onWebViewNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebViewEventListener
 * JD-Core Version:    0.7.0.1
 */