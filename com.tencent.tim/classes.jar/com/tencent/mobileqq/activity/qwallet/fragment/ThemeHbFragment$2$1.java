package com.tencent.mobileqq.activity.qwallet.fragment;

import aabc;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ThemeHbFragment$2$1
  implements Runnable
{
  public ThemeHbFragment$2$1(aabc paramaabc, Object paramObject) {}
  
  public void run()
  {
    if (ThemeHbFragment.a(this.a.this$0) != null) {
      ThemeHbFragment.a(this.a.this$0).setBackgroundDrawable(null);
    }
    ThemeHbFragment.a(this.a.this$0).setScaleType(ImageView.ScaleType.FIT_XY);
    ThemeHbFragment.a(this.a.this$0).setImageDrawable(ThemeHbFragment.a(this.a.this$0, (Drawable)this.bZ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.2.1
 * JD-Core Version:    0.7.0.1
 */