package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.PickerView.OnConfirmListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$5$1
  implements PickerView.OnConfirmListener
{
  UIJsPlugin$5$1(UIJsPlugin.5 param5) {}
  
  public void onValCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.this$0.jsPluginEngine.callbackJsEventCancel(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", localException);
    }
  }
  
  public void onValConfirm(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */