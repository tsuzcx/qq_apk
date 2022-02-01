package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import java.util.Queue;

class ComposeMailActivity$30
  implements QMUIDialogAction.ActionListener
{
  ComposeMailActivity$30(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (ComposeMailActivity.access$3200(this.this$0) != null) {
      ComposeMailActivity.access$3200(this.this$0).findViewById(2131380046).setSelected(false);
    }
    if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0))
    {
      QMRemindererBroadcast.calendarRemindIdQueue.remove();
      QMRemindererBroadcast.calendarSubjectQueue.remove();
      if ((QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0)) {
        ComposeMailActivity.access$3400(this.this$0, ((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue(), (String)QMRemindererBroadcast.calendarSubjectQueue.peek());
      }
    }
    paramQMUIDialog.dismiss();
    this.this$0.composeView.focusAtEditor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.30
 * JD-Core Version:    0.7.0.1
 */