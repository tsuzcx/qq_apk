package com.tencent.qqmail.model.protocol;

import android.graphics.Bitmap;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPrivateProtocolManager$18
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$18(QMPrivateProtocolManager paramQMPrivateProtocolManager, int paramInt, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, Profile paramProfile, boolean paramBoolean1, Account paramAccount, String paramString4, boolean paramBoolean2) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "addAccount error code : " + paramCloudProtocolResult.error_code_);
    StringBuilder localStringBuilder;
    int i;
    if ((paramCloudProtocolResult.error_code_ == 0) || (paramCloudProtocolResult.error_code_ == -10009))
    {
      BackOffFilter.resetError(QMMath.hashInt("addAccount" + this.val$accountId));
      BackOffFilter.resetError(QMMath.hashInt("addAccountUmaLogin" + this.val$accountId));
      AccountManager.shareInstance().updateAccountAttr(this.val$accountId, 32, false);
      if ((this.val$nick != null) && (!this.val$nick.equals(""))) {
        QMPrivateProtocolManager.sharedInstance().setAccountNick(this.val$email, this.val$nick);
      }
      if (this.val$bitmap != null)
      {
        if ((this.val$psw != null) && (!this.val$psw.equals(""))) {
          this.val$profile.QQPassword = this.val$psw;
        }
        QMPrivateProtocolManager.sharedInstance().setAccountPhoto(this.val$accountId, this.val$profile, this.val$email, this.val$bitmap, Profile.getProtocol(this.val$profile));
      }
      if (this.val$isUpgrade) {
        QMPrivateProtocolManager.sharedInstance().loadEmailIconDirectly(this.val$email);
      }
      localStringBuilder = new StringBuilder().append(this.val$email).append("####").append(this.val$accountId).append("####");
      if (this.val$isUpgrade)
      {
        localObject = "1";
        localObject = (String)localObject;
        QMLogStream.logWithoutUma(-40009, (String)localObject, "Event_App_Add_Account_UMA");
        AddAccountLocalLogUtil.timeLineAccountChange("UMA", "addUmaAccountSuccess:" + (String)localObject);
        QMMailManager.sharedInstance().checkUpdateConfig(true);
        if ((this.val$acc.isQQMail()) && (!this.val$acc.isBizMail())) {
          QMCardManager.shareInstance().syncBirthFriendList();
        }
        i = 1;
        label355:
        if (i == 0)
        {
          localStringBuilder = new StringBuilder().append(String.valueOf(paramCloudProtocolResult.error_code_)).append("####").append(this.val$email).append("####");
          if (!this.val$isUpgrade) {
            break label909;
          }
        }
      }
    }
    label909:
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = (String)localObject;
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.AddAccount:" + this.val$profile.mailAddress);
      QMLogStream.logWithoutUma(-40001, (String)localObject, "Event_App_Add_Account_Fail");
      AddAccountLocalLogUtil.timeLineAccountChange("UMA", "addUmaAccountFail:" + (String)localObject);
      return;
      localObject = "0";
      break;
      if ((paramCloudProtocolResult.error_code_ == -10002) || (paramCloudProtocolResult.error_code_ == -10001))
      {
        QMLog.log(5, "QMPrivateProtocolManager", "addAcc fail do not try again:" + paramCloudProtocolResult.error_code_);
        i = 0;
        break label355;
      }
      long l;
      if (paramCloudProtocolResult.error_code_ == -10005)
      {
        l = BackOffFilter.whenToRetryOrAbort(QMMath.hashInt("addAccountUmaLogin" + this.val$accountId), true) * 1000L;
        if (l == 0L) {
          QMPrivateProtocolManager.access$1600(this.this$0, this.val$acc, this.val$profile, this.val$domain, this.val$nick, this.val$bitmap);
        }
        for (;;)
        {
          i = 0;
          break;
          if (l > 0L)
          {
            QMLog.log(4, "QMPrivateProtocolManager", "addAccount umalogin wait for " + l);
            Threads.runInBackground(new QMPrivateProtocolManager.18.1(this), l);
          }
          else
          {
            QMLog.log(5, "QMPrivateProtocolManager", "addAccount umalogin wait so long do not try again");
            AccountManager.shareInstance().updateAccountAttr(this.val$accountId, 32, true);
          }
        }
      }
      if (paramCloudProtocolResult.error_code_ != -10003)
      {
        l = BackOffFilter.whenToRetryOrAbort(QMMath.hashInt("addAccount" + this.val$accountId), true) * 1000L;
        if (l == 0L) {
          this.this$0.addAccount(this.val$profile, this.val$domain, this.val$email, this.val$psw, this.val$accountId, this.val$nick, this.val$bitmap, this.val$isUpgrade, this.val$isBiz);
        }
        for (;;)
        {
          i = 0;
          break;
          if (l > 0L)
          {
            QMLog.log(4, "QMPrivateProtocolManager", "addAccount wait for " + l);
            Threads.runInBackground(new QMPrivateProtocolManager.18.2(this), l);
          }
          else
          {
            QMLog.log(5, "QMPrivateProtocolManager", "addAccount wait so long do not try again");
            AccountManager.shareInstance().updateAccountAttr(this.val$accountId, 32, true);
          }
        }
      }
      if ((this.val$acc instanceof QQMailAccount))
      {
        localObject = new QMPrivateProtocolManager.18.3(this);
        ((QQMailAccount)this.val$acc).wtAutoLogin((LoginCallback)localObject);
      }
      i = 0;
      break label355;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.18
 * JD-Core Version:    0.7.0.1
 */