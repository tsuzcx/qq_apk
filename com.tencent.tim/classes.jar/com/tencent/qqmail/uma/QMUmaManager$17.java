package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReq;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReqInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import rx.functions.Action1;

class QMUmaManager$17
  implements Action1<Throwable>
{
  QMUmaManager$17(QMUmaManager paramQMUmaManager, SyncEMailPhotoContentReq paramSyncEMailPhotoContentReq, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public void call(Throwable paramThrowable)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    localCloudProtocolResult.error_code_ = -1;
    if ((paramThrowable instanceof QMNetworkError))
    {
      paramThrowable = (QMNetworkError)paramThrowable;
      if (paramThrowable.code == 304) {
        localCloudProtocolResult.error_code_ = -10022;
      }
    }
    for (;;)
    {
      paramThrowable = new SyncEMailPhotoRspInfo();
      paramThrowable.email = this.val$req.info.email;
      paramThrowable.sha = this.val$req.info.sha;
      paramThrowable.size = this.val$req.info.size;
      localCloudProtocolResult.sync_photo_list_ = new SyncEMailPhotoRspInfo[1];
      localCloudProtocolResult.sync_photo_list_[0] = paramThrowable;
      this.val$session.callback.onCloudResult(localCloudProtocolResult);
      return;
      if (paramThrowable.code == 404)
      {
        localCloudProtocolResult.error_code_ = -10007;
        continue;
        if ((paramThrowable instanceof QMUmaManager.QMPUmaException))
        {
          localCloudProtocolResult.error_code_ = ((QMUmaManager.QMPUmaException)paramThrowable).retCode;
          Log.w("uma", "photo un change");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.17
 * JD-Core Version:    0.7.0.1
 */