package com.tencent.qqmail.uma;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.ReqBase;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMUmaManager$53
  implements Observable.OnSubscribe<QMNetworkRequest>
{
  QMUmaManager$53(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public void call(Subscriber<? super QMNetworkRequest> paramSubscriber)
  {
    ReqBase localReqBase = QMUmaManager.access$900(this.this$0, this.val$session);
    try
    {
      localReqBase.pkg = ByteString.copyFrom(RsaEncryption.encrypt(this.val$session.reqPkg, QMUmaManager.access$1000(this.this$0)));
      paramSubscriber.onNext(QMUmaManager.access$1100(this.this$0, this.val$session, localReqBase));
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
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.53
 * JD-Core Version:    0.7.0.1
 */