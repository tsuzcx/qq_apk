package com.tencent.mobileqq.dinifly;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.utils.LottieValueAnimator;

class LottieDrawable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LottieDrawable$1(LottieDrawable paramLottieDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (LottieDrawable.access$000(this.this$0) != null) {
      LottieDrawable.access$000(this.this$0).setProgress(LottieDrawable.access$100(this.this$0).getAnimatedValueAbsolute());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieDrawable.1
 * JD-Core Version:    0.7.0.1
 */