package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AggregateMailListFragment$7
  implements MailUnReadWatcher
{
  AggregateMailListFragment$7(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (AggregateMailListFragment.access$1300(this.this$0).canHandleUnread(paramArrayOfLong)) {
      AggregateMailListFragment.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.7
 * JD-Core Version:    0.7.0.1
 */