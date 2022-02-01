package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action1;

class QMUmaManager$44
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$44(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    if (localCloudProtocolResult.error_code_ == 0) {
      QMLog.log(4, "QMUmaManager", "reportAdMailDeleteAndUnlike UMAR_OK " + localCloudProtocolResult.error_code_);
    }
    for (;;)
    {
      paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
      return;
      QMLog.log(6, "QMUmaManager", "reportAdMailDeleteAndUnlike innormal" + localCloudProtocolResult.error_code_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.44
 * JD-Core Version:    0.7.0.1
 */