package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class UIJsPlugin$4$1
  implements DialogInterface.OnClickListener
{
  UIJsPlugin$4$1(UIJsPlugin.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("confirm", true);
      this.this$1.val$req.ok(localJSONObject);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QMLog.e("UIJsPlugin", "show modalView error." + paramDialogInterface);
      this.this$1.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */