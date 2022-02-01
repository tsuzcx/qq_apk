package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailManager.LoadListType;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class QMHybridMailListCursor$1
  implements IListCallback
{
  QMHybridMailListCursor$1(QMHybridMailListCursor paramQMHybridMailListCursor) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggerLoadListError(this.this$0.getActualFolderId(), paramQMNetworkError);
    this.this$0.isLoadingMore = false;
  }
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.this$0.getActualFolderId(), false);
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null) {
      this.this$0.loadMoreList.add(QMHybridMailListCursor.convertArray(paramArrayOfLong));
    }
    int j = this.this$0.getActualFolderId();
    QMMailManager.LoadListType localLoadListType = QMMailManager.LoadListType.LOAD_MORE;
    if (paramArrayOfLong != null) {}
    for (int i = paramArrayOfLong.length;; i = 0)
    {
      QMWatcherCenter.triggerLoadListSuccess(j, localLoadListType, i, false);
      this.this$0.isLoadingMore = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMHybridMailListCursor.1
 * JD-Core Version:    0.7.0.1
 */