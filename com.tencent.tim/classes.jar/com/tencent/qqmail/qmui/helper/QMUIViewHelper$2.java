package com.tencent.qqmail.qmui.helper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.drawable.Drawable;
import android.view.View;

final class QMUIViewHelper$2
  implements Animator.AnimatorListener
{
  QMUIViewHelper$2(View paramView, Drawable paramDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QMUIViewHelper.setBackgroundKeepingPadding(this.val$v, this.val$oldBgDrawable);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.helper.QMUIViewHelper.2
 * JD-Core Version:    0.7.0.1
 */