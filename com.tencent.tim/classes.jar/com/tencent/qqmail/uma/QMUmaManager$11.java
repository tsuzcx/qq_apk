package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdGetUserSettingRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import rx.functions.Action1;

class QMUmaManager$11
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$11(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      CmdGetUserSettingRsp localCmdGetUserSettingRsp = new CmdGetUserSettingRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.error_code_ = 0;
      localCloudProtocolResult.user_setting_ = localCmdGetUserSettingRsp.setting;
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdGetUserSettingRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.11
 * JD-Core Version:    0.7.0.1
 */