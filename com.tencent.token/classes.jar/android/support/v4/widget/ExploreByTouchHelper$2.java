package android.support.v4.widget;

import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

final class ExploreByTouchHelper$2
  implements FocusStrategy.CollectionAdapter
{
  public AccessibilityNodeInfoCompat get(SparseArrayCompat paramSparseArrayCompat, int paramInt)
  {
    return (AccessibilityNodeInfoCompat)paramSparseArrayCompat.valueAt(paramInt);
  }
  
  public int size(SparseArrayCompat paramSparseArrayCompat)
  {
    return paramSparseArrayCompat.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ExploreByTouchHelper.2
 * JD-Core Version:    0.7.0.1
 */