package android.support.v4.widget;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

final class DrawerLayout$ChildAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (!DrawerLayout.includeChildForAccessibility(paramView)) {
      paramAccessibilityNodeInfoCompat.setParent(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.ChildAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */