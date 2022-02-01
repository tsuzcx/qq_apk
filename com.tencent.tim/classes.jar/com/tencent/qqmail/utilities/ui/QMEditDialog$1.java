package com.tencent.qqmail.utilities.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QMEditDialog$1
  implements Animation.AnimationListener
{
  QMEditDialog$1(QMEditDialog paramQMEditDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QMEditDialog.access$002(this.this$0, false);
    QMEditDialog.access$101(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QMEditDialog.access$002(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMEditDialog.1
 * JD-Core Version:    0.7.0.1
 */