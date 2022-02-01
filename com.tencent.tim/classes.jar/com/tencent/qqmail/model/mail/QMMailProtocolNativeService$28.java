package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$28
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$28(QMMailProtocolNativeService paramQMMailProtocolNativeService, LoadMailAbstractCallback paramLoadMailAbstractCallback, int paramInt, Account paramAccount, QMFolder paramQMFolder, Profile paramProfile) {}
  
  public void onDownloadText(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    QMLog.log(5, "QMMailProtocolNativeService", "downloadMailAbstract result : " + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      if (this.val$callback != null) {
        this.val$callback.loadAbstractSuccess(paramMail.mailId, paramMail.mailAdType, paramMail.abstract_mail);
      }
      switch (this.val$protoType)
      {
      }
    }
    while (paramProtocolResult.error_code_ == 0)
    {
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "downloadMailAbstract", true);
      return;
      this.this$0.saveActiveSync(paramMail.accountId, paramProtocolResult);
      continue;
      if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(5, "QMMailProtocolNativeService", "downloadMailAbstract auth err : " + this.val$account.getId());
        PasswordErrHandler.saveStateAndShowErr(this.val$folder.getAccountId(), -1);
      }
      else
      {
        QMLog.log(5, "QMMailProtocolNativeService", "downloadMailAbstract err : " + this.val$account.getId());
        QMProtocolError localQMProtocolError = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.loadAbstractError(paramMail.mailId, localQMProtocolError);
        }
      }
    }
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "downloadMailAbstract", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.28
 * JD-Core Version:    0.7.0.1
 */