package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMStarredMailCursor$10
  implements Observable.OnSubscribe<ArrayList<Long>>
{
  QMStarredMailCursor$10(QMStarredMailCursor paramQMStarredMailCursor, QMFolder paramQMFolder) {}
  
  public void call(Subscriber<? super ArrayList<Long>> paramSubscriber)
  {
    paramSubscriber = new QMStarredMailCursor.10.1(this, paramSubscriber);
    this.this$0.cgiMgr.loadMore(this.val$folder, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.10
 * JD-Core Version:    0.7.0.1
 */