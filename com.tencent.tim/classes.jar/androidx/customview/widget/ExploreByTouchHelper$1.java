package androidx.customview.widget;

import android.graphics.Rect;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

final class ExploreByTouchHelper$1
  implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>
{
  public void obtainBounds(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, Rect paramRect)
  {
    paramAccessibilityNodeInfoCompat.getBoundsInParent(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.customview.widget.ExploreByTouchHelper.1
 * JD-Core Version:    0.7.0.1
 */