package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$30
  implements AttachmentCallBack
{
  QMMailProtocolJavaService$30(QMMailProtocolJavaService paramQMMailProtocolJavaService, Attachment paramAttachment, LoadMailAttachCallBack paramLoadMailAttachCallBack, boolean paramBoolean, long paramLong, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, int paramInt, Attach paramAttach, String paramString) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "downloadAttach error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    }
    for (;;)
    {
      if (this.val$callback != null)
      {
        QMProtocolError localQMProtocolError = new QMProtocolError(i);
        this.val$callback.onError(localQMProtocolError);
      }
      QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "downloadAttach", paramInt2, paramString);
      return;
      if ((paramInt1 == 3) && (paramInt2 == 200003))
      {
        QMLog.log(5, "QMMailProtocolJavaService", "downloadAttach file decode err:" + paramString);
        if ((this.val$shouldUpdateInfo) && (this.val$attach.getProtocol().getProtocolType() == 1) && (this.val$attachment.getImapBodyStructure() != null)) {
          QMAttachManager.sharedInstance().updateAttachDisk(this.val$attachId, this.val$attachment.getName(), "", FileUtility.generateTmpFilePath(this.val$remoteId, this.val$attachment.getImapBodyStructure().getBodyId()), 0);
        }
      }
      else
      {
        QMLog.log(5, "QMMailProtocolJavaService", "downloadAttach err : " + this.val$accountId + ", err:" + paramString);
      }
    }
  }
  
  public boolean onProgress(long paramLong)
  {
    long l = this.val$attachment.getSize();
    if (this.val$callback != null) {
      return this.val$callback.onProgress(paramLong, l);
    }
    return false;
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "downloadAttach success:" + paramString);
    if (this.val$shouldUpdateInfo) {
      QMAttachManager.sharedInstance().updateAttachDisk(this.val$attachId, this.val$attachment.getName(), paramString, paramString, 0);
    }
    Attach localAttach = QMAttachManager.sharedInstance().getAttach(this.val$attachId);
    if (this.val$callback != null) {
      this.val$callback.onSuccess(paramString, localAttach);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "downloadAttach");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.30
 * JD-Core Version:    0.7.0.1
 */