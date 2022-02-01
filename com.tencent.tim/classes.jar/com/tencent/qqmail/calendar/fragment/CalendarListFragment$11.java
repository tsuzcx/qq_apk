package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class CalendarListFragment$11
  implements QMUIDialogAction.ActionListener
{
  CalendarListFragment$11(CalendarListFragment paramCalendarListFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    paramQMUIDialog = SettingCalendarActivity.createIntent();
    this.this$0.startActivity(paramQMUIDialog);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment.11
 * JD-Core Version:    0.7.0.1
 */