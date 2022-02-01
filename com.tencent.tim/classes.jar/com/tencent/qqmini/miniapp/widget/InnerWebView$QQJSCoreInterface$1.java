package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;

class InnerWebView$QQJSCoreInterface$1
  implements Action<String>
{
  InnerWebView$QQJSCoreInterface$1(InnerWebView.QQJSCoreInterface paramQQJSCoreInterface, String paramString1, String paramString2, int paramInt) {}
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getJsPluginEngine();
    if ((paramBaseRuntime instanceof JsPluginEngine))
    {
      paramBaseRuntime = (JsPluginEngine)paramBaseRuntime;
      QMLog.d("Action", "Dispatch repeat RequestEvent=" + this.val$event);
      return paramBaseRuntime.handleNativeRequest(this.val$event, this.val$jsonParams, (IJsService)InnerWebView.access$100(this.this$1.this$0), this.val$callbackId);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.QQJSCoreInterface.1
 * JD-Core Version:    0.7.0.1
 */