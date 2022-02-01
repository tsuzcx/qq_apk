package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class AttachFolderListFragment$2
  implements QMUnlockFolderPwdWatcher
{
  AttachFolderListFragment$2(AttachFolderListFragment paramAttachFolderListFragment) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    AttachFolderListFragment.access$600(this.this$0, new AttachFolderListFragment.2.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    AttachFolderListFragment.access$500(this.this$0, new AttachFolderListFragment.2.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.2
 * JD-Core Version:    0.7.0.1
 */