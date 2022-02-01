package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;

class ComposeMailActivity$79
  implements Runnable
{
  ComposeMailActivity$79(ComposeMailActivity paramComposeMailActivity, QMTaskManager paramQMTaskManager, QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    this.val$sendCardMgr.addToMainLoop(this.val$cardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.79
 * JD-Core Version:    0.7.0.1
 */