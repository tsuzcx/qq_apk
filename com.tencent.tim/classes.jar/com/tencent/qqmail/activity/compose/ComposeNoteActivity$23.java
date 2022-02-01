package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Queue;

class ComposeNoteActivity$23
  implements QMUIDialogAction.ActionListener
{
  ComposeNoteActivity$23(ComposeNoteActivity paramComposeNoteActivity, boolean paramBoolean) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    QMLog.log(4, "ComposeNoteActivity", "leave without save, edit=" + this.val$edit);
    ComposeNoteActivity.access$1000(this.this$0).deleteComposeCache();
    if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0))
    {
      QMActivityManager.shareInstance().finishAllActivity();
      paramQMUIDialog = CalendarFragmentActivity.createIntentToReadSchedule(((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue());
      QMRemindererBroadcast.calendarRemindIdQueue.remove();
      QMRemindererBroadcast.calendarSubjectQueue.remove();
      this.this$0.startActivity(paramQMUIDialog);
      return;
    }
    ComposeNoteActivity.access$2900(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.23
 * JD-Core Version:    0.7.0.1
 */