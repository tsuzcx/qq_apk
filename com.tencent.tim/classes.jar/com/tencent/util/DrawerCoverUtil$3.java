package com.tencent.util;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import auvn;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.d;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;

public final class DrawerCoverUtil$3
  implements Runnable
{
  public DrawerCoverUtil$3(BaseActivity paramBaseActivity, Bitmap paramBitmap, RandomCoverView paramRandomCoverView, boolean paramBoolean, FrameHelperActivity.d paramd, Card paramCard) {}
  
  public void run()
  {
    if (this.val$activity == null) {
      return;
    }
    auvn localauvn = new auvn(this.val$activity, this.gU, 0, 0);
    this.a.e().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.a.e().setImageDrawable(localauvn);
    if (this.djG) {
      localauvn.start();
    }
    for (;;)
    {
      this.b.a(this.c.strDrawerCardUrl, localauvn);
      return;
      localauvn.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.3
 * JD-Core Version:    0.7.0.1
 */