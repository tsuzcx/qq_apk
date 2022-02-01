package com.tencent.qqmail.activity.setting;

import com.tencent.androidqqmail.tim.TimMailLoginManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.utilities.thread.Threads;

class SettingAccountActivity$14$1
  implements Runnable
{
  SettingAccountActivity$14$1(SettingAccountActivity.14 param14, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    FolderDataManager.sharedInstance().clearInnerUnreadCount(SettingAccountActivity.access$300(this.this$1.this$0));
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(SettingAccountActivity.access$300(this.this$1.this$0));
    TimMailLoginManager.notifyLoginChange(this.this$1.this$0, false, localAccount);
    AccountManager.shareInstance().deleteAccount(SettingAccountActivity.access$300(this.this$1.this$0), true);
    Threads.runOnMainThread(new SettingAccountActivity.14.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.14.1
 * JD-Core Version:    0.7.0.1
 */