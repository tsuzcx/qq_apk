package com.tencent.qqmail.utilities.keepalive;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

final class KeepAliveManager$4
  implements QMUIDialogAction.ActionListener
{
  KeepAliveManager$4(int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLog.log(5, "KeepAliveManager", "ignore guide!");
    KvHelper.guideClickIgnore(new double[0]);
    OssHelper.guideClick(new Object[] { Integer.valueOf(this.val$reason), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.4
 * JD-Core Version:    0.7.0.1
 */