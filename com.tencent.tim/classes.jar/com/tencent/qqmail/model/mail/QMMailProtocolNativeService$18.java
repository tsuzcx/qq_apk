package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$18
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$18(QMMailProtocolNativeService paramQMMailProtocolNativeService, MailManagerDelegate paramMailManagerDelegate, Profile paramProfile, int paramInt) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    QMLog.log(6, "QMMailProtocolNativeService", "moveMail result: " + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(null, null);
      }
      if (this.val$callback != null) {
        this.val$callback.handleComplete(null);
      }
      if (this.val$profile.protocolType == 4) {
        this.this$0.saveActiveSync(this.val$accountId, paramProtocolResult);
      }
    }
    while (paramProtocolResult.error_code_ == 0)
    {
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "moveMails", true);
      return;
      QMProtocolError localQMProtocolError;
      if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "moveMail auth error : " + this.val$accountId);
        PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
        localQMProtocolError = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.handleError(localQMProtocolError);
        }
        if (this.val$callback != null) {
          this.val$callback.handleComplete(null);
        }
      }
      else
      {
        QMLog.log(6, "QMMailProtocolNativeService", "moveMail error : " + paramProtocolResult.error_code_);
        localQMProtocolError = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.handleError(localQMProtocolError);
        }
        if (this.val$callback != null) {
          this.val$callback.handleComplete(null);
        }
      }
    }
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "moveMails", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.18
 * JD-Core Version:    0.7.0.1
 */