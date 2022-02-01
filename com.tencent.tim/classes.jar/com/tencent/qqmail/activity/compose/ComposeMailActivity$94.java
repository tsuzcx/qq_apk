package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.utilities.ui.QMTips;

class ComposeMailActivity$94
  implements Runnable
{
  ComposeMailActivity$94(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    ComposeMailActivity.access$10000(this.this$0).showSuccess(this.this$0.getString(2131696469));
    QMTaskManager localQMTaskManager = QMTaskManager.sharedInstance(1);
    if ((ComposeMailActivity.access$5900(this.this$0) != 0) && ((QMSendMailTask)localQMTaskManager.getTaskById(ComposeMailActivity.access$5900(this.this$0)) != null)) {
      QMTaskManager.sharedInstance(1).delete(ComposeMailActivity.access$5900(this.this$0));
    }
    ComposeMailActivity.access$4402(this.this$0, ComposeMailActivity.SendMailStatus.SENDSUCC);
    ComposeMailActivity.access$302(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.94
 * JD-Core Version:    0.7.0.1
 */