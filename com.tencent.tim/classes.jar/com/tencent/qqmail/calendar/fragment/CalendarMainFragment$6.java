package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;

class CalendarMainFragment$6
  implements QMUIDialogAction.ActionListener
{
  CalendarMainFragment$6(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLogStream.logWithoutUma(-40033, "ok", "Install_Calendar_App");
    ShortcutUtility.addApplicationShortcut(this.this$0.getString(2131690401), 2130839106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.6
 * JD-Core Version:    0.7.0.1
 */