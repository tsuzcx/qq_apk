package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class RecyclerViewAccessibilityDelegate$1
  extends AccessibilityDelegateCompat
{
  RecyclerViewAccessibilityDelegate$1(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((!RecyclerViewAccessibilityDelegate.access$000(this.this$0)) && (this.this$0.mRecyclerView.getLayoutManager() != null)) {
      this.this$0.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!RecyclerViewAccessibilityDelegate.access$000(this.this$0)) && (this.this$0.mRecyclerView.getLayoutManager() != null)) {
      return this.this$0.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerViewAccessibilityDelegate.1
 * JD-Core Version:    0.7.0.1
 */