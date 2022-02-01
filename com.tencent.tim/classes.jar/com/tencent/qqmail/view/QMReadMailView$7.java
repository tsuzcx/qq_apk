package com.tencent.qqmail.view;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class QMReadMailView$7
  implements Animation.AnimationListener
{
  QMReadMailView$7(QMReadMailView paramQMReadMailView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)QMReadMailView.access$400(this.this$0).getLayoutParams();
    if (!QMReadMailView.access$500(this.this$0))
    {
      paramAnimation.bottomMargin = this.this$0.getResources().getDimensionPixelSize(2131297365);
      return;
    }
    paramAnimation.bottomMargin = 0;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.7
 * JD-Core Version:    0.7.0.1
 */