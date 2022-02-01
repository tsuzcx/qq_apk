package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.JsCallbackBuilder;
import java.lang.ref.WeakReference;

public abstract class BaseJsHandler
{
  protected WeakReference<Object> mWeakWebViewImpl;
  
  private BaseJsHandler() {}
  
  BaseJsHandler(WeakReference<Object> paramWeakReference)
  {
    this.mWeakWebViewImpl = paramWeakReference;
  }
  
  @Nullable
  private Object getRealWebView()
  {
    if (this.mWeakWebViewImpl != null) {
      return this.mWeakWebViewImpl.get();
    }
    return null;
  }
  
  protected void callback(String paramString1, String paramString2, String paramString3, IJsEntityFormatter paramIJsEntityFormatter)
  {
    paramString2 = new JsCallbackBuilder().setRet(paramString2).setMsg(paramString3).setData(paramIJsEntityFormatter).format();
    WebViewCompatHelper.loadUrl(getRealWebView(), "javascript:DtJsReporter.callback('" + paramString1 + "'," + paramString2 + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler
 * JD-Core Version:    0.7.0.1
 */