package com.tencent.mobileqq.util;

import android.os.Build.VERSION;
import android.view.View;

public final class AccessibilityUtil$3
  implements Runnable
{
  public AccessibilityUtil$3(View paramView) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.val$view.sendAccessibilityEvent(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.AccessibilityUtil.3
 * JD-Core Version:    0.7.0.1
 */