package com.tencent.qqmail.utilities.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QMToggleView$3
  implements Animation.AnimationListener
{
  QMToggleView$3(QMToggleView paramQMToggleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QMToggleView.access$000(this.this$0).onDismiss(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QMToggleView.access$202(this.this$0, true);
    QMToggleView.access$000(this.this$0).onShow(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMToggleView.3
 * JD-Core Version:    0.7.0.1
 */