package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import rx.functions.Action1;

class QMUmaManager$8
  implements Action1<QMUmaManager.QMUmaResult>
{
  QMUmaManager$8(QMUmaManager paramQMUmaManager) {}
  
  public void call(QMUmaManager.QMUmaResult paramQMUmaResult)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    paramQMUmaResult.session.callback.onCloudResult(localCloudProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.8
 * JD-Core Version:    0.7.0.1
 */