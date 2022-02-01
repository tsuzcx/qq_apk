package com.tencent.qqmail.model.mail.cursor;

import rx.Observable;
import rx.functions.Func1;

class QMStarredMailCursor$5
  implements Func1<Throwable, Observable<? extends Integer>>
{
  QMStarredMailCursor$5(QMStarredMailCursor paramQMStarredMailCursor) {}
  
  public Observable<? extends Integer> call(Throwable paramThrowable)
  {
    return QMStarredMailCursor.access$000(this.this$0, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.5
 * JD-Core Version:    0.7.0.1
 */