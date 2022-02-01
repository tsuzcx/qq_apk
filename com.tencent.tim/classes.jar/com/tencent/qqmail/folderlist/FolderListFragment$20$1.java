package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.maillist.view.MailListBarHelper;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import moai.oss.KvHelper;

class FolderListFragment$20$1
  implements Runnable
{
  FolderListFragment$20$1(FolderListFragment.20 param20, int paramInt) {}
  
  public void run()
  {
    IListFolder localIListFolder;
    if ((FolderListFragment.access$800(this.this$1.this$0) != null) && (FolderListFragment.access$800(this.this$1.this$0).canRightScroll(this.val$position)))
    {
      localIListFolder = FolderListFragment.access$800(this.this$1.this$0).getItem(this.val$position);
      if ((localIListFolder != null) && (localIListFolder.getData() != null)) {
        break label63;
      }
    }
    label63:
    label84:
    do
    {
      return;
      if (QMFolderManager.sharedInstance().getDisplayUnreadCount((QMFolder)localIListFolder.getData()) > 0)
      {
        DataCollector.logEvent("Event_Folder_Slide_Mark_Read_When_Unread");
        switch (((QMFolder)localIListFolder.getData()).getId())
        {
        }
      }
      for (;;)
      {
        if (((QMFolder)localIListFolder.getData()).getType() == 130) {
          DataCollector.logEvent("Event_Popularize_Slide_Hide");
        }
        if (QMFolderManager.isAppFolder((QMFolder)localIListFolder.getData())) {
          break;
        }
        if (!MailListBarHelper.shouldShowFolderTopRightView((QMFolder)localIListFolder.getData(), FolderListFragment.access$700(this.this$1.this$0))) {
          break label272;
        }
        KvHelper.eventFolderSwipeShowSetTop(new double[0]);
        return;
        DataCollector.logEvent("Event_Folder_Slide_Mark_Read");
        break label84;
        DataCollector.logEvent("Event_Addressbook_Slide_Hide");
        continue;
        DataCollector.logEvent("Event_Bottle_Slide_Hide");
        continue;
        DataCollector.logEvent("Event_Calendar_Slide_Hide");
        continue;
        DataCollector.logEvent("Event_Ftn_Slide_Hide");
        continue;
        DataCollector.logEvent("Event_Note_Slide_Hide");
        continue;
        DataCollector.logEvent("Event_Card_Slip_Hide");
      }
    } while (!MailListBarHelper.shouldShowFolderShowHomeRightView((QMFolder)localIListFolder.getData(), FolderListFragment.access$700(this.this$1.this$0)));
    label272:
    KvHelper.eventFolderSwipeShowMailBox(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.20.1
 * JD-Core Version:    0.7.0.1
 */