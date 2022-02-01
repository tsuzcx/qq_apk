package com.tencent.qqmail.uma;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdRegisterRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.Hex;
import java.security.MessageDigest;
import rx.functions.Action1;

class QMUmaManager$1
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$1(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      CmdRegisterRsp localCmdRegisterRsp = new CmdRegisterRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      localCloudProtocolResult.uma_id_ = localCmdRegisterRsp.uma_id;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(localCmdRegisterRsp.uma_psw.getBytes());
      localCloudProtocolResult.psw_ = String.valueOf(Hex.encodeHex(localMessageDigest.digest()));
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdLstAccountRsp error: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.1
 * JD-Core Version:    0.7.0.1
 */