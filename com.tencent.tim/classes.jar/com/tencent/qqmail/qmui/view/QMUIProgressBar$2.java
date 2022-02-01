package com.tencent.qqmail.qmui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class QMUIProgressBar$2
  implements Animator.AnimatorListener
{
  QMUIProgressBar$2(QMUIProgressBar paramQMUIProgressBar) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QMUIProgressBar.access$102(this.this$0, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QMUIProgressBar.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.view.QMUIProgressBar.2
 * JD-Core Version:    0.7.0.1
 */