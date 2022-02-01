package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailManager.LoadListType;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import java.util.ArrayList;
import rx.functions.Action1;

class QMStarredMailCursor$9
  implements Action1<ArrayList<Long>>
{
  QMStarredMailCursor$9(QMStarredMailCursor paramQMStarredMailCursor) {}
  
  public void call(ArrayList<Long> paramArrayList)
  {
    this.this$0.loadMoreList.add(paramArrayList);
    QMWatcherCenter.triggerLoadListSuccess(this.this$0.getActualFolderId(), QMMailManager.LoadListType.LOAD_MORE, paramArrayList.size(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMStarredMailCursor.9
 * JD-Core Version:    0.7.0.1
 */