package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.QMAdMailCursor;
import java.util.concurrent.Callable;

class AggregateMailListFragment$12
  implements Callable<QMMailListCursor>
{
  AggregateMailListFragment$12(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public QMMailListCursor call()
  {
    QMAdMailCursor localQMAdMailCursor = QMMailManager.sharedInstance().getAdvertiseListCursor(AggregateMailListFragment.access$2000(this.this$0));
    localQMAdMailCursor.setOnRefresh(new AggregateMailListFragment.12.1(this));
    localQMAdMailCursor.setThreadWrapper(new AggregateMailListFragment.12.2(this));
    localQMAdMailCursor.refresh(true, null);
    return localQMAdMailCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.12
 * JD-Core Version:    0.7.0.1
 */