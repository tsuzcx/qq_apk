package com.tencent.qqmail.model.mail.cursor;

import java.util.ArrayList;
import rx.Observable;
import rx.functions.Func1;

class QMStarredMailCursor$8
  implements Func1<Throwable, Observable<? extends ArrayList<Long>>>
{
  QMStarredMailCursor$8(QMStarredMailCursor paramQMStarredMailCursor) {}
  
  public Observable<? extends ArrayList<Long>> call(Throwable paramThrowable)
  {
    this.this$0.isLoadingMore = false;
    return QMStarredMailCursor.access$000(this.this$0, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.8
 * JD-Core Version:    0.7.0.1
 */