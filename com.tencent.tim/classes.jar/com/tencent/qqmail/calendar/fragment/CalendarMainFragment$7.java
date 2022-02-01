package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLogStream;

class CalendarMainFragment$7
  implements QMUIDialogAction.ActionListener
{
  CalendarMainFragment$7(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLogStream.logWithoutUma(-40033, "cancel", "Install_Calendar_App");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.7
 * JD-Core Version:    0.7.0.1
 */