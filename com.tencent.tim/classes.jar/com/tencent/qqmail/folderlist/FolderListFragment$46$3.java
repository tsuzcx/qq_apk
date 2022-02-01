package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.log.QMLog;

class FolderListFragment$46$3
  implements Runnable
{
  FolderListFragment$46$3(FolderListFragment.46 param46, int paramInt) {}
  
  public void run()
  {
    FolderListFragment.access$7200(this.this$1.this$0, QMMailManager.sharedInstance().isAccountUpdating(FolderListFragment.access$200(this.this$1.this$0)));
    QMLog.log(6, "FolderListFragment", "Topbar-debug listWatcher error folder_id: " + this.val$folderId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.46.3
 * JD-Core Version:    0.7.0.1
 */