package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class FolderListFragment$3$1
  implements Runnable
{
  FolderListFragment$3$1(FolderListFragment.3 param3) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().deleteFolderMail(FolderListFragment.access$1300(this.this$1.this$0), ((QMFolder)this.this$1.val$folder.getData()).getAccountId(), ((QMFolder)this.this$1.val$folder.getData()).getId(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.3.1
 * JD-Core Version:    0.7.0.1
 */