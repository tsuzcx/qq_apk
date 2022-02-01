package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MiniAppTextArea1;
import com.tencent.mobileqq.mini.widget.input.WebInputHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

class InputJsPlugin$3
  implements Runnable
{
  InputJsPlugin$3(InputJsPlugin paramInputJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = null;
    try
    {
      int i = new JSONObject(this.val$jsonParams).optInt("inputId");
      if (((this.val$webview instanceof PageWebview)) && (WebInputHandler.getInstance().getShowingInput() != null) && (!WebInputHandler.getInstance().getShowingInput().containsKey(Integer.valueOf(i))))
      {
        Object localObject2 = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
        if (localObject2 != null) {
          localObject1 = ((AbsAppBrandPage)localObject2).getCurrentWebviewContainer();
        }
        if (localObject1 != null)
        {
          localObject2 = ((WebviewContainer)localObject1).getTextArea(i);
          if (localObject2 != null)
          {
            InputMethodManager localInputMethodManager = (InputMethodManager)((WebviewContainer)localObject1).getContext().getSystemService("input_method");
            if (localInputMethodManager != null) {
              localInputMethodManager.hideSoftInputFromWindow(((MiniAppTextArea1)localObject2).getWindowToken(), 0);
            }
            ((WebviewContainer)localObject1).appBrandRuntime.getCurPage().hideKeyBoardConfirmView();
            localObject1 = ApiUtil.wrapCallbackOk(this.val$event, null);
            this.val$webview.evaluateCallbackJs(this.val$callbackId, ((JSONObject)localObject1).toString());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("inputId", i);
            ((JSONObject)localObject1).put("value", ((MiniAppTextArea1)localObject2).getText().toString());
            ((JSONObject)localObject1).put("cursor", ((MiniAppTextArea1)localObject2).getText().toString().length());
            this.val$webview.evaluateSubcribeJS("onKeyboardComplete", ((JSONObject)localObject1).toString(), ((PageWebview)this.val$webview).pageWebviewId);
          }
        }
      }
      else
      {
        WebInputHandler.getInstance().hideKeyboard(this.this$0.jsPluginEngine, this.val$webview, this.val$jsonParams, this.val$callbackId);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] InputJsPlugin", 1, "EVENT_HIDE_KEYBOARD error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InputJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */