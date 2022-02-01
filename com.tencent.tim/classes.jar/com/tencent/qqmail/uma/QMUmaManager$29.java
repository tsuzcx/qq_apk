package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import rx.functions.Action1;

class QMUmaManager$29
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$29(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    localCloudProtocolResult.error_code_ = 0;
    paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.29
 * JD-Core Version:    0.7.0.1
 */