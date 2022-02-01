package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.PickerView.OnConfirmListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$1$1
  implements PickerView.OnConfirmListener
{
  PickerJsPlugin$1$1(PickerJsPlugin.1 param1) {}
  
  public void onValCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.val$req.cancel(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PickerJsPlugin", "showPickerView error.", localException);
    }
  }
  
  public void onValConfirm(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      this.this$1.val$req.ok(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showPickerView error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */