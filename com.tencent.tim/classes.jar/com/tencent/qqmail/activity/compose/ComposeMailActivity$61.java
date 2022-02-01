package com.tencent.qqmail.activity.compose;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;

class ComposeMailActivity$61
  implements ValueAnimator.AnimatorUpdateListener
{
  ComposeMailActivity$61(ComposeMailActivity paramComposeMailActivity, boolean paramBoolean, FrameLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2;
    if (this.val$visible)
    {
      paramValueAnimator = this.val$footbarParam;
      f2 = ComposeMailActivity.access$6800();
    }
    for (paramValueAnimator.bottomMargin = ((int)(f1 * (ComposeMailActivity.access$6900() - ComposeMailActivity.access$6800()) + f2));; this.val$footbarParam.bottomMargin = ((int)(ComposeMailActivity.access$6900() - f1 * (ComposeMailActivity.access$6900() - ComposeMailActivity.access$6800()))))
    {
      ComposeMailActivity.access$1200(this.this$0).setLayoutParams(this.val$footbarParam);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.61
 * JD-Core Version:    0.7.0.1
 */