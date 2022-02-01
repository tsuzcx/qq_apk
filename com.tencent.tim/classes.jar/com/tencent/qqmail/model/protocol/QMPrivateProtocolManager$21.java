package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPrivateProtocolManager$21
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$21(QMPrivateProtocolManager paramQMPrivateProtocolManager, int paramInt, Profile paramProfile, Account paramAccount) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "modAccount error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      BackOffFilter.resetError(QMMath.hashInt("ModAccount" + this.val$accountId));
      AddAccountLocalLogUtil.timeLineAccountChange("UMA", "modUmaAccountSuccess:" + this.val$profile.mailAddress);
      return;
    }
    if (paramCloudProtocolResult.error_code_ == -10007)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "modAccount not exist in uma " + this.val$account.getEmail());
      QMPrivateProtocolManager.access$1400(this.this$0, this.val$account);
      return;
    }
    if (paramCloudProtocolResult.error_code_ == -10003)
    {
      QMLog.log(6, "QMPrivateProtocolManager", "modAccount password fail:" + this.val$profile.mailAddress);
      return;
    }
    long l = BackOffFilter.whenToRetryOrAbort(QMMath.hashInt("ModAccount" + this.val$accountId), true) * 1000L;
    if (l == 0L) {
      this.this$0.modAccount(this.val$account);
    }
    for (;;)
    {
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.ModAccount:" + this.val$profile.mailAddress + ",retcode:" + paramCloudProtocolResult.error_code_);
      QMLogStream.logWithoutUmaNow(-40015, "modAccount err:" + paramCloudProtocolResult.error_code_ + ";" + this.val$profile.mailAddress, "MODACCOUNT");
      AddAccountLocalLogUtil.timeLineAccountChange("UMA", "modUmaAccountFail:" + this.val$profile.mailAddress + ", aid:" + this.val$accountId + ",ret:" + paramCloudProtocolResult.error_code_);
      return;
      if (l > 0L)
      {
        QMLog.log(4, "QMPrivateProtocolManager", "modAccount wait for " + l);
        Threads.runInBackground(new QMPrivateProtocolManager.21.1(this), l);
      }
      else
      {
        QMLog.log(5, "QMPrivateProtocolManager", "modAccount wait so long. do not try again.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.21
 * JD-Core Version:    0.7.0.1
 */