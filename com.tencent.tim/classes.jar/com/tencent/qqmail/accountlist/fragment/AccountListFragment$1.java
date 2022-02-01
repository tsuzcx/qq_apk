package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.watcher.QMTaskListChangeWatcher;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask;

class AccountListFragment$1
  implements QMTaskListChangeWatcher
{
  AccountListFragment$1(AccountListFragment paramAccountListFragment) {}
  
  public void onTaskComplete(QMTask paramQMTask)
  {
    if ((paramQMTask instanceof QMSendMailTask)) {
      AccountListFragment.access$000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.1
 * JD-Core Version:    0.7.0.1
 */