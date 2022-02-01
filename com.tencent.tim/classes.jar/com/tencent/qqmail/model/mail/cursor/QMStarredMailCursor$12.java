package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMStarredMailCursor$12
  implements Observable.OnSubscribe<Integer>
{
  QMStarredMailCursor$12(QMStarredMailCursor paramQMStarredMailCursor, QMFolder paramQMFolder) {}
  
  public void call(Subscriber<? super Integer> paramSubscriber)
  {
    paramSubscriber = new QMStarredMailCursor.12.1(this, paramSubscriber);
    this.this$0.cgiMgr.updateList(this.val$folder, false, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.12
 * JD-Core Version:    0.7.0.1
 */