package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.SyncEMailNicknameRspInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;

class QMPrivateProtocolManager$14
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$14(QMPrivateProtocolManager paramQMPrivateProtocolManager, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "syncAccountNick error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      if ((paramCloudProtocolResult.sync_nick_list_ != null) && (paramCloudProtocolResult.sync_nick_list_.length >= 1)) {
        this.this$0.triggerSyncNickSuccess(paramCloudProtocolResult.sync_nick_list_[0].nickname);
      }
      return;
    }
    this.this$0.triggerSyncNickError(this.val$email);
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.SyncNick:" + this.val$email);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.14
 * JD-Core Version:    0.7.0.1
 */