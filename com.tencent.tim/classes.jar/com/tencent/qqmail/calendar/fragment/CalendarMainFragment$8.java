package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import rx.Observable;

class CalendarMainFragment$8
  implements QMUIDialogAction.ActionListener
{
  CalendarMainFragment$8(CalendarMainFragment paramCalendarMainFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    RxPermissions.getInstance(this.this$0.getActivity()).request(new String[] { "android.permission.WRITE_CALENDAR" }).subscribe(new CalendarMainFragment.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarMainFragment.8
 * JD-Core Version:    0.7.0.1
 */