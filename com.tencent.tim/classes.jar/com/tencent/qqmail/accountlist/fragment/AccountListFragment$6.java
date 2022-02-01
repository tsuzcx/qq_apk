package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AccountListFragment$6
  implements LoadAttachFolderListWatcher
{
  AccountListFragment$6(AccountListFragment paramAccountListFragment) {}
  
  public void onError(int paramInt, boolean paramBoolean, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "AccountListFragment", "Load attach folder list on error, accountid: " + paramInt + " checkupdate: " + paramBoolean);
  }
  
  public void onProcess(int paramInt1, int paramInt2) {}
  
  public void onSuccess(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    QMLog.log(4, "AccountListFragment", "Load attach folder list onsuccess, needupdate: " + paramBoolean3 + "checkupdate: " + paramBoolean2 + " folderlock: " + paramBoolean1);
    if (paramBoolean2)
    {
      if (paramBoolean3)
      {
        QMLog.log(4, "AccountListFragment", "Load attach folder list on success, check need update! accountid: " + paramInt);
        QMAttachManager.sharedInstance().loadAttachFolderList(paramInt);
      }
      return;
    }
    AccountListFragment.access$700(this.this$0, new AccountListFragment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.6
 * JD-Core Version:    0.7.0.1
 */