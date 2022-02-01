package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;

class MiniAppDesktopAdapter$DesktopModuleListViewHolder$1
  extends RecyclerView.AdapterDataObserver
{
  MiniAppDesktopAdapter$DesktopModuleListViewHolder$1(MiniAppDesktopAdapter.DesktopModuleListViewHolder paramDesktopModuleListViewHolder, MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.this$1.mRecycleView.scrollToPosition(0);
    }
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).onDataDirtyFromAdapter(this.this$1.mModuleInfo.mModuleType, this.this$1.mAdapter.getData());
    MiniAppDesktopAdapter.DesktopModuleListViewHolder.access$3300(this.this$1);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      this.this$1.mRecycleView.scrollToPosition(0);
    }
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).onDataDirtyFromAdapter(this.this$1.mModuleInfo.mModuleType, this.this$1.mAdapter.getData());
    MiniAppDesktopAdapter.DesktopModuleListViewHolder.access$3300(this.this$1);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).onDataDirtyFromAdapter(this.this$1.mModuleInfo.mModuleType, this.this$1.mAdapter.getData());
    MiniAppDesktopAdapter.DesktopModuleListViewHolder.access$3300(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopModuleListViewHolder.1
 * JD-Core Version:    0.7.0.1
 */