package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class FolderListFragment$6
  implements MailDeleteWatcher
{
  FolderListFragment$6(FolderListFragment paramFolderListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    FolderListFragment.access$1900(this.this$0, new FolderListFragment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.6
 * JD-Core Version:    0.7.0.1
 */