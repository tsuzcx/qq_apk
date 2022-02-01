package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class InternalJSPlugin$9$2
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$9$2(InternalJSPlugin.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.e("InternalJSPlugin", "cancel");
    this.this$1.val$req.fail("click cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.9.2
 * JD-Core Version:    0.7.0.1
 */