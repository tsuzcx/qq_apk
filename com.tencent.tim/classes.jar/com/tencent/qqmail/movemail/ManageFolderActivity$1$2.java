package com.tencent.qqmail.movemail;

import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.utilities.ui.QMTips;

class ManageFolderActivity$1$2
  implements Runnable
{
  ManageFolderActivity$1$2(ManageFolderActivity.1 param1, QMFolderManager.FolderOperationType paramFolderOperationType) {}
  
  public void run()
  {
    ManageFolderActivity.access$000(this.this$1.this$0).setCallback(new ManageFolderActivity.1.2.1(this));
    ManageFolderActivity.access$000(this.this$1.this$0).showError(this.val$type.getErrorHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.1.2
 * JD-Core Version:    0.7.0.1
 */