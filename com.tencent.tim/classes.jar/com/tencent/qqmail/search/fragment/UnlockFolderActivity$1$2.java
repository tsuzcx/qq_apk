package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.view.FolderLockDialog;

class UnlockFolderActivity$1$2
  implements Runnable
{
  UnlockFolderActivity$1$2(UnlockFolderActivity.1 param1) {}
  
  public void run()
  {
    UnlockFolderActivity.access$000(this.this$1.this$0).cancelDialog();
    UnlockFolderActivity.access$000(this.this$1.this$0).dismissTips();
    UnlockFolderActivity.access$000(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.UnlockFolderActivity.1.2
 * JD-Core Version:    0.7.0.1
 */