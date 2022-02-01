package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.LoadMailCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.HashMap;

class QMMailProtocolNativeService$27
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$27(QMMailProtocolNativeService paramQMMailProtocolNativeService, int paramInt1, int paramInt2, LoadMailCallback paramLoadMailCallback, Profile paramProfile, Account paramAccount, QMFolder paramQMFolder, com.tencent.qqmail.model.qmdomain.Mail paramMail, boolean paramBoolean1, boolean paramBoolean2, HashMap paramHashMap, com.tencent.qqmail.protocol.Mail paramMail1, double paramDouble) {}
  
  public void onDownloadText(com.tencent.qqmail.protocol.Mail paramMail, ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "downloadMailText result:" + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      com.tencent.qqmail.model.qmdomain.Mail localMail = QMMailProtocolNativeService.access$500(this.this$0, paramMail, this.val$protocol);
      QMLog.log(4, "QMMailProtocolNativeService", "mail content length:" + localMail.getContent().getBody().length());
      if (paramProtocolResult.calendar != null)
      {
        QMMailManager.sharedInstance().saveIcsEvent(this.val$accountId, localMail.getInformation().getRemoteId(), paramProtocolResult.calendar);
        localMail.getStatus().setIcs(true);
      }
      if (this.val$callback != null) {
        this.val$callback.loadMailSuccess(paramMail.mailId, localMail);
      }
      switch (this.val$protocol)
      {
      }
    }
    for (;;)
    {
      if (paramProtocolResult.error_code_ != 21)
      {
        if (paramProtocolResult.error_code_ != 0) {
          break label469;
        }
        QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "downloadMailText", true);
      }
      return;
      this.this$0.saveActiveSync(paramMail.accountId, paramProtocolResult);
      continue;
      if (paramProtocolResult.error_code_ == 13)
      {
        QMLog.log(4, "QMMailProtocolNativeService", "downloadMailText wipe account:" + paramMail.accountId);
        QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(paramMail.accountId);
      }
      else if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "downloadMailText auth error: " + paramMail.accountId);
        PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
        paramMail = new QMProtocolError(paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.loadMailError(paramMail);
        }
      }
      else if (paramProtocolResult.error_code_ == 3001)
      {
        QMLog.log(4, "QMMailProtocolNativeService", "downloadMailText token expire");
        if (this.val$profile.isOauth) {
          LoginManager.shareInstance().refreshGmailAccessToken(this.val$account.getId(), this.val$account.getRefreshToken(), new QMMailProtocolNativeService.27.1(this));
        }
      }
      else
      {
        if (paramProtocolResult.error_code_ != 3000) {
          break;
        }
        QMLog.log(6, "QMMailProtocolNativeService", "downloadMailText, token revoked");
      }
    }
    if (paramProtocolResult.error_code_ != 21) {}
    for (int i = paramProtocolResult.error_code_;; i = -2)
    {
      paramMail = new QMProtocolError(i);
      if (this.val$callback == null) {
        break;
      }
      this.val$callback.loadMailError(paramMail);
      break;
    }
    label469:
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "downloadMailText", false);
  }
  
  public boolean onDownloadTextProgress(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (!((String)this.val$downloadedSizeCache.get("section")).equals(paramString2))
    {
      this.val$downloadedSizeCache.put("section", paramString2);
      this.val$downloadedSizeCache.put("already_download_size", this.val$downloadedSizeCache.get("download_size_in_section"));
    }
    this.val$downloadedSizeCache.put("download_size_in_section", Integer.valueOf(paramInt));
    int i = ((Integer)this.val$downloadedSizeCache.get("already_download_size")).intValue();
    QMWatcherCenter.triggerLoadMailProcess(this.val$m.mailId, paramInt + i, Double.valueOf(this.val$size).longValue());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.27
 * JD-Core Version:    0.7.0.1
 */