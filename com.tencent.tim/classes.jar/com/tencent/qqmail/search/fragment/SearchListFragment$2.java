package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SearchListFragment$2
  implements MailMoveWatcher
{
  SearchListFragment$2(SearchListFragment paramSearchListFragment) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError) {}
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    SearchListFragment.access$1100(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.2
 * JD-Core Version:    0.7.0.1
 */