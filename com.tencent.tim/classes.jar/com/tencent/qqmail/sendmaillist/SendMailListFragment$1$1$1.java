package com.tencent.qqmail.sendmaillist;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog.SendVeifyCallBack;
import com.tencent.qqmail.utilities.log.QMLog;

class SendMailListFragment$1$1$1
  implements QMVerifyImageDialog.SendVeifyCallBack
{
  SendMailListFragment$1$1$1(SendMailListFragment.1.1 param1) {}
  
  public void sendWithVerify(QMVerify paramQMVerify)
  {
    QMSendMailTask localQMSendMailTask = (QMSendMailTask)this.this$2.val$finalTask;
    QMLog.log(4, "SendMailListFragment", "sendWithVerify  sendMailTask" + localQMSendMailTask.getId() + " " + localQMSendMailTask.getVerifyKey() + " verify.getVerifyKey() " + paramQMVerify.getVerifyKey());
    localQMSendMailTask.setVerify(paramQMVerify);
    QMTaskManager.sharedInstance(1).restart(localQMSendMailTask.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */