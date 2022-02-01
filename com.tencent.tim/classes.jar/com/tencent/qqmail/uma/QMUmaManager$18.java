package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdSetEMailPhotoRsp;
import com.tencent.qqmail.protocol.UMA.SetEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$18
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$18(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      localCloudProtocolResult.error_code_ = 0;
      CmdSetEMailPhotoRsp localCmdSetEMailPhotoRsp = new CmdSetEMailPhotoRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.set_photo_rsp_list_ = ((SetEMailPhotoRspInfo[])localCmdSetEMailPhotoRsp.info.toArray(new SetEMailPhotoRspInfo[localCmdSetEMailPhotoRsp.info.size()]));
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdSetEMailPhotoRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.18
 * JD-Core Version:    0.7.0.1
 */