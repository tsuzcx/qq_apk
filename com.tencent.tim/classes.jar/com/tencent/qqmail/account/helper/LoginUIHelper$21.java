package com.tencent.qqmail.account.helper;

import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.ConfirmMessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.osslog.QMOssClient;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;

final class LoginUIHelper$21
  implements QMUIDialogAction.ActionListener
{
  LoginUIHelper$21(QMUIDialog.ConfirmMessageDialogBuilder paramConfirmMessageDialogBuilder) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMActivityManager.shareInstance().finishAllActivity();
    boolean bool = this.val$builder.isChecked();
    DataCollector.logEvent("Event_Click_Exit");
    StringBuilder localStringBuilder;
    if (bool)
    {
      paramQMUIDialog = "exitWithPush";
      QMLogStream.logWithoutUma(-40007, paramQMUIDialog, "Event_Click_Exit");
      QMLogStream.submitLog(true, true);
      AddAccountLocalLogUtil.timeLineAccountChange("OTHER", "user exit app. keep push:" + bool);
      if (!bool)
      {
        QMSyncAdapterManager.setAutoSync(false);
        QMSyncAdapterManager.removeJobScheduler();
        QMServiceManager.stopPushService();
        QMPushManager.unregister(false);
      }
      localStringBuilder = new StringBuilder().append("exit app");
      if (!bool) {
        break label155;
      }
    }
    label155:
    for (paramQMUIDialog = " with push";; paramQMUIDialog = "")
    {
      QMLog.log(4, "LoginUIHelper", paramQMUIDialog);
      QMLog.flush();
      QMOssClient.getInstance().flush();
      DataCollector.flush();
      Threads.runInBackground(new LoginUIHelper.21.1(this, bool), 3000L);
      return;
      paramQMUIDialog = "exit";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.21
 * JD-Core Version:    0.7.0.1
 */