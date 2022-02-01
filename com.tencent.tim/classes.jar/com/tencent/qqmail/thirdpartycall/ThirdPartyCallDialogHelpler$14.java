package com.tencent.qqmail.thirdpartycall;

import android.widget.LinearLayout;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

final class ThirdPartyCallDialogHelpler$14
  implements ValueAnimator.AnimatorUpdateListener
{
  ThirdPartyCallDialogHelpler$14(LinearLayout paramLinearLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$innerLayout.setBackgroundColor(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.14
 * JD-Core Version:    0.7.0.1
 */