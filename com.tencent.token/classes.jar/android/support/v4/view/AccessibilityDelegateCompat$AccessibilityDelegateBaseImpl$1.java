package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl$1
  extends View.AccessibilityDelegate
{
  AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl$1(AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl paramAccessibilityDelegateBaseImpl, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {}
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.val$compat.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.val$compat.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.val$compat.onInitializeAccessibilityNodeInfo(paramView, AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo));
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.val$compat.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.val$compat.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    this.val$compat.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.val$compat.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl.1
 * JD-Core Version:    0.7.0.1
 */