package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadMailFragment$88
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$88(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    DataCollector.logEvent("Event_Translate_Author_Dialog_OK");
    QMSettingManager.sharedInstance().setIsShowTranslateProtocolMailTips(false);
    paramQMUIDialog.dismiss();
    ReadMailFragment.access$14300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.88
 * JD-Core Version:    0.7.0.1
 */