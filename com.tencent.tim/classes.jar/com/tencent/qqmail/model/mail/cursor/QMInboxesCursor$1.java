package com.tencent.qqmail.model.mail.cursor;

import android.util.SparseBooleanArray;
import com.tencent.qqmail.model.mail.QMMailManager.LoadListType;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class QMInboxesCursor$1
  implements IListCallback
{
  QMInboxesCursor$1(QMInboxesCursor paramQMInboxesCursor, int paramInt1, int paramInt2) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggerLoadListError(this.val$allInboxesId, paramQMNetworkError);
    QMInboxesCursor.access$000(this.this$0).delete(this.val$folderId);
    if (QMInboxesCursor.access$000(this.this$0).size() == 0) {
      this.this$0.isLoadingMore = false;
    }
  }
  
  public void process()
  {
    int i = this.val$allInboxesId;
    if (!this.this$0.isLoadingMore) {}
    for (boolean bool = true;; bool = false)
    {
      QMWatcherCenter.triggerLoadListProcess(i, bool);
      return;
    }
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null) {
      this.this$0.loadMoreList.add(QMHybridMailListCursor.convertArray(paramArrayOfLong));
    }
    int j = this.val$allInboxesId;
    QMMailManager.LoadListType localLoadListType = QMMailManager.LoadListType.LOAD_MORE;
    int i;
    if (paramArrayOfLong != null)
    {
      i = paramArrayOfLong.length;
      if (this.this$0.isLoadingMore) {
        break label99;
      }
    }
    label99:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QMWatcherCenter.triggerLoadListSuccess(j, localLoadListType, i, paramBoolean);
      QMInboxesCursor.access$000(this.this$0).delete(this.val$folderId);
      if (QMInboxesCursor.access$000(this.this$0).size() == 0) {
        this.this$0.isLoadingMore = false;
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMInboxesCursor.1
 * JD-Core Version:    0.7.0.1
 */