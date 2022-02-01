package com.tencent.qqmail.activity.setting;

import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;

class SettingAccountActivity$14
  implements QMUIDialogAction.ActionListener
{
  String url;
  
  SettingAccountActivity$14(SettingAccountActivity paramSettingAccountActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (paramSettingAccountActivity = QMNetworkConfig.getCgiRequestHostHttps(SettingAccountActivity.access$300(this.this$0));; paramSettingAccountActivity = QMNetworkConfig.getCgiRequestHost(SettingAccountActivity.access$300(this.this$0)))
    {
      this.url = (paramSettingAccountActivity + "/cgi-bin/" + "logout");
      return;
    }
  }
  
  private void clearAddrVipDisplay()
  {
    QMSettingManager.sharedInstance().setAddrVipDisplay(0);
  }
  
  private void clearAttachFolderDisplay()
  {
    QMSettingManager.sharedInstance().setStarAttachDisplay(0);
  }
  
  private void clearAttachFolderState(int paramInt)
  {
    QMSettingManager.sharedInstance().setAttachFolderLockStatus(paramInt, false);
    QMSettingManager.sharedInstance().setAttachFolderListSyncToken(paramInt, "");
  }
  
  private void clearFolderRemoteCount(int paramInt)
  {
    QMSettingManager.sharedInstance().removeAddrVipLoadUTC(paramInt);
    QMSettingManager.sharedInstance().removeAddrVipRemoteCount(paramInt);
    QMSettingManager.sharedInstance().removeStarAttachRemoteCount(paramInt);
  }
  
  private boolean isLogoutDefaultNoteAccount()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
    return (localQQMailAccount != null) && (localQQMailAccount.getId() == SettingAccountActivity.access$300(this.this$0));
  }
  
  private void logoutSid(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localObject == null) || (!((Account)localObject).isQQMail())) {
      return;
    }
    QMLog.log(4, "SettingAccountActivity", "logout sid for:" + paramInt);
    localObject = new QMNetworkRequest(this.url + "?sid=" + ((QQMailAccount)localObject).getSid() + "&t=mobile_mgr.json&error=app&apv=" + AppConfig.getCodeVersion() + "&os=android&f=xhtml");
    Log.e("SettingAccountActivity", "logout url:" + ((QMNetworkRequest)localObject).getRequestUrlString());
    NetworkManager.sharedInstance().sendRequest((QMNetworkRequest)localObject);
  }
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    SettingAccountActivity.access$2300(this.this$0);
    paramQMUIDialog.dismiss();
    QMLog.log(4, "SettingAccountActivity", "go del acc:" + SettingAccountActivity.access$300(this.this$0));
    boolean bool = AccountManager.shareInstance().getAccountList().isDefaultMailAccount(SettingAccountActivity.access$300(this.this$0));
    paramInt = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
    QMPushMailNotify.getInstance().cancelNotifyNewMail(SettingAccountActivity.access$300(this.this$0));
    logoutSid(SettingAccountActivity.access$300(this.this$0));
    SettingAccountActivity.access$902(this.this$0, true);
    clearAttachFolderState(SettingAccountActivity.access$300(this.this$0));
    clearFolderRemoteCount(SettingAccountActivity.access$300(this.this$0));
    this.this$0.getTips().showLoading(2131721127);
    Threads.runInBackground(new SettingAccountActivity.14.1(this, bool, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.14
 * JD-Core Version:    0.7.0.1
 */