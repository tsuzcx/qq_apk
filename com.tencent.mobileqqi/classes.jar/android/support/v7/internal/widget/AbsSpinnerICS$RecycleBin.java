package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

class AbsSpinnerICS$RecycleBin
{
  private final SparseArray mScrapHeap = new SparseArray();
  
  AbsSpinnerICS$RecycleBin(AbsSpinnerICS paramAbsSpinnerICS) {}
  
  void clear()
  {
    SparseArray localSparseArray = this.mScrapHeap;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinnerICS.access$100(this.this$0, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  View get(int paramInt)
  {
    View localView = (View)this.mScrapHeap.get(paramInt);
    if (localView != null) {
      this.mScrapHeap.delete(paramInt);
    }
    return localView;
  }
  
  public void put(int paramInt, View paramView)
  {
    this.mScrapHeap.put(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerICS.RecycleBin
 * JD-Core Version:    0.7.0.1
 */