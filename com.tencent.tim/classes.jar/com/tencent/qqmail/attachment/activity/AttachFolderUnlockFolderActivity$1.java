package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class AttachFolderUnlockFolderActivity$1
  implements QMUnlockFolderPwdWatcher
{
  AttachFolderUnlockFolderActivity$1(AttachFolderUnlockFolderActivity paramAttachFolderUnlockFolderActivity) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    AttachFolderUnlockFolderActivity.access$400(this.this$0, new AttachFolderUnlockFolderActivity.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    AttachFolderUnlockFolderActivity.access$300(this.this$0, new AttachFolderUnlockFolderActivity.1.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderUnlockFolderActivity.1
 * JD-Core Version:    0.7.0.1
 */