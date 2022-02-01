package com.tencent.qqmail.folderlist;

import com.tencent.qqmail.model.mail.watcher.QMTaskListChangeWatcher;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTask;

class FolderListFragment$9
  implements QMTaskListChangeWatcher
{
  FolderListFragment$9(FolderListFragment paramFolderListFragment) {}
  
  public void onTaskComplete(QMTask paramQMTask)
  {
    if ((paramQMTask instanceof QMSendMailTask)) {
      FolderListFragment.access$2500(this.this$0, new FolderListFragment.9.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.9
 * JD-Core Version:    0.7.0.1
 */