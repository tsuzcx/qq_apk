package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;

class FolderListFragment$47
  implements QMUnlockFolderPwdWatcher
{
  FolderListFragment$47(FolderListFragment paramFolderListFragment, QMFolder paramQMFolder, int paramInt) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    FolderListFragment.access$8100(this.this$0, new FolderListFragment.47.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    FolderListFragment.access$8000(this.this$0, new FolderListFragment.47.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.47
 * JD-Core Version:    0.7.0.1
 */