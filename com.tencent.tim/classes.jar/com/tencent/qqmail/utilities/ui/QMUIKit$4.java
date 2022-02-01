package com.tencent.qqmail.utilities.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

final class QMUIKit$4
  implements ValueAnimator.AnimatorUpdateListener
{
  QMUIKit$4(View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QMUIKit.setBackgroundKeepingPadding(this.val$v, new ColorDrawable(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIKit.4
 * JD-Core Version:    0.7.0.1
 */