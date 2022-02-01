package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.animation.AlphaAnimation;

class VideoFilterViewPager$VideoFilterPageChangeListener$1
  implements Runnable
{
  VideoFilterViewPager$VideoFilterPageChangeListener$1(VideoFilterViewPager.c paramc, int paramInt, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new VideoFilterViewPager.a(this.b.this$0, VideoFilterViewPager.a(this.b.this$0), this.cjD));
    this.Ad.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.VideoFilterPageChangeListener.1
 * JD-Core Version:    0.7.0.1
 */