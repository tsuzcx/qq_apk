package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.OnProtocolListener;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReq;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReqInfo;
import com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo;
import rx.functions.Action1;

class QMUmaManager$16
  implements Action1<SyncEMailPhotoRspInfo>
{
  QMUmaManager$16(QMUmaManager paramQMUmaManager, SyncEMailPhotoContentReq paramSyncEMailPhotoContentReq, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public void call(SyncEMailPhotoRspInfo paramSyncEMailPhotoRspInfo)
  {
    CloudProtocolResult localCloudProtocolResult = new CloudProtocolResult();
    localCloudProtocolResult.error_code_ = 0;
    paramSyncEMailPhotoRspInfo.email = this.val$req.info.email;
    paramSyncEMailPhotoRspInfo.sha = this.val$req.info.sha;
    paramSyncEMailPhotoRspInfo.size = this.val$req.info.size;
    localCloudProtocolResult.sync_photo_list_ = new SyncEMailPhotoRspInfo[1];
    localCloudProtocolResult.sync_photo_list_[0] = paramSyncEMailPhotoRspInfo;
    this.val$session.callback.onCloudResult(localCloudProtocolResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.16
 * JD-Core Version:    0.7.0.1
 */