package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.view.FolderLockDialog;

class AppFolderListFragment$3$1
  implements Runnable
{
  AppFolderListFragment$3$1(AppFolderListFragment.3 param3) {}
  
  public void run()
  {
    AppFolderListFragment.access$100(this.this$1.this$0).cancelDialog();
    AppFolderListFragment.access$100(this.this$1.this$0).dismissTips();
    AppFolderListFragment.access$100(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.AppFolderListFragment.3.1
 * JD-Core Version:    0.7.0.1
 */