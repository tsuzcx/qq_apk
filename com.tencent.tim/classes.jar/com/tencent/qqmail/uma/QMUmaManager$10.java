package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdSetUserSettingRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import rx.functions.Action1;

class QMUmaManager$10
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$10(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      CmdSetUserSettingRsp localCmdSetUserSettingRsp = new CmdSetUserSettingRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.error_code_ = 0;
      localCloudProtocolResult.set_user_setting_rsp_version_ = localCmdSetUserSettingRsp.version;
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdSetUserSettingRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.10
 * JD-Core Version:    0.7.0.1
 */