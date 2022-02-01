package com.tencent.qqmini.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class OpenDataJsPlugin$10
  implements DialogInterface.OnCancelListener
{
  OpenDataJsPlugin$10(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE cancel");
    this.val$req.fail("cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */