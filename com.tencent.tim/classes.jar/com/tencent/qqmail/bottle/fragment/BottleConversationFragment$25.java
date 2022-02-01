package com.tencent.qqmail.bottle.fragment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleConversationController;
import com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter;
import com.tencent.qqmail.bottle.view.ReplyListView;

class BottleConversationFragment$25
  implements AbsListView.OnScrollListener
{
  BottleConversationFragment$25(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    BottleConversationFragment.access$2302(this.this$0, paramInt1 + paramInt2 - BottleConversationFragment.access$400(this.this$0).getHeaderViewsCount() - BottleConversationFragment.access$400(this.this$0).getFooterViewsCount());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((paramInt == 0) && (BottleConversationFragment.access$1600(this.this$0) != null) && (BottleConversationFragment.access$2300(this.this$0) == BottleConversationFragment.access$1600(this.this$0).getCount()) && (BottleConversationFragment.access$1600(this.this$0).cursorCanLoadMore())) {
      BottleConversationFragment.access$700(this.this$0).loadMore(BottleConversationFragment.access$500(this.this$0), BottleConversationFragment.access$1600(this.this$0).getCursor());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.25
 * JD-Core Version:    0.7.0.1
 */