package com.tencent.qqmail.calendar.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class EventChecker$EventTimeChecker$1
  implements QMUIDialogAction.ActionListener
{
  EventChecker$EventTimeChecker$1(EventChecker.EventTimeChecker paramEventTimeChecker, EventChecker.EventCheckerListener paramEventCheckerListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$listener.onCheckError();
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.EventChecker.EventTimeChecker.1
 * JD-Core Version:    0.7.0.1
 */