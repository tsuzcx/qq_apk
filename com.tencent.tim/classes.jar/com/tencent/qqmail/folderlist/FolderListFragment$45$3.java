package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;

class FolderListFragment$45$3
  implements Runnable
{
  FolderListFragment$45$3(FolderListFragment.45 param45) {}
  
  public void run()
  {
    this.this$1.this$0.refreshData();
    if ((FolderListFragment.access$500(this.this$1.this$0) == null) || (FolderListFragment.access$500(this.this$1.this$0).size() <= 0)) {
      FolderListFragment.access$1600(this.this$1.this$0);
    }
    for (;;)
    {
      FolderListFragment.access$7200(this.this$1.this$0, false);
      QMLog.log(4, "FolderListFragment", "Topbar-debug syncWatcher end");
      return;
      this.this$1.this$0.render(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.45.3
 * JD-Core Version:    0.7.0.1
 */