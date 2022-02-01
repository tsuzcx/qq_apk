package com.tencent.qqmail.utilities.keepalive;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

final class KeepAliveManager$12
  implements QMUIDialogAction.ActionListener
{
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(5, "KeepAliveManager", "no show guide again!");
    KvHelper.notificationGuideClickIgnore(new double[0]);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.12
 * JD-Core Version:    0.7.0.1
 */