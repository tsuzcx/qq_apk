package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.util.Timer;
import java.util.TimerTask;

class FolderListFragment$52
  extends TimerTask
{
  FolderListFragment$52(FolderListFragment paramFolderListFragment) {}
  
  public void run()
  {
    QMLog.log(4, "FolderListFragment", "run ping timer");
    if (!QMSyncErrorManager.sharedInstance().isNetworkUnavailable())
    {
      QMLog.log(4, "FolderListFragment", "network available to cancel ping timer");
      if (FolderListFragment.access$8500(this.this$0) != null) {
        FolderListFragment.access$8500(this.this$0).cancel();
      }
      FolderListFragment.access$8502(this.this$0, null);
      return;
    }
    if (QMNetworkUtils.isNetworkAvailable())
    {
      QMLog.log(4, "FolderListFragment", "socket connect success to cancel ping timer");
      QMSyncErrorManager.sharedInstance().setNetworkUnavailable(false);
      QMWatcherCenter.triggerRenderSyncErrorBar();
      if (FolderListFragment.access$8500(this.this$0) != null) {
        FolderListFragment.access$8500(this.this$0).cancel();
      }
      FolderListFragment.access$8502(this.this$0, null);
      return;
    }
    QMLog.log(4, "FolderListFragment", "socket connect fail to continue ping timer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.52
 * JD-Core Version:    0.7.0.1
 */