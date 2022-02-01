package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$22
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$22(QMMailProtocolNativeService paramQMMailProtocolNativeService, MailManagerDelegate paramMailManagerDelegate, Profile paramProfile) {}
  
  public void onBeforeSendMail(Mail paramMail)
  {
    super.onBeforeSendMail(paramMail);
  }
  
  public void onSendMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    FileUtil.delFile(paramMail.uploadFilePath);
    Profile localProfile;
    if (paramProtocolResult.error_code_ == 0)
    {
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(null, null);
      }
      paramMail = this.this$0;
      localProfile = this.val$profile;
      if (paramProtocolResult.error_code_ != 0) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QMMailProtocolNativeService.access$100(paramMail, localProfile, "append", bool);
      return;
      paramMail = new QMProtocolError(paramProtocolResult.error_code_);
      if (this.val$callback == null) {
        break;
      }
      this.val$callback.handleError(paramMail);
      break;
    }
  }
  
  public boolean onSendMailProgress(int paramInt1, int paramInt2)
  {
    return super.onSendMailProgress(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.22
 * JD-Core Version:    0.7.0.1
 */