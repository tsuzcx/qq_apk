package com.tencent.mobileqq.vaswebviewplugin;

import affz;
import afjy;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.emosm.Client.b;

class EmojiJsPlugin$5
  implements DialogInterface.OnClickListener
{
  EmojiJsPlugin$5(EmojiJsPlugin paramEmojiJsPlugin, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putInt("id", this.val$emoPackId);
    paramDialogInterface.putInt("businessType", this.val$businessType);
    paramDialogInterface.putInt("sceneType", this.val$sceneType);
    paramDialogInterface = affz.a("startDownloadEmoji", this.val$callbackid, this.this$0.mOnRemoteResp.key, paramDialogInterface);
    this.this$0.addDownloadingStateObserver(new Pair(Integer.valueOf(this.val$emoPackId), this.val$callbackid));
    afjy.a().cr(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */