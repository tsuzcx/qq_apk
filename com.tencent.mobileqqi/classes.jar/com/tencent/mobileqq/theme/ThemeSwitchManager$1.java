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
    ViewGroup localViewGroup = (ViewGroup)ThemeSwitchManager.access$1000(this.this$0).getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(ThemeSwitchManager.access$1000(this.this$0));
      localViewGroup.clearDisappearingChildren();
    }
    ThemeSwitchManager.access$1100(this.this$0).recycle();
    ThemeSwitchManager.access$1102(this.this$0, null);
    this.this$0.isAnimating = false;
    ThemeSwitchManager.access$1002(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */