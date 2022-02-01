package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.util.log.LoggerDelegate;
import com.tencent.qqmail.utilities.log.ProtocolLog;
import moai.oss.OssHelper;

class QMMailProtocolJavaService$1
  implements LoggerDelegate
{
  QMMailProtocolJavaService$1(QMMailProtocolJavaService paramQMMailProtocolJavaService) {}
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    ProtocolLog.log(paramInt, paramString1, paramString2);
  }
  
  public void ossLog(Object... paramVarArgs)
  {
    OssHelper.protocolOsslog(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.1
 * JD-Core Version:    0.7.0.1
 */