package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdDelEMailPhotoRsp;
import com.tencent.qqmail.protocol.UMA.DelEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$19
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$19(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      localCloudProtocolResult.error_code_ = 0;
      CmdDelEMailPhotoRsp localCmdDelEMailPhotoRsp = new CmdDelEMailPhotoRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.del_photo_rsp_list_ = ((DelEMailPhotoRspInfo[])localCmdDelEMailPhotoRsp.info.toArray(new DelEMailPhotoRspInfo[localCmdDelEMailPhotoRsp.info.size()]));
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdDelEMailPhotoRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.19
 * JD-Core Version:    0.7.0.1
 */