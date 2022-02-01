package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchHistoryAdaptor$1
  implements View.OnClickListener
{
  SearchHistoryAdaptor$1(SearchHistoryAdaptor paramSearchHistoryAdaptor, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (SearchHistoryAdaptor.access$000(this.this$0) != null) {
      SearchHistoryAdaptor.access$000(this.this$0).delete(this.val$position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchHistoryAdaptor.1
 * JD-Core Version:    0.7.0.1
 */