package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ViewPager$MyAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  ViewPager$MyAccessibilityDelegate(ViewPager paramViewPager) {}
  
  private boolean canScroll()
  {
    return (this.this$0.mAdapter != null) && (this.this$0.mAdapter.getCount() > 1);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(canScroll());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.this$0.mAdapter != null))
    {
      paramAccessibilityEvent.setItemCount(this.this$0.mAdapter.getCount());
      paramAccessibilityEvent.setFromIndex(this.this$0.mCurItem);
      paramAccessibilityEvent.setToIndex(this.this$0.mCurItem);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
    if (this.this$0.canScrollHorizontally(1)) {
      paramAccessibilityNodeInfoCompat.addAction(4096);
    }
    if (this.this$0.canScrollHorizontally(-1)) {
      paramAccessibilityNodeInfoCompat.addAction(8192);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (this.this$0.canScrollHorizontally(1))
      {
        this.this$0.setCurrentItem(this.this$0.mCurItem + 1);
        return true;
      }
      return false;
    }
    if (this.this$0.canScrollHorizontally(-1))
    {
      this.this$0.setCurrentItem(this.this$0.mCurItem - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager.MyAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */