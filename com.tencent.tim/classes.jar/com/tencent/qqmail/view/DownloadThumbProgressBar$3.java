package com.tencent.qqmail.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class DownloadThumbProgressBar$3
  implements Animator.AnimatorListener
{
  DownloadThumbProgressBar$3(DownloadThumbProgressBar paramDownloadThumbProgressBar) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    DownloadThumbProgressBar.access$302(this.this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!DownloadThumbProgressBar.access$400(this.this$0))
    {
      DownloadThumbProgressBar.access$302(this.this$0, false);
      this.this$0.setState(1);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DownloadThumbProgressBar.access$302(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar.3
 * JD-Core Version:    0.7.0.1
 */