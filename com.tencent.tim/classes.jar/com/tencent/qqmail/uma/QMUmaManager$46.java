package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdDataReportRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import rx.functions.Action1;

class QMUmaManager$46
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$46(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      new CmdDataReportRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.error_code_ = 0;
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general result.get_cards_rsp_ error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.46
 * JD-Core Version:    0.7.0.1
 */