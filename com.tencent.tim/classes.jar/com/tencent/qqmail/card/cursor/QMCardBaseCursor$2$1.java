package com.tencent.qqmail.card.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCardBaseCursor$2$1
  implements Runnable
{
  QMCardBaseCursor$2$1(QMCardBaseCursor.2 param2) {}
  
  public void run()
  {
    if ((!this.this$1.val$cursorInitialized) && (this.this$1.val$refreshCallback != null))
    {
      QMLog.log(4, "QMCardDataListBaseCursor", "refresh cursor complete");
      this.this$1.val$refreshCallback.onRefreshComplete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardBaseCursor.2.1
 * JD-Core Version:    0.7.0.1
 */