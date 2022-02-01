package com.tencent.qqmail.model.readmail;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class ReadMailHelper$3
  implements QMUIDialogAction.ActionListener
{
  ReadMailHelper$3(ReadMailHelper.AfterValidateMail paramAfterValidateMail) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    DataCollector.logEvent("Event_Expire_Big_Attach_Forward_On_Alert");
    this.val$afterValidateMail.action();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.ReadMailHelper.3
 * JD-Core Version:    0.7.0.1
 */