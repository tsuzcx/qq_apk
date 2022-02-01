package com.mobeta.android.dslv;

import android.database.DataSetObserver;

class DragSortListView$2
  extends DataSetObserver
{
  DragSortListView$2(DragSortListView paramDragSortListView) {}
  
  private void cancel()
  {
    if (DragSortListView.access$100(this.this$0) == 4) {
      this.this$0.cancelDrag();
    }
  }
  
  public void onChanged()
  {
    cancel();
  }
  
  public void onInvalidated()
  {
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.mobeta.android.dslv.DragSortListView.2
 * JD-Core Version:    0.7.0.1
 */