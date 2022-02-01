package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog;

class ComposeMailActivity$68$1
  implements Runnable
{
  ComposeMailActivity$68$1(ComposeMailActivity.68 param68, String paramString1, String paramString2, String paramString3, String paramString4, QMTask paramQMTask, int paramInt, QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    QMVerify localQMVerify = new QMVerify();
    localQMVerify.setImageUrl(this.val$imgUrl);
    localQMVerify.setVerifyKey(this.val$verifyKey);
    localQMVerify.setVerifySession(this.val$verifySession);
    localQMVerify.setAuthImagesId(this.val$authImagesId);
    if (ComposeMailActivity.access$8000(this.this$1.this$0) == null) {
      ComposeMailActivity.access$8002(this.this$1.this$0, new QMVerifyImageDialog(this.this$1.this$0.getActivity(), this.val$finalTask.getAccountId(), this.val$verifyId));
    }
    ComposeMailActivity.access$8000(this.this$1.this$0).fetchVerifyImage(this.val$finalTask.getAccountId(), localQMVerify, 0, new ComposeMailActivity.68.1.1(this), new ComposeMailActivity.68.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.68.1
 * JD-Core Version:    0.7.0.1
 */