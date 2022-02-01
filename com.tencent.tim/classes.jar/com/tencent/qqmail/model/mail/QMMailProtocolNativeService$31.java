package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolNativeService$31
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$31(QMMailProtocolNativeService paramQMMailProtocolNativeService) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "addRule error code:" + paramProtocolResult.error_code_);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.31
 * JD-Core Version:    0.7.0.1
 */