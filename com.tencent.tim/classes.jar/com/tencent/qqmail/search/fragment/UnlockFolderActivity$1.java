package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class UnlockFolderActivity$1
  implements QMUnlockFolderPwdWatcher
{
  UnlockFolderActivity$1(UnlockFolderActivity paramUnlockFolderActivity) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    UnlockFolderActivity.access$400(this.this$0, new UnlockFolderActivity.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    UnlockFolderActivity.access$300(this.this$0, new UnlockFolderActivity.1.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.UnlockFolderActivity.1
 * JD-Core Version:    0.7.0.1
 */