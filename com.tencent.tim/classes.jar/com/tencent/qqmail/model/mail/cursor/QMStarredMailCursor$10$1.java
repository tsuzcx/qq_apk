package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import rx.Subscriber;

class QMStarredMailCursor$10$1
  implements IListCallback
{
  QMStarredMailCursor$10$1(QMStarredMailCursor.10 param10, Subscriber paramSubscriber) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    this.val$observer.onError(paramQMNetworkError);
  }
  
  public void process()
  {
    QMWatcherCenter.triggerLoadListProcess(this.this$1.this$0.getActualFolderId(), false);
  }
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    this.val$observer.onNext(QMHybridMailListCursor.convertArray(paramArrayOfLong));
    this.val$observer.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.10.1
 * JD-Core Version:    0.7.0.1
 */