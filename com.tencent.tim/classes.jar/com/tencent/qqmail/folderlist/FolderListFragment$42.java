package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.view.QMTopBar;

class FolderListFragment$42
  implements Runnable
{
  FolderListFragment$42(FolderListFragment paramFolderListFragment, boolean paramBoolean) {}
  
  public void run()
  {
    FolderListFragment.access$6902(this.this$0, this.val$updating);
    FolderListFragment.access$5800(this.this$0);
    this.this$0.getTopBar().showLoading(this.val$updating);
    FolderListFragment.access$2700(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.42
 * JD-Core Version:    0.7.0.1
 */