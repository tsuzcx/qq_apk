package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.accountlist.adapter.AccountBaseAdapter;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.folderlist.FolderDataManager;

class AccountListFragment$9
  implements BottleListController.UpdateUnreadStatusWatcher
{
  AccountListFragment$9(AccountListFragment paramAccountListFragment) {}
  
  public void onSuccessInMainThread(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((!AccountListFragment.access$1100(this.this$0)) && (paramBoolean))
    {
      AccountListFragment.access$300(this.this$0).updateBottleUnread(AccountListFragment.access$1200(this.this$0));
      AccountListFragment.access$300(this.this$0).setMyAppUnreadRedDot(AccountListFragment.access$1200(this.this$0));
      FolderDataManager.sharedInstance().setInnerBottleUnreadCount(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.9
 * JD-Core Version:    0.7.0.1
 */