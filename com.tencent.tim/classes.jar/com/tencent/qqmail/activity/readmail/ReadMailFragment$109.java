package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;

class ReadMailFragment$109
  implements Runnable
{
  ReadMailFragment$109(ReadMailFragment paramReadMailFragment, QMTaskManager paramQMTaskManager, QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    if (this.val$taskMgr != null) {
      this.val$taskMgr.addToMainLoop(this.val$task);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.109
 * JD-Core Version:    0.7.0.1
 */