package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class FolderListFragment$45$1
  implements Runnable
{
  FolderListFragment$45$1(FolderListFragment.45 param45) {}
  
  public void run()
  {
    FolderListFragment.access$000(this.this$1.this$0).onRefreshComplete();
    FolderListFragment.access$7200(this.this$1.this$0, false);
    QMLog.log(4, "FolderListFragment", "Topbar-debug syncWatcher success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.45.1
 * JD-Core Version:    0.7.0.1
 */