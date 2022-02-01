package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AggregateMailListFragment$2
  implements MailRejectWatcher
{
  AggregateMailListFragment$2(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    AggregateMailListFragment.access$500(this.this$0).refresh(new AggregateMailListFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.2
 * JD-Core Version:    0.7.0.1
 */