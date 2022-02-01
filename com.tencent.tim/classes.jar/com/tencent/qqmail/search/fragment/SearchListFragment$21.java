package com.tencent.qqmail.search.fragment;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.SearchHistoryManager;

class SearchListFragment$21
  implements View.OnClickListener
{
  SearchListFragment$21(SearchListFragment paramSearchListFragment) {}
  
  public void onClick(View paramView)
  {
    if ((SearchListFragment.access$3900(this.this$0) != null) && (SearchListFragment.access$3900(this.this$0) != paramView)) {
      SearchListFragment.access$3900(this.this$0).setSelected(false);
    }
    if (SearchListFragment.access$3900(this.this$0) != paramView)
    {
      SearchListFragment.access$3902(this.this$0, paramView);
      paramView.setSelected(true);
      SearchListFragment.access$4002(this.this$0, true);
      this.this$0.hideKeyBoard();
      SearchListFragment.access$4100(this.this$0);
      SearchHistoryManager.setSearchDefaultType(SearchListFragment.access$700(this.this$0));
      if (SearchListFragment.access$2500(this.this$0))
      {
        SearchListFragment.access$2800(this.this$0);
        SearchListFragment.access$4200(this.this$0);
        SearchListFragment.access$2300(this.this$0).removeCallbacks(SearchListFragment.access$4300(this.this$0));
        SearchListFragment.access$2300(this.this$0).postDelayed(SearchListFragment.access$4300(this.this$0), 300L);
      }
      SearchListFragment.access$900(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.21
 * JD-Core Version:    0.7.0.1
 */