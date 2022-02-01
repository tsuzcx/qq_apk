package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Subscriber;

class QMUmaManager$56$1$1
  implements QMCallback.ISuccessCallback
{
  QMUmaManager$56$1$1(QMUmaManager.56.1 param1) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Log.v("terrytan", QMUmaManager.access$200(this.this$2.this$1.this$0) + "uma receive suc:" + paramQMNetworkRequest.getRequestUrlString());
    this.this$2.val$subscriber.onNext(paramQMNetworkResponse);
    this.this$2.val$subscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.56.1.1
 * JD-Core Version:    0.7.0.1
 */