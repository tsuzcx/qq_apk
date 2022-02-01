package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class BaseActivityImpl$31
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$31(BaseActivityImpl paramBaseActivityImpl, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    BaseActivityImpl.access$1702(this.this$0, true);
    QMSettingManager.sharedInstance().setOnlyPushMailApp(this.val$accountId, true);
    QMMailManager.sharedInstance().setOnlyPushMailApp(this.val$accountId, true);
    BaseActivityImpl.access$900(this.this$0).dismiss();
    DataCollector.logEvent("Event_Click_Only_Push_Mail_App");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.31
 * JD-Core Version:    0.7.0.1
 */