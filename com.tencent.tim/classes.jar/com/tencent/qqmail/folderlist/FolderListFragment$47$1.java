package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.view.FolderLockDialog;

class FolderListFragment$47$1
  implements Runnable
{
  FolderListFragment$47$1(FolderListFragment.47 param47, int paramInt) {}
  
  public void run()
  {
    FolderListFragment.access$100(this.this$1.this$0).cancelDialog();
    FolderListFragment.access$100(this.this$1.this$0).dismissTips();
    FolderListFragment.access$7900(this.this$1.this$0, this.this$1.val$folder, this.this$1.val$folderType, this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.47.1
 * JD-Core Version:    0.7.0.1
 */