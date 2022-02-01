package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SearchListFragment$5
  implements MailUnReadWatcher
{
  SearchListFragment$5(SearchListFragment paramSearchListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    SearchListFragment.access$1100(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.5
 * JD-Core Version:    0.7.0.1
 */