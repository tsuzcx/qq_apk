package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;

class ComposeMailActivity$80
  implements Runnable
{
  ComposeMailActivity$80(ComposeMailActivity paramComposeMailActivity, QMTaskManager paramQMTaskManager, QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    this.val$sendMailMgr.addToMainLoop(this.val$finalTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.80
 * JD-Core Version:    0.7.0.1
 */