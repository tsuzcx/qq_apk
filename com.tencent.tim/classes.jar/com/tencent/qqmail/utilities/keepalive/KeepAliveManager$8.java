package com.tencent.qqmail.utilities.keepalive;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

final class KeepAliveManager$8
  implements QMUIDialogAction.ActionListener
{
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLog.log(4, "KeepAliveManager", "I know!");
    KvHelper.guideClickOk(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.8
 * JD-Core Version:    0.7.0.1
 */