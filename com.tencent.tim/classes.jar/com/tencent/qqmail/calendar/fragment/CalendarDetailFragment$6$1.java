package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

class CalendarDetailFragment$6$1
  implements QMUIDialogAction.ActionListener
{
  CalendarDetailFragment$6$1(CalendarDetailFragment.6 param6, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.eventCalendarShareCalendarStop(new double[0]);
    CalendarDetailFragment.access$1200(this.this$1.this$0, this.val$itemIndex - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarDetailFragment.6.1
 * JD-Core Version:    0.7.0.1
 */