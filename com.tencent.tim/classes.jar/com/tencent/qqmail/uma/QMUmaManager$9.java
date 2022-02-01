package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdLstAccountRsp;
import com.tencent.qqmail.protocol.UMA.EmailAccountInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$9
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$9(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      CmdLstAccountRsp localCmdLstAccountRsp = new CmdLstAccountRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.error_code_ = 0;
      localCloudProtocolResult.account_list_ = ((EmailAccountInfo[])new LinkedList().toArray(new EmailAccountInfo[0]));
      localCloudProtocolResult.account_list_ = ((EmailAccountInfo[])localCmdLstAccountRsp.account_info.toArray(new EmailAccountInfo[localCmdLstAccountRsp.account_info.size()]));
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdLstAccountRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.9
 * JD-Core Version:    0.7.0.1
 */