package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$29
  implements AttachmentCallBack
{
  QMMailProtocolJavaService$29(QMMailProtocolJavaService paramQMMailProtocolJavaService, String paramString1, boolean paramBoolean, long paramLong, Attachment paramAttachment, LoadMailAttachCallBack paramLoadMailAttachCallBack, String paramString2) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "tmp file:" + this.val$tmpPath + " decode to:" + this.val$path + " fail");
    paramString = new QMProtocolError(5);
    if (this.val$callback != null) {
      this.val$callback.onError(paramString);
    }
  }
  
  public boolean onProgress(long paramLong)
  {
    return false;
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "tmp file:" + this.val$tmpPath + " decode to:" + paramString + " success");
    if (this.val$shouldUpdateInfo) {
      QMAttachManager.sharedInstance().updateAttachDisk(this.val$attachId, this.val$attachment.getName(), paramString, paramString, 0);
    }
    Attach localAttach = QMAttachManager.sharedInstance().getAttach(this.val$attachId);
    if (this.val$callback != null) {
      this.val$callback.onSuccess(paramString, localAttach);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.29
 * JD-Core Version:    0.7.0.1
 */