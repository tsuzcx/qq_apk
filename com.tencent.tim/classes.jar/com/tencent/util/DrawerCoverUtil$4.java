package com.tencent.util;

import android.widget.ImageView.ScaleType;
import auvn;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.RandomCoverView;

public final class DrawerCoverUtil$4
  implements Runnable
{
  public DrawerCoverUtil$4(RandomCoverView paramRandomCoverView, auvn paramauvn, boolean paramBoolean) {}
  
  public void run()
  {
    this.a.e().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.a.e().setImageDrawable(this.b);
    if (this.djG)
    {
      this.b.resume();
      return;
    }
    this.b.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.4
 * JD-Core Version:    0.7.0.1
 */