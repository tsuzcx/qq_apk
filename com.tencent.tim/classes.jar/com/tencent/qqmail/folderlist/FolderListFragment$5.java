package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class FolderListFragment$5
  implements MailUnReadWatcher
{
  FolderListFragment$5(FolderListFragment paramFolderListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (FolderListFragment.access$1300(this.this$0).canHandleUnread(paramArrayOfLong))
    {
      this.this$0.refreshData();
      FolderListFragment.access$1700(this.this$0, new FolderListFragment.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.5
 * JD-Core Version:    0.7.0.1
 */