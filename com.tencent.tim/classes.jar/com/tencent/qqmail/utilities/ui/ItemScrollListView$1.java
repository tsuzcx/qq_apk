package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ItemScrollListView$1
  implements View.OnClickListener
{
  ItemScrollListView$1(ItemScrollListView paramItemScrollListView) {}
  
  public void onClick(View paramView)
  {
    if (ItemScrollListView.access$000(this.this$0) != null) {
      ItemScrollListView.access$000(this.this$0).onRightViewClick(paramView, ItemScrollListView.access$100(this.this$0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ItemScrollListView.1
 * JD-Core Version:    0.7.0.1
 */