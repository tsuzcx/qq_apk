package com.tencent.qqmail.folderlist;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;

class QMFolderManager$3
  implements Runnable
{
  QMFolderManager$3(QMFolderManager paramQMFolderManager, QMFolderManager.HybirdFolderCallback paramHybirdFolderCallback, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = this.val$query.getUnreadCount(this.val$id);
    boolean bool = this.val$query.hasNewMail();
    QMFolderManager.access$200(this.this$0).put(this.val$id, i);
    QMFolderManager.access$300(this.this$0).put(this.val$id, bool);
    RequestFilter.resetRequestRunningState(this.val$req);
    QMWatcherCenter.triggerFolderUnreadCountUpdate(this.val$id, i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.QMFolderManager.3
 * JD-Core Version:    0.7.0.1
 */