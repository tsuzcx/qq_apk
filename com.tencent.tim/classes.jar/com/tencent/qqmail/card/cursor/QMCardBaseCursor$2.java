package com.tencent.qqmail.card.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import java.util.concurrent.Callable;

class QMCardBaseCursor$2
  implements Callable<Cursor>
{
  QMCardBaseCursor$2(QMCardBaseCursor paramQMCardBaseCursor, boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback) {}
  
  public Cursor call()
    throws Exception
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    QMCardBaseCursor.access$000(this.this$0).runOnMainThreadWithContext(new QMCardBaseCursor.2.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardBaseCursor.2
 * JD-Core Version:    0.7.0.1
 */