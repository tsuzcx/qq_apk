package com.tencent.qqmail.utilities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.view.KeyEvent;

class QMUpdateUtil$4
  implements DialogInterface.OnKeyListener
{
  QMUpdateUtil$4(QMUpdateUtil paramQMUpdateUtil, int paramInt, Context paramContext) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (QMUpdateUtil.access$300(this.this$0, this.val$forceType))
    {
      paramDialogInterface = new Intent("android.intent.action.MAIN");
      paramDialogInterface.setFlags(67108864);
      paramDialogInterface.addCategory("android.intent.category.HOME");
      paramDialogInterface.setFlags(268435456);
      this.val$context.startActivity(paramDialogInterface);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUpdateUtil.4
 * JD-Core Version:    0.7.0.1
 */