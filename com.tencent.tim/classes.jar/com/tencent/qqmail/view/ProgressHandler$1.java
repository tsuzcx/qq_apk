package com.tencent.qqmail.view;

import android.widget.ProgressBar;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class ProgressHandler$1
  extends AnimatorListenerAdapter
{
  ProgressHandler$1(ProgressHandler paramProgressHandler) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ProgressHandler.access$000(this.this$0).getProgress() == 100) {
      this.this$0.sendEmptyMessageDelayed(1, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ProgressHandler.1
 * JD-Core Version:    0.7.0.1
 */