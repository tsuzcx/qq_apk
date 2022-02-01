package com.tencent.qqmail.movemail;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;

class ManageFolderActivity$7$2$1
  implements Runnable
{
  ManageFolderActivity$7$2$1(ManageFolderActivity.7.2 param2) {}
  
  public void run()
  {
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(ManageFolderActivity.access$1900(this.this$2.this$1.this$0));
    if (localQMFolder == null) {
      return;
    }
    DataCollector.logEvent("Event_Delete_Folder");
    QMMailManager.sharedInstance().removeFolder(ManageFolderActivity.access$1800(this.this$2.this$1.this$0), localQMFolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.7.2.1
 * JD-Core Version:    0.7.0.1
 */