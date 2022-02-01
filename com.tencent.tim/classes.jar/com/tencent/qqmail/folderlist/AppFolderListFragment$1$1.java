package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;

class AppFolderListFragment$1$1
  implements Runnable
{
  AppFolderListFragment$1$1(AppFolderListFragment.1 param1, int paramInt) {}
  
  public void run()
  {
    IListFolder localIListFolder;
    if ((AppFolderListFragment.access$200(this.this$1.this$0) != null) && (AppFolderListFragment.access$200(this.this$1.this$0).canRightScroll(this.val$position)))
    {
      localIListFolder = AppFolderListFragment.access$200(this.this$1.this$0).getItem(this.val$position);
      if ((localIListFolder != null) && (localIListFolder.getData() != null)) {
        break label63;
      }
    }
    for (;;)
    {
      return;
      label63:
      if (localIListFolder.getData() != null)
      {
        switch (((QMFolder)localIListFolder.getData()).getId())
        {
        }
        while (((QMFolder)localIListFolder.getData()).getType() == 130)
        {
          DataCollector.logEvent("Event_Popularize_Slide_Home");
          return;
          DataCollector.logEvent("Event_Addressbook_Slide_Home");
          continue;
          DataCollector.logEvent("Event_Bottle_Slide_Home");
          continue;
          DataCollector.logEvent("Event_Calendar_Slide_Home");
          continue;
          DataCollector.logEvent("Event_Ftn_Slide_Home");
          continue;
          DataCollector.logEvent("Event_Note_Slide_Home");
          continue;
          DataCollector.logEvent("Event_Card_Slip_Show");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.AppFolderListFragment.1.1
 * JD-Core Version:    0.7.0.1
 */