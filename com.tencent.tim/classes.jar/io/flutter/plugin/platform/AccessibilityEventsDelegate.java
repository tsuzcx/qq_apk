package io.flutter.plugin.platform;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import io.flutter.view.AccessibilityBridge;

class AccessibilityEventsDelegate
{
  private AccessibilityBridge accessibilityBridge;
  
  public boolean requestSendAccessibilityEvent(@NonNull View paramView1, @NonNull View paramView2, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    if (this.accessibilityBridge == null) {
      return false;
    }
    return this.accessibilityBridge.externalViewRequestSendAccessibilityEvent(paramView1, paramView2, paramAccessibilityEvent);
  }
  
  void setAccessibilityBridge(@Nullable AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityBridge = paramAccessibilityBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.platform.AccessibilityEventsDelegate
 * JD-Core Version:    0.7.0.1
 */