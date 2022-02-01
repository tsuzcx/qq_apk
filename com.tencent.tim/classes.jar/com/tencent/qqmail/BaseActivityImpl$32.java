package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$32
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$32(BaseActivityImpl paramBaseActivityImpl, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    BaseActivityImpl.access$1702(this.this$0, true);
    QMLog.log(4, "BaseActivityImpl", "cancel close qqwx:" + this.val$accountId);
    QMSettingManager.sharedInstance().setOnlyPushMailApp(this.val$accountId, false);
    QMMailManager.sharedInstance().setOnlyPushMailApp(this.val$accountId, false);
    BaseActivityImpl.access$900(this.this$0).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.32
 * JD-Core Version:    0.7.0.1
 */