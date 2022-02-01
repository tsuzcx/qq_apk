package com.tencent.mobileqq.theme;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import aoha;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThemeSwitchManager$1
  implements Runnable
{
  public ThemeSwitchManager$1(aoha paramaoha) {}
  
  public void run()
  {
    if (this.this$0.DU == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.this$0.DU.getParent();
    if (localViewGroup != null)
    {
      localViewGroup.removeView(this.this$0.DU);
      localViewGroup.clearDisappearingChildren();
    }
    this.this$0.gq.recycle();
    this.this$0.gq = null;
    this.this$0.dT.set(false);
    this.this$0.DU = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */