package com.tencent.qqmail.movemail;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.DataCollector;

class ManageFolderActivity$9
  implements Runnable
{
  ManageFolderActivity$9(ManageFolderActivity paramManageFolderActivity, String paramString) {}
  
  public void run()
  {
    if (ManageFolderActivity.access$600(this.this$0)) {}
    for (String str = "Event_Rename_Tag";; str = "Event_Rename_Folder")
    {
      DataCollector.logEvent(str);
      QMMailManager.sharedInstance().renameFolder(ManageFolderActivity.access$500(this.this$0), QMFolderManager.sharedInstance().getFolder(ManageFolderActivity.access$1900(this.this$0)), this.val$newFolderName, ManageFolderActivity.access$600(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.9
 * JD-Core Version:    0.7.0.1
 */