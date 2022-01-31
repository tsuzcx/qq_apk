package android.support.v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

class FocusStrategy$SequentialComparator
  implements Comparator
{
  private final FocusStrategy.BoundsAdapter mAdapter;
  private final boolean mIsLayoutRtl;
  private final Rect mTemp1 = new Rect();
  private final Rect mTemp2 = new Rect();
  
  FocusStrategy$SequentialComparator(boolean paramBoolean, FocusStrategy.BoundsAdapter paramBoundsAdapter)
  {
    this.mIsLayoutRtl = paramBoolean;
    this.mAdapter = paramBoundsAdapter;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = 1;
    int i = 1;
    Rect localRect1 = this.mTemp1;
    Rect localRect2 = this.mTemp2;
    this.mAdapter.obtainBounds(paramObject1, localRect1);
    this.mAdapter.obtainBounds(paramObject2, localRect2);
    if (localRect1.top < localRect2.top) {}
    do
    {
      do
      {
        do
        {
          return -1;
          if (localRect1.top > localRect2.top) {
            return 1;
          }
          if (localRect1.left < localRect2.left)
          {
            if (this.mIsLayoutRtl) {}
            for (;;)
            {
              return i;
              i = -1;
            }
          }
          if (localRect1.left <= localRect2.left) {
            break;
          }
        } while (this.mIsLayoutRtl);
        return 1;
      } while (localRect1.bottom < localRect2.bottom);
      if (localRect1.bottom > localRect2.bottom) {
        return 1;
      }
      if (localRect1.right < localRect2.right)
      {
        if (this.mIsLayoutRtl) {}
        for (i = j;; i = -1) {
          return i;
        }
      }
      if (localRect1.right <= localRect2.right) {
        break;
      }
    } while (this.mIsLayoutRtl);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.FocusStrategy.SequentialComparator
 * JD-Core Version:    0.7.0.1
 */