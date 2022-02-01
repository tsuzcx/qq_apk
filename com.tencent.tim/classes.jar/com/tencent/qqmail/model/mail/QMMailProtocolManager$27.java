package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.LoadMailCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolManager$27
  implements LoadMailCallback
{
  QMMailProtocolManager$27(QMMailProtocolManager paramQMMailProtocolManager, MailManagerDelegate paramMailManagerDelegate, long paramLong, boolean paramBoolean1, boolean paramBoolean2, Profile paramProfile, int paramInt, Mail paramMail) {}
  
  public void loadMailError(QMProtocolError paramQMProtocolError)
  {
    if (this.val$callback != null) {
      this.val$callback.handleError(paramQMProtocolError);
    }
    if (this.val$callback != null) {
      this.val$callback.handleComplete(null);
    }
    if (paramQMProtocolError.getCode() == 21) {
      QMMailProtocolManager.access$000(this.this$0).mail.updateMailAttr(QMMailProtocolManager.access$000(this.this$0).getWritableDatabase(), new long[] { this.val$mail.getInformation().getId() }, 549755813888L);
    }
    QMWatcherCenter.triggerReadMailError(this.val$mailId, paramQMProtocolError);
  }
  
  public void loadMailProcess()
  {
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(null);
    }
    QMWatcherCenter.triggerLoadMailProcess(this.val$mailId, 0L, 0L);
  }
  
  public void loadMailSuccess(long paramLong, Mail paramMail)
  {
    if (this.val$isSearchMail) {}
    for (Mail localMail1 = QMMailProtocolManager.access$000(this.this$0).mail.readSearchMailSync(QMMailProtocolManager.access$000(this.this$0).getReadableDatabase(), paramLong);; localMail1 = QMMailProtocolManager.access$000(this.this$0).mail.readMailSync(QMMailProtocolManager.access$000(this.this$0).getReadableDatabase(), paramLong))
    {
      Mail localMail2 = localMail1;
      if (localMail1 == null) {
        localMail2 = paramMail;
      }
      paramMail.getStatus().setIsPushMail(this.val$isPushMail);
      paramMail.getStatus().setIsSearchMail(this.val$isSearchMail);
      QMMailProtocolManager.access$1300(this.this$0, localMail2, paramMail, this.val$profile.protocolType);
      QMMailProtocolManager.access$1400(this.this$0, paramMail);
      this.this$0.updateImapPartInfo(paramMail, this.val$profile.protocolType);
      QMSyncErrorManager.sharedInstance().removeSyncError(this.val$accountId);
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(null, null);
      }
      if (this.val$callback != null) {
        this.val$callback.handleComplete(null);
      }
      QMWatcherCenter.triggerReadRemoteMailSuccess(paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.27
 * JD-Core Version:    0.7.0.1
 */