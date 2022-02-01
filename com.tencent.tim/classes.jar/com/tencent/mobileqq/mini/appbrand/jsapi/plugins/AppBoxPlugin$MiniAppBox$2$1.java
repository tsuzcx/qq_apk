package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tgx;

class AppBoxPlugin$MiniAppBox$2$1
  implements tgx
{
  AppBoxPlugin$MiniAppBox$2$1(AppBoxPlugin.MiniAppBox.2 param2) {}
  
  public void onDismiss()
  {
    QLog.i("[minigame] MiniAppBox", 1, "gdtBox onDismiss");
    if (AppBoxPlugin.MiniAppBox.access$300(this.this$1.this$0) != null)
    {
      JSONObject localJSONObject = AppBoxPlugin.MiniAppBox.access$400(this.this$1.this$0, this.this$1.val$compId, -1);
      AppBoxPlugin.MiniAppBox.access$300(this.this$1.this$0).evaluateSubcribeJS("onAppBoxClose", localJSONObject.toString(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppBoxPlugin.MiniAppBox.2.1
 * JD-Core Version:    0.7.0.1
 */