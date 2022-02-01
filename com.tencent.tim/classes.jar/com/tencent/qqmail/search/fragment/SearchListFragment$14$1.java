package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;

class SearchListFragment$14$1
  implements Runnable
{
  SearchListFragment$14$1(SearchListFragment.14 param14) {}
  
  public void run()
  {
    if ((SearchListFragment.access$1700(this.this$1.this$0) != null) && (SearchListFragment.access$1700(this.this$1.this$0).isUsable()) && (SearchListFragment.access$1700(this.this$1.this$0).getLocalCount() < 20) && (SearchListFragment.access$1700(this.this$1.this$0).canLoadMore()))
    {
      SearchListFragment.access$100(this.this$1.this$0).setMoreLoading(true);
      SearchListFragment.access$1700(this.this$1.this$0).loadMore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.14.1
 * JD-Core Version:    0.7.0.1
 */