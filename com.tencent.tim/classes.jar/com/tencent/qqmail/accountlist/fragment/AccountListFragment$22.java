package com.tencent.qqmail.accountlist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.accountlist.model.AccountListUI.ITEMTYPE;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AccountListFragment$22
  implements View.OnClickListener
{
  AccountListFragment$22(AccountListFragment paramAccountListFragment) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = AccountListFragment.access$200(this.this$0).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      AccountListUI localAccountListUI = (AccountListUI)localIterator.next();
      int j = QMFolderManager.sharedInstance().getDisplayUnreadCount(localAccountListUI.mFolder);
      if ((localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM) && (j > 0)) {
        localArrayList.add(Integer.valueOf(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localAccountListUI.mType == AccountListUI.ITEMTYPE.ITEM_ACCOUNT) && (localAccountListUI.accUnreadCount > 0)) {
          localArrayList.add(Integer.valueOf(i));
        } else if ((localAccountListUI.mFolder != null) && (localAccountListUI.mFolder.getId() == -10) && (localAccountListUI.accUnreadCount > 0)) {
          localArrayList.add(Integer.valueOf(i));
        } else if ((localAccountListUI.mFolder == null) || (localAccountListUI.mFolder.getId() != -5)) {}
      }
    }
    ListViewHelper.getNextUnread(AccountListFragment.access$1200(this.this$0), localArrayList, new AccountListFragment.22.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.22
 * JD-Core Version:    0.7.0.1
 */