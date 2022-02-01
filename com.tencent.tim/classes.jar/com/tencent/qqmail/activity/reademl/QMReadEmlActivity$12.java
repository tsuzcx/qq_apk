package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.model.mail.QMMailManager;

class QMReadEmlActivity$12
  implements Runnable
{
  QMReadEmlActivity$12(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().loadMailFromEml(QMReadEmlActivity.access$3200(this.this$0), QMReadEmlActivity.access$3300(this.this$0).getBelongMailId(), QMReadEmlActivity.access$3400(this.this$0), QMReadEmlActivity.access$3500(this.this$0), QMReadEmlActivity.access$3600(this.this$0), QMReadEmlActivity.access$3700(this.this$0), QMReadEmlActivity.access$3300(this.this$0).getPreview().getMyDisk());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.12
 * JD-Core Version:    0.7.0.1
 */