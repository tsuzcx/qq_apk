package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class SearchListFragment$7
  implements SyncPhotoWatcher
{
  SearchListFragment$7(SearchListFragment paramSearchListFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    SearchListFragment.access$1200(this.this$0, new SearchListFragment.7.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.7
 * JD-Core Version:    0.7.0.1
 */