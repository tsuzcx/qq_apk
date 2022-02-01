package com.tencent.mobileqq.mini.entry;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.ARMapHongBaoListView;

class MiniAppEntryLayout$1
  extends RecyclerView.OnScrollListener
{
  MiniAppEntryLayout$1(MiniAppEntryLayout paramMiniAppEntryLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      MiniAppEntryLayout.exposureReport();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((MiniAppEntryLayout.access$000(this.this$0) != null) && (MiniAppEntryLayout.access$000(this.this$0).isDirty())) {
      MiniAppEntryLayout.access$000(this.this$0).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout.1
 * JD-Core Version:    0.7.0.1
 */