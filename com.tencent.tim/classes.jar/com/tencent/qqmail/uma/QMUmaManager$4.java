package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.CmdLogoutRsp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.IOException;
import moai.io.Files;
import rx.functions.Action1;

class QMUmaManager$4
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$4(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    localCloudProtocolResult = new CloudProtocolResult();
    try
    {
      new CmdLogoutRsp().parseFrom(paramQMUmaResult.decryptedPkg);
      QMUmaManager.access$102(this.this$0, null);
      if (QMUmaManager.access$300(this.this$0) != null) {
        Files.delFile(QMUmaManager.access$300(this.this$0));
      }
      Log.d("terrytan", QMUmaManager.access$200(this.this$0) + "uma logout clear sessionKey");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localCloudProtocolResult.error_code_ = -1;
        QMLog.log(5, "QMUmaManager", "general CmdLstAccountRsp error: " + localIOException.getMessage());
      }
    }
    paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.4
 * JD-Core Version:    0.7.0.1
 */