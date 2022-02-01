package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class QMMailListCursor$9
  implements Runnable
{
  QMMailListCursor$9(QMMailListCursor paramQMMailListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onBeforeRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.9
 * JD-Core Version:    0.7.0.1
 */