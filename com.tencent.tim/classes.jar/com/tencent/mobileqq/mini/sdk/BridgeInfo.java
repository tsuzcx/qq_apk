package com.tencent.mobileqq.mini.sdk;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.lang.ref.WeakReference;

public class BridgeInfo
{
  public int callbackId;
  private WeakReference<JsRuntime> webviewRef;
  
  public BridgeInfo(JsRuntime paramJsRuntime, int paramInt)
  {
    this.webviewRef = new WeakReference(paramJsRuntime);
    this.callbackId = paramInt;
  }
  
  public JsRuntime getWebView()
  {
    if (this.webviewRef != null) {
      return (JsRuntime)this.webviewRef.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.BridgeInfo
 * JD-Core Version:    0.7.0.1
 */