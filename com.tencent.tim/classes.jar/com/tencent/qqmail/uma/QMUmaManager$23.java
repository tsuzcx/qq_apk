package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeRsp;
import com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeRsp.EmailTypeInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import java.util.LinkedList;
import rx.functions.Action1;

class QMUmaManager$23
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$23(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      CmdQueryEmailTypeRsp localCmdQueryEmailTypeRsp = new CmdQueryEmailTypeRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.error_code_ = 0;
      localCloudProtocolResult.email_type_info_list_ = ((CmdQueryEmailTypeRsp.EmailTypeInfo[])localCmdQueryEmailTypeRsp.type_info.toArray(new CmdQueryEmailTypeRsp.EmailTypeInfo[localCmdQueryEmailTypeRsp.type_info.size()]));
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdQueryEmailTypeRsp error: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.23
 * JD-Core Version:    0.7.0.1
 */