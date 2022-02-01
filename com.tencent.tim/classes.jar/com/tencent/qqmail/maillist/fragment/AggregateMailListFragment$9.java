package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AggregateMailListFragment$9
  implements MailPurgeDeleteWatcher
{
  AggregateMailListFragment$9(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    if (AggregateMailListFragment.access$1300(this.this$0).canHandleDelete(paramArrayOfLong)) {
      AggregateMailListFragment.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.9
 * JD-Core Version:    0.7.0.1
 */