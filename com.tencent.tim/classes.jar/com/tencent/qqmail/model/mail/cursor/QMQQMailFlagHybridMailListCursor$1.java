package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailManager.LoadListType;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMQQMailFlagHybridMailListCursor$1
  implements IListCallback
{
  QMQQMailFlagHybridMailListCursor$1(QMQQMailFlagHybridMailListCursor paramQMQQMailFlagHybridMailListCursor) {}
  
  public void error(QMNetworkError paramQMNetworkError) {}
  
  public void process() {}
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    QMWatcherCenter.triggerLoadListSuccess(this.this$0.getActualFolderId(), QMMailManager.LoadListType.LOAD_LIST, 0, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMQQMailFlagHybridMailListCursor.1
 * JD-Core Version:    0.7.0.1
 */