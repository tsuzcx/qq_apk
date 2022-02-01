package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppBrandRuntime$KeyboardObserver$2
  implements Runnable
{
  AppBrandRuntime$KeyboardObserver$2(AppBrandRuntime.KeyboardObserver paramKeyboardObserver, Object paramObject) {}
  
  public void run()
  {
    int j;
    if ((this.this$1.this$0.serviceRuntime != null) && (this.this$1.this$0.pageContainer != null) && (this.this$1.this$0.pageContainer.getCurrentPageWebview() != null))
    {
      j = (int)(Integer.valueOf(String.valueOf(this.val$arg)).intValue() * DisplayUtil.getDensity(this.this$1.this$0.activity));
      if (this.this$1.this$0.jsPluginEngine == null) {
        break label198;
      }
    }
    for (int i = this.this$1.this$0.jsPluginEngine.getCurInputId();; i = -1)
    {
      QLog.d("AppBrandRuntime", 2, "KeyboardObserver height : " + j + "; inputId : " + i);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("height", this.val$arg);
        localJSONObject.put("inputId", i);
        this.this$1.this$0.serviceRuntime.evaluateSubcribeJS("onKeyboardHeightChange", localJSONObject.toString(), this.this$1.this$0.pageContainer.getCurrentPageWebview().getPageWebViewId());
        return;
      }
      catch (Throwable localThrowable)
      {
        label198:
        QLog.e("AppBrandRuntime", 2, "KeyboardObserver error, ", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.KeyboardObserver.2
 * JD-Core Version:    0.7.0.1
 */