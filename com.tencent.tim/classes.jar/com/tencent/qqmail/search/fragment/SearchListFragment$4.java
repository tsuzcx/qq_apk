package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SearchListFragment$4
  implements MailPurgeDeleteWatcher
{
  SearchListFragment$4(SearchListFragment paramSearchListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    SearchListFragment.access$1100(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.4
 * JD-Core Version:    0.7.0.1
 */