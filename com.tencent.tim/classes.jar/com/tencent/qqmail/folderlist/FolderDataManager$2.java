package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.LinkedList;

class FolderDataManager$2
  implements Runnable
{
  FolderDataManager$2(FolderDataManager paramFolderDataManager, ArrayList paramArrayList) {}
  
  public void run()
  {
    LinkedList localLinkedList = FolderDataManager.access$000(this.this$0, this.val$homeAppIdList);
    QMLog.log(4, "FolderDataManager", "folderConfig to send:" + localLinkedList);
    QMMailManager.sharedInstance().setApplicationShowInHome(localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderDataManager.2
 * JD-Core Version:    0.7.0.1
 */