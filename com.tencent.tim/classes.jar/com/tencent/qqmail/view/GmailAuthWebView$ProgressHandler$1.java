package com.tencent.qqmail.view;

import android.widget.ProgressBar;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class GmailAuthWebView$ProgressHandler$1
  extends AnimatorListenerAdapter
{
  GmailAuthWebView$ProgressHandler$1(GmailAuthWebView.ProgressHandler paramProgressHandler) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (GmailAuthWebView.access$300(this.this$1.this$0).getProgress() == 100) {
      this.this$1.sendEmptyMessageDelayed(1, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.GmailAuthWebView.ProgressHandler.1
 * JD-Core Version:    0.7.0.1
 */