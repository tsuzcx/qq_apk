package com.tencent.qqmail.card.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class QMCardBaseCursor$1
  implements Runnable
{
  QMCardBaseCursor$1(QMCardBaseCursor paramQMCardBaseCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onBeforeRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardBaseCursor.1
 * JD-Core Version:    0.7.0.1
 */