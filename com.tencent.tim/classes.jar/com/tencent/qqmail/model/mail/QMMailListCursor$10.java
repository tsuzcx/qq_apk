package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class QMMailListCursor$10
  implements Runnable
{
  QMMailListCursor$10(QMMailListCursor paramQMMailListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onRefreshComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.10
 * JD-Core Version:    0.7.0.1
 */