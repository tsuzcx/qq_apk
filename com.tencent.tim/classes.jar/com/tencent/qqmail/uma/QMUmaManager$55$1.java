package com.tencent.qqmail.uma;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.ReqBase;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMUmaManager$55$1
  implements Observable.OnSubscribe<QMNetworkRequest>
{
  QMUmaManager$55$1(QMUmaManager.55 param55, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public void call(Subscriber<? super QMNetworkRequest> paramSubscriber)
  {
    ReqBase localReqBase = QMUmaManager.access$900(this.this$1.this$0, this.val$session);
    try
    {
      localReqBase.pkg = ByteString.copyFrom(QMUmaManager.access$1300(this.this$1.this$0, this.val$session.sessionKey, this.val$session.reqPkg));
      paramSubscriber.onNext(QMUmaManager.access$1100(this.this$1.this$0, this.val$session, localReqBase));
      paramSubscriber.onCompleted();
      return;
    }
    catch (Exception localException)
    {
      paramSubscriber.onError(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.55.1
 * JD-Core Version:    0.7.0.1
 */