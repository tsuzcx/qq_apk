package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.view.FolderLockDialog;

class AttachFolderListFragment$2$2
  implements Runnable
{
  AttachFolderListFragment$2$2(AttachFolderListFragment.2 param2) {}
  
  public void run()
  {
    AttachFolderListFragment.access$400(this.this$1.this$0).cancelDialog();
    AttachFolderListFragment.access$400(this.this$1.this$0).dismissTips();
    AttachFolderListFragment.access$400(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment.2.2
 * JD-Core Version:    0.7.0.1
 */