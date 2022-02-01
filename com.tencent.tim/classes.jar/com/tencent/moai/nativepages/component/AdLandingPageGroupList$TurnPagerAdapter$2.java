package com.tencent.moai.nativepages.component;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class AdLandingPageGroupList$TurnPagerAdapter$2
  implements Animation.AnimationListener
{
  AdLandingPageGroupList$TurnPagerAdapter$2(AdLandingPageGroupList.TurnPagerAdapter paramTurnPagerAdapter, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    new Handler().postDelayed(new AdLandingPageGroupList.TurnPagerAdapter.2.1(this), 200L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageGroupList.TurnPagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */