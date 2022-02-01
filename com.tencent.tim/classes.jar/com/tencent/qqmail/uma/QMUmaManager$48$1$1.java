package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.Hex;

class QMUmaManager$48$1$1
  extends SimpleOnProtocolListener
{
  QMUmaManager$48$1$1(QMUmaManager.48.1 param1) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ != 0)
    {
      this.this$2.this$1.val$session.callback.onCloudResult(paramCloudProtocolResult);
      QMLog.log(6, "QMUmaManager", "retry login failed , uma error code :" + paramCloudProtocolResult.error_code_);
      return;
    }
    Log.d("terrytan", QMUmaManager.access$200(this.this$2.this$1.this$0) + "uma retry login :" + String.valueOf(Hex.encodeHex(QMUmaManager.access$100(this.this$2.this$1.this$0))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.48.1.1
 * JD-Core Version:    0.7.0.1
 */