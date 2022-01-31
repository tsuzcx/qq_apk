package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AvatarPendantJsPlugin$2
  implements DialogInterface.OnClickListener
{
  AvatarPendantJsPlugin$2(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 1);
      this.this$0.callJs(this.val$callbackId + "(" + paramDialogInterface.toString() + ");");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "showMsgBox failed: " + paramDialogInterface.getMessage());
      }
      this.this$0.callJsOnError(this.val$callbackId, paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */