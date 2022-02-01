package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ComposeMailActivity$68
  implements QMGetVerifyImageWatcher
{
  ComposeMailActivity$68(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError)
  {
    ComposeMailActivity.access$8300(this.this$0, new ComposeMailActivity.68.2(this));
  }
  
  public void onProcess(int paramInt, String paramString) {}
  
  public void onSuccess(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QMSendMailTask localQMSendMailTask = (QMSendMailTask)QMTaskManager.sharedInstance(1).getTaskById(ComposeMailActivity.access$5900(this.this$0));
    if ((localQMSendMailTask != null) && (paramInt == localQMSendMailTask.getId())) {
      ComposeMailActivity.access$8200(this.this$0, new ComposeMailActivity.68.1(this, paramString2, paramString1, paramString3, paramString4, localQMSendMailTask, paramInt, localQMSendMailTask));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.68
 * JD-Core Version:    0.7.0.1
 */