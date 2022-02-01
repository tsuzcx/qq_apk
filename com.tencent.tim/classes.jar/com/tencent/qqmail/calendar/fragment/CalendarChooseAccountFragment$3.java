package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class CalendarChooseAccountFragment$3
  implements QMUIDialogAction.ActionListener
{
  CalendarChooseAccountFragment$3(CalendarChooseAccountFragment paramCalendarChooseAccountFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    CalendarChooseAccountFragment.access$302(this.this$0, false);
    paramQMUIDialog.dismiss();
    paramQMUIDialog = SettingCalendarActivity.createIntent();
    this.this$0.startActivity(paramQMUIDialog);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarChooseAccountFragment.3
 * JD-Core Version:    0.7.0.1
 */