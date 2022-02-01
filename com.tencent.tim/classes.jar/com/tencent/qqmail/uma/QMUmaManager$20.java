package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdSyncEMailNicknameRsp;
import com.tencent.qqmail.protocol.UMA.SyncEMailNicknameRspInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$20
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$20(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      localCloudProtocolResult.error_code_ = 0;
      CmdSyncEMailNicknameRsp localCmdSyncEMailNicknameRsp = new CmdSyncEMailNicknameRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.sync_nick_list_ = ((SyncEMailNicknameRspInfo[])localCmdSyncEMailNicknameRsp.info.toArray(new SyncEMailNicknameRspInfo[localCmdSyncEMailNicknameRsp.info.size()]));
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdSyncEMailNicknameRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.20
 * JD-Core Version:    0.7.0.1
 */