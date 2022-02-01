package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.BottleOpenNotifyWatcher;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$10
  implements BottleOpenNotifyWatcher
{
  AccountListFragment$10(AccountListFragment paramAccountListFragment) {}
  
  public void onNotify(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMLog.log(4, "AccountListFragment", "mBottleOpenNotifyWatcher: opened");
      int i = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
      if (i != -1) {
        QMMailManager.sharedInstance().sync(i);
      }
      BottleManager localBottleManager = BottleManager.getInstance();
      if (localBottleManager != null) {
        localBottleManager.getBottleListController().bindUpdateUnreadStatusWatcher(AccountListFragment.access$1300(this.this$0), true);
      }
      AccountListFragment.access$600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.10
 * JD-Core Version:    0.7.0.1
 */