package com.tencent.qqmail.movemail;

import android.content.Intent;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class ManageFolderActivity$1$1
  implements Runnable
{
  ManageFolderActivity$1$1(ManageFolderActivity.1 param1, QMFolder paramQMFolder, QMFolderManager.FolderOperationType paramFolderOperationType, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$folder != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("folderId", this.val$folder.getId());
      localIntent.putExtra("folderopertype", this.val$type);
      localIntent.putExtra("createRule", this.val$createRule);
      QMLog.log(4, "ManageFolderActivity", "afterCreateRule: ManageFolder - createRule:" + this.val$createRule + ", folderId:" + this.val$folder.getId());
      this.this$1.this$0.setResult(-1, localIntent);
    }
    ManageFolderActivity.access$000(this.this$1.this$0).setCallback(new ManageFolderActivity.1.1.1(this));
    ManageFolderActivity.access$000(this.this$1.this$0).showSuccess(this.val$type.getSuccessHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.1.1
 * JD-Core Version:    0.7.0.1
 */