package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPrivateProtocolManager$23
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$23(QMPrivateProtocolManager paramQMPrivateProtocolManager, int paramInt, String paramString) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "delAccount error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      BackOffFilter.resetError(QMMath.hashInt("DeleteAccount" + this.val$accountId));
      AddAccountLocalLogUtil.timeLineAccountChange("UMA", "delUmaAccountSuccess:" + this.val$email);
      DataCollector.logDetailEvent("DetailEvent_DeleteAccount", this.val$accountId, 0L, "");
      return;
    }
    long l = BackOffFilter.whenToRetryOrAbort(QMMath.hashInt("DeleteAccount" + this.val$accountId), true) * 1000L;
    if (l == 0L) {
      this.this$0.delAccount(this.val$accountId, this.val$email);
    }
    for (;;)
    {
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.DeleteAccount:" + this.val$email);
      AddAccountLocalLogUtil.timeLineAccountChange("UMA", "delUmaAccountFail:" + this.val$email + ", ret:" + paramCloudProtocolResult.error_code_);
      DataCollector.logDetailEvent("DetailEvent_DeleteAccount", this.val$accountId, 1L, "errorcode" + paramCloudProtocolResult.error_code_);
      return;
      if (l > 0L)
      {
        QMLog.log(4, "QMPrivateProtocolManager", "delAccount wait for " + l);
        Threads.runInBackground(new QMPrivateProtocolManager.23.1(this), l);
      }
      else
      {
        QMLog.log(5, "QMPrivateProtocolManager", "delAccount wait so long. do not try again.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.23
 * JD-Core Version:    0.7.0.1
 */