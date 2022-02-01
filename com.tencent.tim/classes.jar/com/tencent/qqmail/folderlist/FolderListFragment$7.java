package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.RelativeVerifyWatcher;
import java.util.ArrayList;

class FolderListFragment$7
  implements RelativeVerifyWatcher
{
  FolderListFragment$7(FolderListFragment paramFolderListFragment) {}
  
  public void onSuccess(int paramInt)
  {
    if ((FolderListFragment.access$2000(this.this$0) != null) && (paramInt == FolderListFragment.access$2000(this.this$0).getId()) && (QMFolderManager.sharedInstance().getFoldersByAccountId(FolderListFragment.access$200(this.this$0)).size() <= 0))
    {
      FolderListFragment.access$2100(this.this$0);
      FolderListFragment.access$2200(this.this$0).sync(FolderListFragment.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.7
 * JD-Core Version:    0.7.0.1
 */