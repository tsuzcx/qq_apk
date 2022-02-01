package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.MailAttachment;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMMailProtocolNativeService$29
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$29(QMMailProtocolNativeService paramQMMailProtocolNativeService, LoadMailAttachCallBack paramLoadMailAttachCallBack, boolean paramBoolean1, String paramString, Attach paramAttach, boolean paramBoolean2, long paramLong, Profile paramProfile, int paramInt) {}
  
  public void onDownload(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "downloadAttach error code:" + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      Object localObject = paramMail.attachment_set_[0].url_;
      String str;
      if (this.val$isInline)
      {
        str = QMMailProtocolNativeService.access$600(this.this$0, (String)localObject, FileUtil.getThumbImageCacheDir(), StringExtention.hashKeyForDisk(this.val$cid), true);
        localObject = str;
      }
      for (;;)
      {
        if (this.val$shouldUpdateInfo) {
          QMAttachManager.sharedInstance().updateAttachDisk(this.val$attachId, paramMail.attachment_set_[0].file_name_, str, (String)localObject, 0);
        }
        if (!StringExtention.isNullOrEmpty(str)) {
          break;
        }
        paramMail = new QMProtocolError(5);
        if (this.val$callback != null) {
          this.val$callback.onError(paramMail);
        }
        return;
        str = this.val$attach.getPreview().getMyDisk();
        if ((StringExtention.isNullOrEmpty(str)) || (!this.val$shouldUpdateInfo)) {
          str = FileUtil.getAttachDownloadDir();
        }
        str = QMMailProtocolNativeService.access$600(this.this$0, (String)localObject, str, paramMail.attachment_set_[0].file_name_, false);
      }
      localObject = QMAttachManager.sharedInstance().getAttach(this.val$attachId);
      if (this.val$callback != null) {
        this.val$callback.onSuccess(str, (Attach)localObject);
      }
      if (this.val$profile.protocolType == 4) {
        this.this$0.saveActiveSync(this.val$accountId, paramProtocolResult);
      }
      QMLog.log(4, "QMMailProtocolNativeService", "downloadAttach success name: " + paramMail.attachment_set_[0].file_name_ + " size: " + paramMail.attachment_set_[0].file_size_ + " path: " + str);
    }
    while (paramProtocolResult.error_code_ == 0)
    {
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "downloadAttach", true);
      return;
      if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "downloadAttach auth error : " + this.val$accountId);
        PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
        paramMail = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.onError(paramMail);
        }
      }
      else
      {
        QMLog.log(6, "QMMailProtocolNativeService", "downloadAttach error");
        paramMail = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.onError(paramMail);
        }
      }
    }
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "downloadAttach", false);
  }
  
  public boolean onDownloadProgress(Mail paramMail, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    long l = paramMail.attachment_set_[0].file_size_;
    if (this.val$callback != null) {
      bool = this.val$callback.onProgress(paramInt, l);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.29
 * JD-Core Version:    0.7.0.1
 */