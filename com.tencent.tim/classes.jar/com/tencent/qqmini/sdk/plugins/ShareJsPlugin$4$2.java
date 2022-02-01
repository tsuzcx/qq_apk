package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ShareJsPlugin$4$2
  implements DialogInterface.OnCancelListener
{
  ShareJsPlugin$4$2(ShareJsPlugin.4 param4) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.this$1.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.4.2
 * JD-Core Version:    0.7.0.1
 */