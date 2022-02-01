package com.tencent.mobileqq.hotpic;

import ahzp;
import ahzs;
import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;

public class HotVideoBlurTaskManager$1
  implements Runnable
{
  public HotVideoBlurTaskManager$1(ahzp paramahzp) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = (HotVideoData)this.this$0.l.keyAt(0);
    HotPicPageView.c localc = (HotPicPageView.c)this.this$0.l.get(localHotVideoData);
    if (localc.a(localHotVideoData))
    {
      Drawable localDrawable = ahzs.a(this.this$0.mContext, localHotVideoData);
      if ((localDrawable != null) && (localc.a(localHotVideoData))) {
        localc.Y(localDrawable);
      }
      this.this$0.b(localHotVideoData);
    }
    for (;;)
    {
      this.this$0.drx();
      return;
      this.this$0.b(localHotVideoData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager.1
 * JD-Core Version:    0.7.0.1
 */