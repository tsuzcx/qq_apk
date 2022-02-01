package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.CreateRuleCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolJavaService$34
  implements CreateRuleCallback
{
  QMMailProtocolJavaService$34(QMMailProtocolJavaService paramQMMailProtocolJavaService) {}
  
  public void onError()
  {
    QMLog.log(6, "QMMailProtocolJavaService", "add Rule error");
  }
  
  public void onSuccess()
  {
    QMLog.log(4, "QMMailProtocolJavaService", "add Rule success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.34
 * JD-Core Version:    0.7.0.1
 */