package com.tencent.mobileqq.emosm.view;

import android.database.DataSetObserver;

class DragSortListView$AdapterWrapper$1
  extends DataSetObserver
{
  DragSortListView$AdapterWrapper$1(DragSortListView.AdapterWrapper paramAdapterWrapper, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.this$1.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.this$1.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.AdapterWrapper.1
 * JD-Core Version:    0.7.0.1
 */