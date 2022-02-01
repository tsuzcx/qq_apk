package com.tencent.moai.nativepages;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.moai.nativepages.util.Threads;

class AdLandingPagesUI$12
  implements Animation.AnimationListener
{
  AdLandingPagesUI$12(AdLandingPagesUI paramAdLandingPagesUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Threads.runOnMainThread(new AdLandingPagesUI.12.1(this), 200);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AdLandingPagesUI.access$1300(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.12
 * JD-Core Version:    0.7.0.1
 */