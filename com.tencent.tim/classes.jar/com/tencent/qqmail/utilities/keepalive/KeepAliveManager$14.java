package com.tencent.qqmail.utilities.keepalive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.utilities.log.QMLog;

final class KeepAliveManager$14
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QMLog.log(4, "KeepAliveManager", "notification guide dismiss");
    KeepAliveManager.access$102(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.14
 * JD-Core Version:    0.7.0.1
 */