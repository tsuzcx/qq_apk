package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Queue;

class ComposeMailActivity$32
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$32(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    QMLog.log(4, "ComposeMailActivity", "compose_unsave");
    paramQMUIDialog.dismiss();
    if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0))
    {
      QMActivityManager.shareInstance().finishAllActivity();
      paramQMUIDialog = CalendarFragmentActivity.createIntentToReadSchedule(((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue());
      QMRemindererBroadcast.calendarRemindIdQueue.remove();
      QMRemindererBroadcast.calendarSubjectQueue.remove();
      this.this$0.startActivity(paramQMUIDialog);
      return;
    }
    ComposeMailActivity.access$3300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.32
 * JD-Core Version:    0.7.0.1
 */