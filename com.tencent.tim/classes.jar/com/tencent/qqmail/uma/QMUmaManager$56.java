package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMUmaManager$56
  implements Observable.OnSubscribe<QMNetworkResponse>
{
  QMUmaManager$56(QMUmaManager paramQMUmaManager, QMNetworkRequest paramQMNetworkRequest) {}
  
  public void call(Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    this.val$request.setRequestCallback(new QMUmaManager.56.1(this, paramSubscriber));
    Log.v("terrytan", QMUmaManager.access$200(this.this$0) + "uma send:" + this.val$request.getRequestUrlString());
    QMHttpUtil.send(this.val$request);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.56
 * JD-Core Version:    0.7.0.1
 */