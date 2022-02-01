package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import rx.Observable;
import rx.functions.Func0;

class QMUmaManager$52
  implements Func0<Observable<QMNetworkRequest>>
{
  QMUmaManager$52(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public Observable<QMNetworkRequest> call()
  {
    Log.v("terrytan", QMUmaManager.access$200(this.this$0) + "uma call defer");
    if (this.val$session.rspKey != null) {
      return QMUmaManager.access$700(this.this$0, this.val$session);
    }
    return QMUmaManager.access$800(this.this$0, this.val$session);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.52
 * JD-Core Version:    0.7.0.1
 */