package com.tencent.qqmail.card.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCardBaseCursor$3$1
  implements Runnable
{
  QMCardBaseCursor$3$1(QMCardBaseCursor.3 param3) {}
  
  public void run()
  {
    QMCardBaseCursor.access$102(this.this$1.this$0, QMCardBaseCursor.access$200(this.this$1.this$0));
    if (this.this$1.val$refreshCallback != null)
    {
      QMLog.log(4, "QMCardDataListBaseCursor", "refresh cursor complete");
      this.this$1.val$refreshCallback.onRefreshComplete();
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardBaseCursor.3.1
 * JD-Core Version:    0.7.0.1
 */