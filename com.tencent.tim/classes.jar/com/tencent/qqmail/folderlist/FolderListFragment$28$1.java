package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class FolderListFragment$28$1
  implements QMUnlockFolderPwdWatcher
{
  FolderListFragment$28$1(FolderListFragment.28 param28) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    FolderListFragment.access$5500(this.this$1.this$0, new FolderListFragment.28.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    FolderListFragment.access$5400(this.this$1.this$0, new FolderListFragment.28.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.28.1
 * JD-Core Version:    0.7.0.1
 */