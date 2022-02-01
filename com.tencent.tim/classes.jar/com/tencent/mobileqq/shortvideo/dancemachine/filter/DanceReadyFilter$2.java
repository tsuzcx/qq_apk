package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;

class DanceReadyFilter$2
  implements Animation.AnimationListener
{
  DanceReadyFilter$2(DanceReadyFilter paramDanceReadyFilter) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    switch (DanceReadyFilter.access$500(this.this$0))
    {
    }
    for (;;)
    {
      DanceReadyFilter.access$510(this.this$0);
      if (DanceReadyFilter.access$500(this.this$0) == 0)
      {
        DanceReadyFilter.access$700(this.this$0).clearAnimation();
        DanceReadyFilter.access$700(this.this$0).startAnimation(DanceReadyFilter.access$800(this.this$0));
      }
      return;
      this.this$0.mDanceManager.getContext().playSound(DanceReadyFilter.access$600(this.this$0).mReadyResource.threeSound);
      continue;
      this.this$0.mDanceManager.getContext().playSound(DanceReadyFilter.access$600(this.this$0).mReadyResource.twoSound);
      continue;
      this.this$0.mDanceManager.getContext().playSound(DanceReadyFilter.access$600(this.this$0).mReadyResource.oneSound);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter.2
 * JD-Core Version:    0.7.0.1
 */