package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$6$1$2
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$6$1$2(BaseActivityImpl.6.1 param1) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "BaseActivityImpl", "secapp. click do not alert");
    QMSettingManager.sharedInstance().setRemindSecApp();
    DataCollector.logEvent("Event_SecApp_Alert_Not");
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.6.1.2
 * JD-Core Version:    0.7.0.1
 */