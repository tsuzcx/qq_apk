package com.tencent.mobileqq.magicface.drawable;

import aixk;
import aixk.c;
import aixl;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;

public class PngFrameManager$1
  implements Runnable
{
  public PngFrameManager$1(aixk paramaixk, aixk.c paramc) {}
  
  public void run()
  {
    if ((this.a.c.progressBar.getVisibility() != 0) && (this.a.c.sS.getVisibility() == 0)) {
      this.a.c.bc.setOnClickListener(new aixl(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.1
 * JD-Core Version:    0.7.0.1
 */