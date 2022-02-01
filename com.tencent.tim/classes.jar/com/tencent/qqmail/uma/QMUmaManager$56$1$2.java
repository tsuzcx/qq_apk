package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Subscriber;

class QMUmaManager$56$1$2
  implements QMCallback.IErrorCallback
{
  QMUmaManager$56$1$2(QMUmaManager.56.1 param1) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    Log.v("terrytan", QMUmaManager.access$200(this.this$2.this$1.this$0) + "uma receive err:" + paramQMNetworkRequest.getRequestUrlString());
    this.this$2.val$subscriber.onError(paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.56.1.2
 * JD-Core Version:    0.7.0.1
 */