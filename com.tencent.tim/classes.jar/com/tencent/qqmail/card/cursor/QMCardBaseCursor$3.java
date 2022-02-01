package com.tencent.qqmail.card.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import java.util.concurrent.Callable;

class QMCardBaseCursor$3
  implements Callable<Cursor>
{
  QMCardBaseCursor$3(QMCardBaseCursor paramQMCardBaseCursor, QMRefreshCallback paramQMRefreshCallback, Cursor paramCursor) {}
  
  public Cursor call()
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    QMCardBaseCursor.access$000(this.this$0).runOnMainThreadWithContext(new QMCardBaseCursor.3.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardBaseCursor.3
 * JD-Core Version:    0.7.0.1
 */