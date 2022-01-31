package com.tencent.mobileqq.theme;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

class ThemeSwitchManager$1
  implements Runnable
{
  ThemeSwitchManager$1(ThemeSwitchManager paramThemeSwitchManager) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.this$0.tmpScreenShot.getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.this$0.tmpScreenShot);
      localViewGroup.clearDisappearingChildren();
    }
    this.this$0.drawingCache.recycle();
    this.this$0.drawingCache = null;
    this.this$0.isAnimating = false;
    this.this$0.tmpScreenShot = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */