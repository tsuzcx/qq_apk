package io.flutter.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

class AccessibilityBridge$4
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  AccessibilityBridge$4(AccessibilityBridge paramAccessibilityBridge, AccessibilityManager paramAccessibilityManager) {}
  
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      AccessibilityBridge.access$902(this.this$0, AccessibilityBridge.access$900(this.this$0) | AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
    }
    for (;;)
    {
      AccessibilityBridge.access$1000(this.this$0);
      if (AccessibilityBridge.access$600(this.this$0) != null) {
        AccessibilityBridge.access$600(this.this$0).onAccessibilityChanged(this.val$accessibilityManager.isEnabled(), paramBoolean);
      }
      return;
      AccessibilityBridge.access$1100(this.this$0);
      AccessibilityBridge.access$902(this.this$0, AccessibilityBridge.access$900(this.this$0) & (AccessibilityBridge.AccessibilityFeature.ACCESSIBLE_NAVIGATION.value ^ 0xFFFFFFFF));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.4
 * JD-Core Version:    0.7.0.1
 */