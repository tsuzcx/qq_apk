package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.view.FolderLockDialog;

class FolderListFragment$8$2
  implements Runnable
{
  FolderListFragment$8$2(FolderListFragment.8 param8) {}
  
  public void run()
  {
    FolderListFragment.access$100(this.this$1.this$0).cancelDialog();
    FolderListFragment.access$100(this.this$1.this$0).dismissTips();
    FolderListFragment.access$100(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.8.2
 * JD-Core Version:    0.7.0.1
 */