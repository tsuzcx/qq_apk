package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;

class ExploreByTouchHelper$MyNodeProvider
  extends AccessibilityNodeProviderCompat
{
  ExploreByTouchHelper$MyNodeProvider(ExploreByTouchHelper paramExploreByTouchHelper) {}
  
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(paramInt));
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    if (paramInt == 2) {}
    for (paramInt = ExploreByTouchHelper.access$000(this.this$0); paramInt == -2147483648; paramInt = ExploreByTouchHelper.access$100(this.this$0)) {
      return null;
    }
    return createAccessibilityNodeInfo(paramInt);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.this$0.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ExploreByTouchHelper.MyNodeProvider
 * JD-Core Version:    0.7.0.1
 */