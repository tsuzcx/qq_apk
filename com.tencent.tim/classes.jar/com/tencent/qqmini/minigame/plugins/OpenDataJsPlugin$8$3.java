package com.tencent.qqmini.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.minigame.utils.GameLog;

class OpenDataJsPlugin$8$3
  implements DialogInterface.OnCancelListener
{
  OpenDataJsPlugin$8$3(OpenDataJsPlugin.8 param8) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
    GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE share cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.8.3
 * JD-Core Version:    0.7.0.1
 */