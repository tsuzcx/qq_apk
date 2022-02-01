package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.FolderUnreadCountWatcher;

class FolderListFragment$43
  implements FolderUnreadCountWatcher
{
  FolderListFragment$43(FolderListFragment paramFolderListFragment) {}
  
  public void onUpdateAccount(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void onUpdateFolder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (FolderListFragment.access$800(this.this$0) == null) {
      return;
    }
    FolderListFragment.access$7000(this.this$0, new FolderListFragment.43.1(this, paramInt1, paramInt2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.43
 * JD-Core Version:    0.7.0.1
 */