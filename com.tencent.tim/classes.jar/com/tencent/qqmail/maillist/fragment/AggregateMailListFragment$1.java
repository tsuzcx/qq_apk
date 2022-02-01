package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class AggregateMailListFragment$1
  implements LoadListWatcher
{
  AggregateMailListFragment$1(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError) {}
  
  public void onPopIn(long paramLong, String paramString)
  {
    AggregateMailListFragment.access$300(this.this$0, new AggregateMailListFragment.1.2(this, paramLong, paramString));
  }
  
  public void onProcess(int paramInt, boolean paramBoolean) {}
  
  public void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AggregateMailListFragment.access$100(this.this$0, new AggregateMailListFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.1
 * JD-Core Version:    0.7.0.1
 */