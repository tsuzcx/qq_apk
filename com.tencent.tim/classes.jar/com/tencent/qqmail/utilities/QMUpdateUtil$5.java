package com.tencent.qqmail.utilities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.util.Log;
import moai.core.watcher.Watchers;

class QMUpdateUtil$5
  implements DialogInterface.OnDismissListener
{
  QMUpdateUtil$5(QMUpdateUtil paramQMUpdateUtil) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Log.e(QMUpdateUtil.access$000(), "dialog dismiss");
    Watchers.bind(QMUpdateUtil.access$500(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMUpdateUtil.5
 * JD-Core Version:    0.7.0.1
 */