package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class AccountListFragment$29$4$1
  implements Runnable
{
  AccountListFragment$29$4$1(AccountListFragment.29.4 param4) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().deleteFolderMail(AccountListFragment.access$100(this.this$2.this$1.this$0), this.this$2.val$data.mFolder.getAccountId(), this.this$2.val$data.mFolder.getId(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.29.4.1
 * JD-Core Version:    0.7.0.1
 */