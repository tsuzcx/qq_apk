package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import rx.Subscriber;

class QMStarredMailCursor$12$1
  implements IListCallback
{
  QMStarredMailCursor$12$1(QMStarredMailCursor.12 param12, Subscriber paramSubscriber) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    this.val$subscriber.onError(paramQMNetworkError);
  }
  
  public void process() {}
  
  public void success(long[] paramArrayOfLong, boolean paramBoolean)
  {
    this.val$subscriber.onNext(Integer.valueOf(QMStarredMailCursor.access$100(this.this$1.this$0)));
    this.val$subscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.12.1
 * JD-Core Version:    0.7.0.1
 */