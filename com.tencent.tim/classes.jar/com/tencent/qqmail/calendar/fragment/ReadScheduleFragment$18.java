package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ReadScheduleFragment$18
  implements QMUIDialogAction.ActionListener
{
  ReadScheduleFragment$18(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMCalendarManager.getInstance();
    ReadScheduleFragment.access$1100(this.this$0, ReadScheduleFragment.access$100(this.this$0), 0, ReadScheduleFragment.access$000(this.this$0));
    QMCalendarManager.logEvent("Event_Calendar_Delete_Event");
    this.this$0.finish();
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.18
 * JD-Core Version:    0.7.0.1
 */