package com.tencent.qqmail.utilities.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

final class QMUIKit$5
  implements Animator.AnimatorListener
{
  QMUIKit$5(View paramView, Drawable paramDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QMUIKit.setBackgroundKeepingPadding(this.val$v, this.val$oldBgDrawable);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIKit.5
 * JD-Core Version:    0.7.0.1
 */