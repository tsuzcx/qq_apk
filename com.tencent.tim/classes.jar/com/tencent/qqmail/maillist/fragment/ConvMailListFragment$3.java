package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class ConvMailListFragment$3
  implements SyncPhotoWatcher
{
  ConvMailListFragment$3(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    if (ConvMailListFragment.access$200(this.this$0) != null) {
      ConvMailListFragment.access$700(this.this$0, new ConvMailListFragment.3.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.3
 * JD-Core Version:    0.7.0.1
 */