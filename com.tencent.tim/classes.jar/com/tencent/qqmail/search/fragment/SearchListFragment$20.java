package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.maillist.SearchHistoryManager;
import moai.oss.KvHelper;

class SearchListFragment$20
  implements SearchHistoryAdaptor.SearchHistoryListener
{
  SearchListFragment$20(SearchListFragment paramSearchListFragment) {}
  
  public void delete(int paramInt)
  {
    SearchHistoryManager localSearchHistoryManager = SearchListFragment.access$3700(this.this$0);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < SearchListFragment.access$3700(this.this$0).size())
      {
        SearchListFragment.access$3700(this.this$0).remove(paramInt);
        SearchListFragment.access$3700(this.this$0).save();
      }
      SearchListFragment.access$3800(this.this$0);
      KvHelper.eventSearchHistoryDelete(new double[0]);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.20
 * JD-Core Version:    0.7.0.1
 */