package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchHistoryAdaptor$2
  implements View.OnClickListener
{
  SearchHistoryAdaptor$2(SearchHistoryAdaptor paramSearchHistoryAdaptor, AbsListView paramAbsListView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$listView != null) && (this.val$listView.getOnItemClickListener() != null)) {
      this.val$listView.getOnItemClickListener().onItemClick(this.val$listView, paramView, this.val$position, 0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchHistoryAdaptor.2
 * JD-Core Version:    0.7.0.1
 */