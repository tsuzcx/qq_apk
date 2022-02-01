package me.ele.uetool.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HierarchyView$1
  extends LinearLayoutManager
{
  HierarchyView$1(HierarchyView paramHierarchyView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void scrollToPosition(int paramInt)
  {
    scrollToPositionWithOffset(paramInt, 0);
    EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.HierarchyView.1
 * JD-Core Version:    0.7.0.1
 */