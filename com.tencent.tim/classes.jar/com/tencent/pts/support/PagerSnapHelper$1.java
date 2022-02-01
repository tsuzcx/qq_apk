package com.tencent.pts.support;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class PagerSnapHelper$1
  extends RecyclerView.AdapterDataObserver
{
  PagerSnapHelper$1(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void onPagerDataChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= PagerSnapHelper.access$700(this.this$0)) && (paramInt1 + paramInt2 - 1 >= PagerSnapHelper.access$700(this.this$0)))
    {
      PagerSnapHelper.OnLayoutChangedListenerImpl.access$1302(PagerSnapHelper.access$1200(this.this$0), true);
      PagerSnapHelper.access$100(this.this$0).addOnLayoutChangeListener(PagerSnapHelper.access$1200(this.this$0));
      PagerSnapHelper.access$100(this.this$0).requestLayout();
    }
  }
  
  public void onChanged()
  {
    onPagerDataChanged(0, PagerSnapHelper.access$000(this.this$0).getItemCount());
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.access$700(this.this$0)) {
      PagerSnapHelper.access$702(this.this$0, PagerSnapHelper.access$700(this.this$0) + paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == PagerSnapHelper.access$700(this.this$0)) {
      PagerSnapHelper.access$702(this.this$0, paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.access$700(this.this$0)) {
      PagerSnapHelper.access$702(this.this$0, PagerSnapHelper.access$700(this.this$0) - paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */