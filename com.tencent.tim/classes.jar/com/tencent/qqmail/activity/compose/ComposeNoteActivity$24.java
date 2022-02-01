package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.Queue;

class ComposeNoteActivity$24
  implements QMUIDialogAction.ActionListener
{
  ComposeNoteActivity$24(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0))
    {
      QMRemindererBroadcast.calendarRemindIdQueue.remove();
      QMRemindererBroadcast.calendarSubjectQueue.remove();
      if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0)) {
        ComposeNoteActivity.access$3000(this.this$0, ((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue(), (String)QMRemindererBroadcast.calendarSubjectQueue.peek());
      }
    }
    ComposeNoteActivity.access$1400(this.this$0).focusEditor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.24
 * JD-Core Version:    0.7.0.1
 */