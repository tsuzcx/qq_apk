package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;

class FolderListFragment$1
  implements Runnable
{
  FolderListFragment$1(FolderListFragment paramFolderListFragment, IListFolder paramIListFolder, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (QMFolderManager.sharedInstance().getDisplayUnreadCount((QMFolder)this.val$folder.getData()) > 0) {
      DataCollector.logEvent("Event_Folder_Mark_Read_When_Unread");
    }
    for (;;)
    {
      QMMailManager.sharedInstance().markFolderMailAllRead(FolderListFragment.access$1300(this.this$0), this.val$accountId, this.val$folderId);
      return;
      DataCollector.logEvent("Event_Folder_Mark_Read");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.1
 * JD-Core Version:    0.7.0.1
 */