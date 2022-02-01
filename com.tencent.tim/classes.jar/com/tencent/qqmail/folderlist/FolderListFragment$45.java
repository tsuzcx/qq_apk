package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.SyncWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class FolderListFragment$45
  implements SyncWatcher
{
  FolderListFragment$45(FolderListFragment paramFolderListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    DataCollector.logPerformanceEnd("Performance_Check_New_Mail_FolderList_folderlist_" + FolderListFragment.access$200(this.this$0), "");
    FolderListFragment.access$7400(this.this$0, new FolderListFragment.45.2(this));
  }
  
  public void onSuccess(int paramInt)
  {
    DataCollector.logPerformanceEnd("Performance_Check_New_Mail_FolderList_folderlist_" + FolderListFragment.access$200(this.this$0), "");
    FolderListFragment.access$7300(this.this$0, new FolderListFragment.45.1(this));
  }
  
  public void onSyncBegin(int paramInt, boolean paramBoolean) {}
  
  public void onSyncEnd(int paramInt, boolean paramBoolean)
  {
    if (FolderListFragment.access$200(this.this$0) == paramInt) {
      FolderListFragment.access$7500(this.this$0, new FolderListFragment.45.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.45
 * JD-Core Version:    0.7.0.1
 */