package com.tencent.qqmail.utilities.keepalive;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import moai.oss.KvHelper;

final class KeepAliveManager$5
  implements QMUIDialogAction.ActionListener
{
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLog.log(4, "KeepAliveManager", "active MasterSync and AutoSync: " + QMSyncAdapterManager.isMasterSyncAutomatically() + ", " + QMSyncAdapterManager.isSyncAutomatically());
    KvHelper.guideClickOnSync(new double[0]);
    if (KeepAliveManager.Hints.OTHER_SYNC.r != null) {
      KeepAliveManager.Hints.OTHER_SYNC.r.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.5
 * JD-Core Version:    0.7.0.1
 */