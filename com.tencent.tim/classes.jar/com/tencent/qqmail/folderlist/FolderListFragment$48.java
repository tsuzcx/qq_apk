package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailManager;

class FolderListFragment$48
  implements Runnable
{
  FolderListFragment$48(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().setAccountHasNew(FolderListFragment.access$200(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.48
 * JD-Core Version:    0.7.0.1
 */