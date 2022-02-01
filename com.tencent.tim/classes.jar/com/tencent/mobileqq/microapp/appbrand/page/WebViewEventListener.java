package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;

public abstract interface WebViewEventListener
{
  public abstract void onWebViewEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
  
  public abstract String onWebViewNativeRequest(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebViewEventListener
 * JD-Core Version:    0.7.0.1
 */