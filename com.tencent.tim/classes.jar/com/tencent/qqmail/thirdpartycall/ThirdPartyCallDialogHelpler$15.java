package com.tencent.qqmail.thirdpartycall;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

final class ThirdPartyCallDialogHelpler$15
  implements ValueAnimator.AnimatorUpdateListener
{
  ThirdPartyCallDialogHelpler$15(Runnable paramRunnable, boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, int paramInt, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.val$start != null) {
      this.val$start.run();
    }
    if (this.val$present) {
      this.val$bottomviewLp.setMargins(0, 0, 0, (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() - this.val$height));
    }
    for (;;)
    {
      this.val$bottomView.setLayoutParams(this.val$bottomviewLp);
      this.val$bottomView.invalidate();
      return;
      this.val$bottomviewLp.setMargins(0, 0, 0, (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * -1.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler.15
 * JD-Core Version:    0.7.0.1
 */