package com.tencent.qqmail.search.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class SearchToggleView$1
  implements View.OnClickListener
{
  SearchToggleView$1(SearchToggleView paramSearchToggleView) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.this$0.mClickChain.iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
    if (SearchToggleView.access$000(this.this$0) != null) {
      SearchToggleView.access$000(this.this$0).didDismiss(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.view.SearchToggleView.1
 * JD-Core Version:    0.7.0.1
 */