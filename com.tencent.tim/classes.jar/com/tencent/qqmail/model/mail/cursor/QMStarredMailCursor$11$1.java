package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import rx.Subscriber;

class QMStarredMailCursor$11$1
  implements IListCallback
{
  QMStarredMailCursor$11$1(QMStarredMailCursor.11 param11, Subscriber paramSubscriber) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    this.val$subscriber.onError(paramQMNetworkError);
  }
  
  public void process() {}
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    this.val$subscriber.onNext(Integer.valueOf(this.this$1.val$folderId));
    this.val$subscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.11.1
 * JD-Core Version:    0.7.0.1
 */