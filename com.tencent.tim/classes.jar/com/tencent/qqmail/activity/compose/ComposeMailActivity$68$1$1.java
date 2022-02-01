package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog.SendVeifyCallBack;
import com.tencent.qqmail.utilities.log.QMLog;

class ComposeMailActivity$68$1$1
  implements QMVerifyImageDialog.SendVeifyCallBack
{
  ComposeMailActivity$68$1$1(ComposeMailActivity.68.1 param1) {}
  
  public void sendWithVerify(QMVerify paramQMVerify)
  {
    QMLog.log(6, "ComposeMailActivity", "sendWithVerify  sendMailTask" + this.this$2.val$task.getId() + " " + this.this$2.val$task.getVerifyKey() + " verify.getVerifyKey() " + paramQMVerify.getVerifyKey());
    this.this$2.val$task.setVerify(paramQMVerify);
    ComposeMailActivity.access$8100(this.this$2.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.68.1.1
 * JD-Core Version:    0.7.0.1
 */