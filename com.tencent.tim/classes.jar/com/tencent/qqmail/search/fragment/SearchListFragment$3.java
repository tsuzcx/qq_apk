package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.MailStartWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SearchListFragment$3
  implements MailStartWatcher
{
  SearchListFragment$3(SearchListFragment paramSearchListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    SearchListFragment.access$1100(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.3
 * JD-Core Version:    0.7.0.1
 */