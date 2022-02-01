package com.tencent.qqmail.uma;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$50
  implements Func1<QMNetworkResponse, Observable<? extends byte[]>>
{
  QMUmaManager$50(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public Observable<? extends byte[]> call(QMNetworkResponse paramQMNetworkResponse)
  {
    QMUmaManager localQMUmaManager = this.this$0;
    if (this.val$session.rspKey != null) {}
    for (byte[] arrayOfByte = this.val$session.rspKey;; arrayOfByte = this.val$session.sessionKey) {
      return QMUmaManager.access$500(localQMUmaManager, paramQMNetworkResponse, arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.50
 * JD-Core Version:    0.7.0.1
 */