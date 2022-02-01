package com.tencent.ttpic.baseutils.device;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;

final class DeviceUtils$2
  implements View.OnSystemUiVisibilityChangeListener
{
  DeviceUtils$2(View paramView) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.val$decorView.setSystemUiVisibility(5894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceUtils.2
 * JD-Core Version:    0.7.0.1
 */