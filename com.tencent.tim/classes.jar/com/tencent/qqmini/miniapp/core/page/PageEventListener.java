package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.IJsService;

public abstract interface PageEventListener
{
  public abstract void onAppRoute(String paramString1, String paramString2, int paramInt);
  
  public abstract void onAppRouteDone(String paramString1, String paramString2, int paramInt);
  
  public abstract void onWebViewEvent(String paramString1, String paramString2, int paramInt);
  
  public abstract String onWebViewNativeRequest(String paramString1, String paramString2, IJsService paramIJsService, int paramInt);
  
  public abstract void onWebViewReady(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageEventListener
 * JD-Core Version:    0.7.0.1
 */