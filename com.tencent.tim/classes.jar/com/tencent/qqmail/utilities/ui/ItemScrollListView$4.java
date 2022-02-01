package com.tencent.qqmail.utilities.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ItemScrollListView$4
  implements AbsListView.OnScrollListener
{
  ItemScrollListView$4(ItemScrollListView paramItemScrollListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ItemScrollListView.access$900(this.this$0) != null) {
      ItemScrollListView.access$900(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (ItemScrollListView.access$900(this.this$0) != null) {
      ItemScrollListView.access$900(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (((ItemScrollListView.access$600(this.this$0) & 0x4) == 4) && (paramInt != 0) && (!this.this$0.getAdvertiseMode())) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ItemScrollListView.access$602(this.this$0, 0);
      return;
    case 1: 
      ItemScrollListView.access$602(this.this$0, 1);
      return;
    case 2: 
      ItemScrollListView.access$602(this.this$0, 32);
      return;
    case 100: 
      ItemScrollListView.access$602(this.this$0, 1);
      return;
    }
    ItemScrollListView.access$602(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ItemScrollListView.4
 * JD-Core Version:    0.7.0.1
 */