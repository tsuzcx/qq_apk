package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.SetEMailPhotoRspInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMPrivateProtocolManager$16
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$16(QMPrivateProtocolManager paramQMPrivateProtocolManager, int paramInt, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "setAccountPhoto error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      if ((paramCloudProtocolResult.set_photo_rsp_list_ != null) && (paramCloudProtocolResult.set_photo_rsp_list_.length > 0))
      {
        if (paramCloudProtocolResult.set_photo_rsp_list_[0].result == 0) {
          this.this$0.triggerSetPhotoSuccess(this.val$accountId);
        }
      }
      else {
        return;
      }
      this.this$0.triggerSetPhotoError(this.val$accountId);
      return;
    }
    this.this$0.triggerSetPhotoError(this.val$accountId);
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.SetPhoto:" + this.val$email);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.16
 * JD-Core Version:    0.7.0.1
 */