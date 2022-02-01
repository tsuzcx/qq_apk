package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailManager.LoadListType;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import rx.functions.Action0;

class QMStarredMailCursor$1
  implements Action0
{
  QMStarredMailCursor$1(QMStarredMailCursor paramQMStarredMailCursor) {}
  
  public void call()
  {
    QMWatcherCenter.triggerLoadListSuccess(this.this$0.getActualFolderId(), QMMailManager.LoadListType.LOAD_LIST, 0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.1
 * JD-Core Version:    0.7.0.1
 */