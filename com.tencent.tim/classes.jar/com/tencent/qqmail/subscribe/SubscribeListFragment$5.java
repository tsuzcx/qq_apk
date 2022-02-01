package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor;
import java.util.concurrent.Callable;

class SubscribeListFragment$5
  implements Callable<QMSubscribeColumnCursor>
{
  SubscribeListFragment$5(SubscribeListFragment paramSubscribeListFragment, int paramInt) {}
  
  public QMSubscribeColumnCursor call()
    throws Exception
  {
    QMSubscribeColumnCursor localQMSubscribeColumnCursor = QMMailManager.sharedInstance().getSubscribeColumnCursor(this.val$accountId);
    localQMSubscribeColumnCursor.setOnRefresh(new SubscribeListFragment.5.1(this));
    localQMSubscribeColumnCursor.setThreadWrapper(new SubscribeListFragment.5.2(this));
    localQMSubscribeColumnCursor.refresh(true, null);
    return localQMSubscribeColumnCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.5
 * JD-Core Version:    0.7.0.1
 */