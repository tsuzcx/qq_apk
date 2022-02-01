package com.tencent.qqmail.search.fragment;

import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;

class SearchListFragment$22$1
  implements Runnable
{
  SearchListFragment$22$1(SearchListFragment.22 param22) {}
  
  private boolean hasInitNewSearchDuringSearching()
  {
    return (SearchListFragment.access$1700(this.this$1.this$0) != null) && (SearchListFragment.access$1700(this.this$1.this$0).getSearchRemark().equals("empty"));
  }
  
  public void run()
  {
    if (hasInitNewSearchDuringSearching()) {
      SearchListFragment.access$4200(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.22.1
 * JD-Core Version:    0.7.0.1
 */