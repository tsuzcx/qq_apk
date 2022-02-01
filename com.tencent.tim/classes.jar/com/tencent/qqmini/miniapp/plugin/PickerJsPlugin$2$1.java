package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.MutiPickerView.OnConfirmListener;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$2$1
  implements MutiPickerView.OnConfirmListener
{
  PickerJsPlugin$2$1(PickerJsPlugin.2 param2) {}
  
  public void onValCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.val$req.cancel(localJSONObject);
      if (PickerJsPlugin.access$100(this.this$1.this$0) != null) {
        PickerJsPlugin.access$102(this.this$1.this$0, null);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("PickerJsPlugin", "showMultiPickerView error.", localException);
      }
    }
  }
  
  public void onValChange(int paramInt1, int paramInt2)
  {
    int i = PageAction.obtain(PickerJsPlugin.access$300(this.this$1.this$0)).getPageId();
    this.this$1.val$req.jsService.evaluateSubscribeJS("onMultiPickerViewChange", String.format("{\"column\":%d,\"current\":%d}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), i);
  }
  
  public void onValConfirm(int[] paramArrayOfInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfInt[i]);
        i += 1;
      }
      localJSONObject.put("current", localJSONArray);
      this.this$1.val$req.ok(localJSONObject);
    }
    catch (JSONException paramArrayOfInt)
    {
      for (;;)
      {
        QMLog.e("PickerJsPlugin", "showMultiPickerView error.", paramArrayOfInt);
      }
    }
    if (PickerJsPlugin.access$100(this.this$1.this$0) != null) {
      PickerJsPlugin.access$102(this.this$1.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */