package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdQueryDomainConfigRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import rx.functions.Action1;

class QMUmaManager$12
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$12(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      localCloudProtocolResult.error_code_ = 0;
      localCloudProtocolResult.query_domain_rsp_ = new CmdQueryDomainConfigRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general result.query_domain_rsp_ error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.12
 * JD-Core Version:    0.7.0.1
 */