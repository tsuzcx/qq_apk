package com.tencent.qqmail.utilities.keepalive;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

final class KeepAliveManager$7
  implements QMUIDialogAction.ActionListener
{
  KeepAliveManager$7(KeepAliveManager.Hints paramHints, int paramInt, Activity paramActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLog.log(4, "KeepAliveManager", "go to setting, hints: " + this.val$h);
    KvHelper.guideClickGoSetting(new double[0]);
    OssHelper.guideClick(new Object[] { Integer.valueOf(this.val$reason), Integer.valueOf(1) });
    try
    {
      this.val$context.startActivity(this.val$h.intent.addFlags(268435456));
      return;
    }
    catch (Throwable paramQMUIDialog)
    {
      OssHelper.guideGoSettingFailed(new Object[] { "wl", this.val$h.toString(), paramQMUIDialog.toString() });
      QMLog.log(5, "KeepAliveManager", "start setting activity failed", paramQMUIDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keepalive.KeepAliveManager.7
 * JD-Core Version:    0.7.0.1
 */