package io.flutter.view;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.Global;

class AccessibilityBridge$3
  extends ContentObserver
{
  AccessibilityBridge$3(AccessibilityBridge paramAccessibilityBridge, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    onChange(paramBoolean, null);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    int i;
    if (Build.VERSION.SDK_INT < 17)
    {
      paramUri = null;
      if ((paramUri == null) || (!paramUri.equals("0"))) {
        break label75;
      }
      i = 1;
      label25:
      if (i == 0) {
        break label80;
      }
      AccessibilityBridge.access$902(this.this$0, AccessibilityBridge.access$900(this.this$0) | AccessibilityBridge.AccessibilityFeature.DISABLE_ANIMATIONS.value);
    }
    for (;;)
    {
      AccessibilityBridge.access$1000(this.this$0);
      return;
      paramUri = Settings.Global.getString(AccessibilityBridge.access$800(this.this$0), "transition_animation_scale");
      break;
      label75:
      i = 0;
      break label25;
      label80:
      AccessibilityBridge.access$902(this.this$0, AccessibilityBridge.access$900(this.this$0) & (AccessibilityBridge.AccessibilityFeature.DISABLE_ANIMATIONS.value ^ 0xFFFFFFFF));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.3
 * JD-Core Version:    0.7.0.1
 */