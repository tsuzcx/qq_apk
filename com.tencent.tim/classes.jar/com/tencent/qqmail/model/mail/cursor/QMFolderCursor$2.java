package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class QMFolderCursor$2
  implements IListCallback
{
  QMFolderCursor$2(QMFolderCursor paramQMFolderCursor) {}
  
  public void error(QMNetworkError paramQMNetworkError) {}
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.this$0.folder.getId(), false);
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null) {
      this.this$0.loadMoreList.add(paramArrayOfLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMFolderCursor.2
 * JD-Core Version:    0.7.0.1
 */