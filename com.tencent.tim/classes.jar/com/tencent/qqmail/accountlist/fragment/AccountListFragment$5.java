package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$5
  implements FtnQueryExpireUnreadWatcher
{
  AccountListFragment$5(AccountListFragment paramAccountListFragment) {}
  
  public void onSuccess(long paramLong, FtnExpireInfo paramFtnExpireInfo, boolean paramBoolean)
  {
    QMLog.log(4, "AccountListFragment", "Ftn-expunread account called trigger-watcher id: " + paramLong + " info: " + paramFtnExpireInfo + " update: " + paramBoolean);
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if ((AccountListFragment.access$200(this.this$0) != null) && (localObject != null) && (((QQMailAccount)localObject).getId() == paramLong) && (paramFtnExpireInfo != null))
    {
      localObject = FtnManager.sharedInstance();
      if (localObject != null)
      {
        ((FtnManager)localObject).setFtnExpUnreadUpdate(paramBoolean);
        ((FtnManager)localObject).setFtnExpireInfo(paramFtnExpireInfo);
        if (((FtnManager)localObject).isFtnExpUnreadNeedShow()) {
          FolderDataManager.sharedInstance().setInnerFtnUnreadCount(0);
        }
      }
      AccountListFragment.access$500(this.this$0, new AccountListFragment.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.5
 * JD-Core Version:    0.7.0.1
 */