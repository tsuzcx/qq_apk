package com.tencent.moai.nativepages;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.moai.nativepages.util.Threads;

class AdLandingPagesUI$15
  implements Animation.AnimationListener
{
  AdLandingPagesUI$15(AdLandingPagesUI paramAdLandingPagesUI, AdLandingPagesUI.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Threads.runOnMainThread(new AdLandingPagesUI.15.1(this), 200);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.val$holder.nextBtn.setVisibility(0);
    this.val$holder.isNextBtnDoingAnimation = true;
    paramAnimation = this.val$holder;
    paramAnimation.nextBtnAnimationCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.15
 * JD-Core Version:    0.7.0.1
 */