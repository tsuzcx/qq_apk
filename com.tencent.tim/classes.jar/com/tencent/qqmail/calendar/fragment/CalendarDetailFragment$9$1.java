package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

class CalendarDetailFragment$9$1
  implements QMUIDialogAction.ActionListener
{
  CalendarDetailFragment$9$1(CalendarDetailFragment.9 param9) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.eventCalendarDeleteCalendar(new double[0]);
    CalendarDetailFragment.access$1600(this.this$1.this$0);
    this.this$1.this$0.popBackStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.9.1
 * JD-Core Version:    0.7.0.1
 */