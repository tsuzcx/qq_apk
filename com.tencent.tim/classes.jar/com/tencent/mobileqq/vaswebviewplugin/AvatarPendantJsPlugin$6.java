package com.tencent.mobileqq.vaswebviewplugin;

import ausj.c;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class AvatarPendantJsPlugin$6
  implements ausj.c
{
  AvatarPendantJsPlugin$6(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString) {}
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 2);
      this.this$0.callJs(this.val$callbackId + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantJsPlugin", 2, "changeFace cancel failed: " + localJSONException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */