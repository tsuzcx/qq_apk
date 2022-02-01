package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class FolderListFragment$45$2
  implements Runnable
{
  FolderListFragment$45$2(FolderListFragment.45 param45) {}
  
  public void run()
  {
    FolderListFragment.access$000(this.this$1.this$0).onRefreshComplete();
    FolderListFragment.access$7200(this.this$1.this$0, false);
    QMLog.log(6, "FolderListFragment", "Topbar-debug syncWatcher error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.45.2
 * JD-Core Version:    0.7.0.1
 */