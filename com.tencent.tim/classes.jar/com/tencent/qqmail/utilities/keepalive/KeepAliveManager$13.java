package com.tencent.qqmail.utilities.keepalive;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

final class KeepAliveManager$13
  implements QMUIDialogAction.ActionListener
{
  KeepAliveManager$13(Activity paramActivity, KeepAliveManager.Hints paramHints) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "KeepAliveManager", "go to setting, app managerment");
    paramQMUIDialog.dismiss();
    KvHelper.notificationGuideClickGoSetting(new double[0]);
    try
    {
      this.val$context.startActivity(this.val$h.intent.addFlags(268435456));
      return;
    }
    catch (Throwable paramQMUIDialog)
    {
      OssHelper.guideGoSettingFailed(new Object[] { "ntc", this.val$h.toString(), paramQMUIDialog.toString() });
      QMLog.log(5, "KeepAliveManager", "start setting activity failed", paramQMUIDialog);
      try
      {
        this.val$context.startActivity(KeepAliveManager.Hints.OTHER_NTC.intent.addFlags(268435456));
        return;
      }
      catch (Throwable paramQMUIDialog) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.13
 * JD-Core Version:    0.7.0.1
 */