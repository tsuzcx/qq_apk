package com.tencent.qqmini.minigame.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.minigame.utils.GameLog;

class OpenDataJsPlugin$8$1
  implements DialogInterface.OnClickListener
{
  OpenDataJsPlugin$8$1(OpenDataJsPlugin.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      OpenDataJsPlugin.access$500(this.this$1.this$0, this.this$1.val$toUser, this.this$1.val$nick, this.this$1.val$title, this.this$1.val$imageUrl, this.this$1.val$imageUrlId, this.this$1.val$req);
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE  share error " + paramDialogInterface.getMessage());
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE   share error " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */