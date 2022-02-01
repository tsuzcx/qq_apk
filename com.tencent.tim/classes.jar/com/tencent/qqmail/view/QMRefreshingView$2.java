package com.tencent.qqmail.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QMRefreshingView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QMRefreshingView$2(QMRefreshingView paramQMRefreshingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!QMRefreshingView.access$500(this.this$0))
    {
      this.this$0.updateCurrentFooterBmp(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      QMRefreshingView.access$600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMRefreshingView.2
 * JD-Core Version:    0.7.0.1
 */