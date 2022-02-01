package com.tencent.qqmail.namelist.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class NameListBaseCursor$1
  implements Runnable
{
  NameListBaseCursor$1(NameListBaseCursor paramNameListBaseCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onBeforeRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListBaseCursor.1
 * JD-Core Version:    0.7.0.1
 */