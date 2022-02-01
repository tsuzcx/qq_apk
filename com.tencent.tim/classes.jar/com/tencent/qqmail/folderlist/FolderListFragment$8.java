package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class FolderListFragment$8
  implements QMUnlockFolderPwdWatcher
{
  FolderListFragment$8(FolderListFragment paramFolderListFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    FolderListFragment.access$2400(this.this$0, new FolderListFragment.8.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    FolderListFragment.access$2300(this.this$0, new FolderListFragment.8.1(this, paramInt2, paramInt2, paramInt1, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.8
 * JD-Core Version:    0.7.0.1
 */