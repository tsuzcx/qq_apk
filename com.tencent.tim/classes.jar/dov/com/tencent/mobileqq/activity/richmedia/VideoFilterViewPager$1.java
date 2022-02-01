package dov.com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.animation.AlphaAnimation;
import ayvb;

public class VideoFilterViewPager$1
  implements Runnable
{
  VideoFilterViewPager$1(VideoFilterViewPager paramVideoFilterViewPager, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setFillAfter(true);
    this.val$container.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new ayvb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.1
 * JD-Core Version:    0.7.0.1
 */