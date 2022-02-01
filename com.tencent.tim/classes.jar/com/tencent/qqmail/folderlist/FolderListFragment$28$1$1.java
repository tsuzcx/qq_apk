package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.movemail.ManageFolderActivity;
import com.tencent.qqmail.view.FolderLockDialog;

class FolderListFragment$28$1$1
  implements Runnable
{
  FolderListFragment$28$1$1(FolderListFragment.28.1 param1) {}
  
  public void run()
  {
    FolderListFragment.access$100(this.this$2.this$1.this$0).cancelDialog();
    FolderListFragment.access$100(this.this$2.this$1.this$0).dismissTips();
    this.this$2.this$1.this$0.startActivityForResult(ManageFolderActivity.createIntent(FolderListFragment.access$200(this.this$2.this$1.this$0), null, false, false), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.28.1.1
 * JD-Core Version:    0.7.0.1
 */