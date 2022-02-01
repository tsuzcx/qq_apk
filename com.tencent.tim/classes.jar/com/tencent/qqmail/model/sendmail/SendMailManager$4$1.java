package com.tencent.qqmail.model.sendmail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.SendDataCallback;

class SendMailManager$4$1
  implements MailManagerDelegate.SendDataCallback
{
  SendMailManager$4$1(SendMailManager.4 param4) {}
  
  public void run(Long paramLong1, Long paramLong2)
  {
    this.this$1.val$newCallback.handleSendData(Long.valueOf(paramLong1.longValue() + this.this$1.val$binaryFilesData.getBytesAttachNeedFtnUpload()), Long.valueOf(paramLong2.longValue() + this.this$1.val$binaryFilesData.getBytesAttachNeedFtnUpload()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.4.1
 * JD-Core Version:    0.7.0.1
 */