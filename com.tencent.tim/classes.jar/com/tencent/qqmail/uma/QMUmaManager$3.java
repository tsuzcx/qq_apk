package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdLoginRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.Hex;
import java.io.IOException;
import moai.io.Files;
import rx.functions.Action1;

class QMUmaManager$3
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$3(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      Object localObject = new CmdLoginRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      QMUmaManager.access$102(this.this$0, ((CmdLoginRsp)localObject).uma_skey.getBytes());
      localCloudProtocolResult.session_key_hex_ = String.valueOf(Hex.encodeHex(QMUmaManager.access$100(this.this$0)));
      localCloudProtocolResult.debug_log_settiong_ = ((CmdLoginRsp)localObject).debug_log;
      localCloudProtocolResult.longconn_sig_ = ((CmdLoginRsp)localObject).longconn_sig;
      Log.d("terrytan", QMUmaManager.access$200(this.this$0) + "uma login suc:" + localCloudProtocolResult.session_key_hex_);
      if (QMUmaManager.access$300(this.this$0) != null)
      {
        localObject = localCloudProtocolResult.session_key_hex_.getBytes();
        Files.writeFile((byte[])localObject, localObject.length, QMUmaManager.access$300(this.this$0));
      }
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      if (QMUmaManager.access$000(this.this$0) != null) {
        QMUmaManager.access$000(this.this$0).onCloudResult(localCloudProtocolResult);
      }
      return;
    }
    catch (IOException paramQMUmaResult)
    {
      localCloudProtocolResult.error_code_ = -1;
      QMLog.log(5, "QMUmaManager", "general CmdLstAccountRsp error: " + paramQMUmaResult.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.3
 * JD-Core Version:    0.7.0.1
 */