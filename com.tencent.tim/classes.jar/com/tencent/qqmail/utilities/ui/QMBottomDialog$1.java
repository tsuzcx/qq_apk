package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QMBottomDialog$1
  implements Animation.AnimationListener
{
  QMBottomDialog$1(QMBottomDialog paramQMBottomDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QMBottomDialog.access$002(this.this$0, false);
    QMBottomDialog.access$200(this.this$0).post(new QMBottomDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QMBottomDialog.access$002(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMBottomDialog.1
 * JD-Core Version:    0.7.0.1
 */