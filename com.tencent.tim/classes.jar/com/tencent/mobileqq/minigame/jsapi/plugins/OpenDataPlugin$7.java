package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;

class OpenDataPlugin$7
  implements DialogInterface.OnCancelListener
{
  OpenDataPlugin$7(OpenDataPlugin paramOpenDataPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, "cancel", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.7
 * JD-Core Version:    0.7.0.1
 */