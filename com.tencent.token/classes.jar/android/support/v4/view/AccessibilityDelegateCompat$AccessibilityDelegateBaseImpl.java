package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl
{
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView)
  {
    return null;
  }
  
  public View.AccessibilityDelegate newAccessibilityDelegateBridge(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    return new AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl.1(this, paramAccessibilityDelegateCompat);
  }
  
  public boolean performAccessibilityAction(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl
 * JD-Core Version:    0.7.0.1
 */