package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.accountlist.model.AccountListUI;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.utilities.log.QMLog;

class AccountListFragment$29$3
  implements Runnable
{
  AccountListFragment$29$3(AccountListFragment.29 param29, AccountListUI paramAccountListUI, int paramInt) {}
  
  public void run()
  {
    if (this.val$data.mFolder.getType() != 130)
    {
      FolderDataManager.moveAppFromHomeToInnerAndSendToServer(this.val$folderId);
      if (this.val$data.mFolder.getType() == 130) {
        PopularizeManager.sharedInstance().updatePopularizeMoved(this.val$folderId, 2);
      }
      if (this.val$folderId != -5) {
        break label95;
      }
      FolderDataManager.sharedInstance().syncInnerFtnUnreadCount();
    }
    for (;;)
    {
      AccountListFragment.access$600(this.this$1.this$0);
      QMLog.log(4, "AccountListFragment", "move home app to inner to send config");
      return;
      FolderDataManager.moveAppFromHomeToInner(this.val$folderId);
      break;
      label95:
      if (this.val$folderId == -16) {
        FolderDataManager.sharedInstance().syncInnerBottleUnreadCount();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.29.3
 * JD-Core Version:    0.7.0.1
 */