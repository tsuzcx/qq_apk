package com.tencent.qqmail.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class DownloadThumbProgressBar$6$2
  implements Animator.AnimatorListener
{
  DownloadThumbProgressBar$6$2(DownloadThumbProgressBar.6 param6) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    DownloadThumbProgressBar.access$502(this.this$1.this$0, false);
    this.this$1.this$0.invalidate();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    DownloadThumbProgressBar.access$502(this.this$1.this$0, false);
    this.this$1.this$0.invalidate();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar.6.2
 * JD-Core Version:    0.7.0.1
 */