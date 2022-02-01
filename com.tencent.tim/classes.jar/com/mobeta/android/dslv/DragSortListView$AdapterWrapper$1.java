package com.mobeta.android.dslv;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.mobeta.android.dslv.DragSortListView.AdapterWrapper.1
 * JD-Core Version:    0.7.0.1
 */