package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$59
  implements Func1<QMNetworkResponse, Observable<? extends SyncEMailPhotoRspInfo>>
{
  QMUmaManager$59(QMUmaManager paramQMUmaManager) {}
  
  public Observable<? extends SyncEMailPhotoRspInfo> call(QMNetworkResponse paramQMNetworkResponse)
  {
    return QMUmaManager.access$1500(this.this$0, paramQMNetworkResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.59
 * JD-Core Version:    0.7.0.1
 */