package com.tencent.mobileqq.emosm.view;

import android.util.SparseIntArray;
import java.util.ArrayList;

class DragSortListView$HeightCache
{
  private SparseIntArray mMap;
  private int mMaxSize;
  private ArrayList mOrder;
  
  public DragSortListView$HeightCache(DragSortListView paramDragSortListView, int paramInt)
  {
    this.mMap = new SparseIntArray(paramInt);
    this.mOrder = new ArrayList(paramInt);
    this.mMaxSize = paramInt;
  }
  
  public void add(int paramInt1, int paramInt2)
  {
    int i = this.mMap.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i != -1) {
        break label77;
      }
      if (this.mMap.size() == this.mMaxSize) {
        this.mMap.delete(((Integer)this.mOrder.remove(0)).intValue());
      }
    }
    for (;;)
    {
      this.mMap.put(paramInt1, paramInt2);
      this.mOrder.add(Integer.valueOf(paramInt1));
      return;
      label77:
      this.mOrder.remove(Integer.valueOf(paramInt1));
    }
  }
  
  public void clear()
  {
    this.mMap.clear();
    this.mOrder.clear();
  }
  
  public int get(int paramInt)
  {
    return this.mMap.get(paramInt, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.HeightCache
 * JD-Core Version:    0.7.0.1
 */