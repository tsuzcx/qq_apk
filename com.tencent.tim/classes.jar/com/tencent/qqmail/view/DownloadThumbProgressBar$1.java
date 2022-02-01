package com.tencent.qqmail.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DownloadThumbProgressBar$1
  implements ValueAnimator.AnimatorUpdateListener
{
  DownloadThumbProgressBar$1(DownloadThumbProgressBar paramDownloadThumbProgressBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (DownloadThumbProgressBar.access$000(this.this$0) == 1)
    {
      DownloadThumbProgressBar.access$102(this.this$0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      this.this$0.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar.1
 * JD-Core Version:    0.7.0.1
 */