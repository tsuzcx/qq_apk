package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.view.FolderLockDialog;

class AttachFolderUnlockFolderActivity$1$2
  implements Runnable
{
  AttachFolderUnlockFolderActivity$1$2(AttachFolderUnlockFolderActivity.1 param1) {}
  
  public void run()
  {
    AttachFolderUnlockFolderActivity.access$000(this.this$1.this$0).cancelDialog();
    AttachFolderUnlockFolderActivity.access$000(this.this$1.this$0).dismissTips();
    AttachFolderUnlockFolderActivity.access$000(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderUnlockFolderActivity.1.2
 * JD-Core Version:    0.7.0.1
 */