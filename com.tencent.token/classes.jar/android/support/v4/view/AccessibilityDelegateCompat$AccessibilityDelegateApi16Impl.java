package android.support.v4.view;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;

@RequiresApi(16)
class AccessibilityDelegateCompat$AccessibilityDelegateApi16Impl
  extends AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl
{
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView)
  {
    paramAccessibilityDelegate = paramAccessibilityDelegate.getAccessibilityNodeProvider(paramView);
    if (paramAccessibilityDelegate != null) {
      return new AccessibilityNodeProviderCompat(paramAccessibilityDelegate);
    }
    return null;
  }
  
  public View.AccessibilityDelegate newAccessibilityDelegateBridge(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    return new AccessibilityDelegateCompat.AccessibilityDelegateApi16Impl.1(this, paramAccessibilityDelegateCompat);
  }
  
  public boolean performAccessibilityAction(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle)
  {
    return paramAccessibilityDelegate.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateApi16Impl
 * JD-Core Version:    0.7.0.1
 */