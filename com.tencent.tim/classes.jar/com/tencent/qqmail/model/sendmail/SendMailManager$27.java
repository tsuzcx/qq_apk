package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class SendMailManager$27
  implements QMCallback.ISuccessCallback
{
  SendMailManager$27(SendMailManager paramSendMailManager, int paramInt, QMCallback paramQMCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    SendMailManager.access$1200(this.this$0).deleteTasksAttachByTaskId(this.val$taskId);
    SendMailManager.access$1200(this.this$0).deleteTasksFtnByTaskId(this.val$taskId);
    if (this.val$qmcallback != null) {
      this.val$qmcallback.handleSuccess(paramQMNetworkRequest, paramQMNetworkResponse);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.27
 * JD-Core Version:    0.7.0.1
 */