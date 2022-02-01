package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class AggregateMailListFragment$3
  implements SyncPhotoWatcher
{
  AggregateMailListFragment$3(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    if (AggregateMailListFragment.access$200(this.this$0) != null) {
      AggregateMailListFragment.access$700(this.this$0, new AggregateMailListFragment.3.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.3
 * JD-Core Version:    0.7.0.1
 */