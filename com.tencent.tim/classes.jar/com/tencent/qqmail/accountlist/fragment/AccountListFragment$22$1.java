package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.maillist.ListViewHelper.OnHandleNextUnread;
import com.tencent.qqmail.view.QMBaseView;

class AccountListFragment$22$1
  implements ListViewHelper.OnHandleNextUnread
{
  AccountListFragment$22$1(AccountListFragment.22 param22) {}
  
  public void onFoundUnread(int paramInt1, int paramInt2)
  {
    QMBaseView localQMBaseView = (QMBaseView)AccountListFragment.access$2300(this.this$1.this$0);
    if (paramInt1 == -1)
    {
      localQMBaseView.scrollToTop();
      return;
    }
    localQMBaseView.scrollToPosition(paramInt1);
  }
  
  public boolean onReachEnd(int paramInt)
  {
    ((QMBaseView)AccountListFragment.access$2200(this.this$1.this$0)).scrollToTop();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.22.1
 * JD-Core Version:    0.7.0.1
 */