package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.protocol.Mail;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;

class QMMailProtocolNativeService$23
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$23(QMMailProtocolNativeService paramQMMailProtocolNativeService, QMGeneralCallback paramQMGeneralCallback) {}
  
  public void onSendMail(Mail paramMail, ProtocolResult paramProtocolResult)
  {
    if (paramProtocolResult.error_code_ == 0)
    {
      QMLog.log(4, "QMMailProtocolNativeService", "sendMail debuglog on success:" + paramProtocolResult.error_code_);
      if (this.val$callback != null) {
        this.val$callback.onSuccess();
      }
    }
    do
    {
      return;
      QMLog.log(6, "QMMailProtocolNativeService", "sendMail debuglog on error" + paramProtocolResult.error_code_);
    } while (this.val$callback == null);
    this.val$callback.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.23
 * JD-Core Version:    0.7.0.1
 */