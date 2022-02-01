package com.tencent.qqmail.popularize.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PopularizeSubscribeItemView$1
  implements View.OnClickListener
{
  PopularizeSubscribeItemView$1(PopularizeSubscribeItemView paramPopularizeSubscribeItemView) {}
  
  public void onClick(View paramView)
  {
    if (PopularizeSubscribeItemView.access$000(this.this$0) != null) {
      PopularizeSubscribeItemView.access$000(this.this$0).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeSubscribeItemView.1
 * JD-Core Version:    0.7.0.1
 */