package com.tencent.qqmail.utilities.nightmode;

import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.qqmail.view.NightView;

class NightModeService$1
  implements ValueAnimator.AnimatorUpdateListener
{
  NightModeService$1(NightModeService paramNightModeService) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    NightModeService.access$000(this.this$0).setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.nightmode.NightModeService.1
 * JD-Core Version:    0.7.0.1
 */