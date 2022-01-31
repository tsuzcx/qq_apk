package android.support.v7.widget;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;

class ActivityChooserView$3
  extends View.AccessibilityDelegate
{
  ActivityChooserView$3(ActivityChooserView paramActivityChooserView) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCanOpenPopup(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.3
 * JD-Core Version:    0.7.0.1
 */