package com.tencent.moai.nativepages.component;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import java.math.BigInteger;

class AdLandingPageGroupList$TurnPagerAdapter$1$1
  implements Animation.AnimationListener
{
  AdLandingPageGroupList$TurnPagerAdapter$1$1(AdLandingPageGroupList.TurnPagerAdapter.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    long l = new BigInteger((String)this.this$1.val$rightIv.getTag()).longValue();
    if (l >= 3L)
    {
      paramAnimation = new AlphaAnimation(0.8F, 0.0F);
      paramAnimation.setDuration(AdLandingPageGroupList.TurnPagerAdapter.access$300(this.this$1.this$0));
      paramAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      paramAnimation.setAnimationListener(new AdLandingPageGroupList.TurnPagerAdapter.1.1.1(this));
      this.this$1.val$rightIv.startAnimation(paramAnimation);
      return;
    }
    paramAnimation = l + 1L + "";
    this.this$1.val$rightIv.setTag(paramAnimation);
    AdLandingPageGroupList.TurnPagerAdapter.access$400(this.this$1.this$0, this.this$1.val$rightIv);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageGroupList.TurnPagerAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */