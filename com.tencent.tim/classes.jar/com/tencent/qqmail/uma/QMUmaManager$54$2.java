package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMUmaManager$54$2
  extends SimpleOnProtocolListener
{
  QMUmaManager$54$2(QMUmaManager.54 param54) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if (paramCloudProtocolResult.error_code_ != 0)
    {
      this.this$1.val$session.callback.onCloudResult(paramCloudProtocolResult);
      QMLog.log(6, "QMUmaManager", "auto login failed , uma error code :" + paramCloudProtocolResult.error_code_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.54.2
 * JD-Core Version:    0.7.0.1
 */