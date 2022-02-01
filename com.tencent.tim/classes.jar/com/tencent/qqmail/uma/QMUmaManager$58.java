package com.tencent.qqmail.uma;

import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.List;
import java.util.Map;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMUmaManager$58
  implements Observable.OnSubscribe<SyncEMailPhotoRspInfo>
{
  QMUmaManager$58(QMUmaManager paramQMUmaManager, QMNetworkResponse paramQMNetworkResponse) {}
  
  public void call(Subscriber<? super SyncEMailPhotoRspInfo> paramSubscriber)
  {
    SyncEMailPhotoRspInfo localSyncEMailPhotoRspInfo = new SyncEMailPhotoRspInfo();
    localSyncEMailPhotoRspInfo.lastmodifytime = "";
    if ((this.val$response.getResponseHeaders() != null) && (this.val$response.getResponseHeaders().get("Last-Modified") != null) && (((List)this.val$response.getResponseHeaders().get("Last-Modified")).size() > 0)) {
      localSyncEMailPhotoRspInfo.lastmodifytime = ((String)((List)this.val$response.getResponseHeaders().get("Last-Modified")).get(0));
    }
    localSyncEMailPhotoRspInfo.data = ByteString.copyFrom(this.val$response.getResponseData());
    localSyncEMailPhotoRspInfo.result = 0;
    paramSubscriber.onNext(localSyncEMailPhotoRspInfo);
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.58
 * JD-Core Version:    0.7.0.1
 */