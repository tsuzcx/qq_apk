package com.tencent.qqmail.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;

class QMRefreshingView$3
  extends AnimatorListenerAdapter
{
  QMRefreshingView$3(QMRefreshingView paramQMRefreshingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    Log.i("QMRefreshingView", "onAnimationEnd");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    Log.i("QMRefreshingView", "onAnimationStart");
    this.this$0.updateHintWords(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMRefreshingView.3
 * JD-Core Version:    0.7.0.1
 */