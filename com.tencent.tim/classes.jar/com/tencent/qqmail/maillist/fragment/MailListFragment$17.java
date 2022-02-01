package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import java.util.concurrent.Callable;

class MailListFragment$17
  implements Callable<QMMailListCursor>
{
  MailListFragment$17(MailListFragment paramMailListFragment) {}
  
  public QMMailListCursor call()
  {
    QMMailListCursor localQMMailListCursor = QMMailManager.sharedInstance().getMailListCursor(MailListFragment.access$2200(this.this$0), MailListFragment.access$2400(this.this$0));
    if (localQMMailListCursor != null)
    {
      localQMMailListCursor.setOnRefresh(new MailListFragment.17.1(this));
      localQMMailListCursor.setThreadWrapper(new MailListFragment.17.2(this));
      localQMMailListCursor.refresh(localQMMailListCursor.isOverdue(), null);
    }
    return localQMMailListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.17
 * JD-Core Version:    0.7.0.1
 */