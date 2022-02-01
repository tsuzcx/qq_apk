package com.tencent.qqmail.utilities.nightmode;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.qqmail.view.NightView;

class NightModeService$2
  extends AnimatorListenerAdapter
{
  NightModeService$2(NightModeService paramNightModeService, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.val$showOrHide) {
      NightModeService.access$000(this.this$0).detach(NightModeService.access$100(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.nightmode.NightModeService.2
 * JD-Core Version:    0.7.0.1
 */