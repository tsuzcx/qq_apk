package com.tencent.qqmail.qmui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QMUIProgressBar$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QMUIProgressBar$1(QMUIProgressBar paramQMUIProgressBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QMUIProgressBar.access$002(this.this$0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.view.QMUIProgressBar.1
 * JD-Core Version:    0.7.0.1
 */