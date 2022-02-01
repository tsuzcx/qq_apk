package com.tencent.qqmail.model.readmail;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class ReadMailHelper$1
  implements QMUIDialogAction.ActionListener
{
  ReadMailHelper$1(ReadMailHelper.AfterValidateMail paramAfterValidateMail) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    DataCollector.logEvent("Event_Continue_Re_Edit_Sepcpy");
    paramQMUIDialog.dismiss();
    this.val$afterValidateMail.action();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.readmail.ReadMailHelper.1
 * JD-Core Version:    0.7.0.1
 */