package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadMailFragment$153
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$153(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = SettingCalendarActivity.createIntent();
    this.this$0.startActivity(paramQMUIDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.153
 * JD-Core Version:    0.7.0.1
 */