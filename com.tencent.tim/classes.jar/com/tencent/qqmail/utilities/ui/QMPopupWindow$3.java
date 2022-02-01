package com.tencent.qqmail.utilities.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class QMPopupWindow$3
  implements Animation.AnimationListener
{
  QMPopupWindow$3(QMPopupWindow paramQMPopupWindow) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.mask.post(new QMPopupWindow.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */