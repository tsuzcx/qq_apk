package com.tencent.qqmail;

import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.Queue;

class BaseActivityImpl$16
  implements QMUIDialogAction.ActionListener
{
  BaseActivityImpl$16(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0)
    {
      QMRemindererBroadcast.calendarRemindIdQueue.remove();
      QMRemindererBroadcast.calendarSubjectQueue.remove();
      if (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0) {
        this.this$0.myCalendarRemindDialog(((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue(), (String)QMRemindererBroadcast.calendarSubjectQueue.peek());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.16
 * JD-Core Version:    0.7.0.1
 */