package com.tencent.viola.ui.view;

import java.util.List;

class VSmartView$1
  extends VPageSliderView.VPagerSliderScrollListener
{
  VSmartView$1(VSmartView paramVSmartView) {}
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < VSmartView.access$200(this.this$0).size())
    {
      VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = (VSmartView.RecyclerViewWrapper)VSmartView.access$200(this.this$0).get(i);
      if (i != paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localRecyclerViewWrapper.ignoreScrollEvent = bool;
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView.1
 * JD-Core Version:    0.7.0.1
 */