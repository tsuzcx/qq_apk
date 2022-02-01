package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher;

class FtnListActivity$1
  implements FtnQueryExpireUnreadWatcher
{
  FtnListActivity$1(FtnListActivity paramFtnListActivity) {}
  
  public void onSuccess(long paramLong, FtnExpireInfo paramFtnExpireInfo, boolean paramBoolean)
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if ((localQQMailAccount == null) || (paramLong != localQQMailAccount.getId())) {}
    while (FtnListActivity.access$100(this.this$0)) {
      return;
    }
    FtnListActivity.access$102(this.this$0, paramBoolean);
    FtnListActivity.access$202(this.this$0, paramFtnExpireInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.1
 * JD-Core Version:    0.7.0.1
 */