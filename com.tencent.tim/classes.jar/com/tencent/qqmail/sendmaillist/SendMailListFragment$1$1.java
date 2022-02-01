package com.tencent.qqmail.sendmaillist;

import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog;

class SendMailListFragment$1$1
  implements Runnable
{
  SendMailListFragment$1$1(SendMailListFragment.1 param1, String paramString1, String paramString2, String paramString3, String paramString4, QMTask paramQMTask, int paramInt) {}
  
  public void run()
  {
    QMVerify localQMVerify = new QMVerify();
    localQMVerify.setImageUrl(this.val$imgUrl);
    localQMVerify.setVerifyKey(this.val$verifyKey);
    localQMVerify.setVerifySession(this.val$verifySession);
    localQMVerify.setAuthImagesId(this.val$authImagesId);
    if (SendMailListFragment.access$200(this.this$1.this$0) == null) {
      SendMailListFragment.access$202(this.this$1.this$0, new QMVerifyImageDialog(this.this$1.this$0.getActivity(), this.val$finalTask.getAccountId(), this.val$verifyId));
    }
    SendMailListFragment.access$200(this.this$1.this$0).fetchVerifyImage(this.val$finalTask.getAccountId(), localQMVerify, 0, new SendMailListFragment.1.1.1(this), new SendMailListFragment.1.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.1.1
 * JD-Core Version:    0.7.0.1
 */