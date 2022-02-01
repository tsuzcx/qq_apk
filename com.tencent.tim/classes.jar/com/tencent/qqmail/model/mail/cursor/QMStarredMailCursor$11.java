package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailCGIManager;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMStarredMailCursor$11
  implements Observable.OnSubscribe<Integer>
{
  QMStarredMailCursor$11(QMStarredMailCursor paramQMStarredMailCursor, int paramInt) {}
  
  public void call(Subscriber<? super Integer> paramSubscriber)
  {
    paramSubscriber = new QMStarredMailCursor.11.1(this, paramSubscriber);
    this.this$0.cgiMgr.loadList(this.val$folderId, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.11
 * JD-Core Version:    0.7.0.1
 */