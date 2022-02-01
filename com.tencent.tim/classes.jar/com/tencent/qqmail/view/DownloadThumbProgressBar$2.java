package com.tencent.qqmail.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DownloadThumbProgressBar$2
  implements ValueAnimator.AnimatorUpdateListener
{
  DownloadThumbProgressBar$2(DownloadThumbProgressBar paramDownloadThumbProgressBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (DownloadThumbProgressBar.access$000(this.this$0) == 2)
    {
      DownloadThumbProgressBar.access$202(this.this$0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      this.this$0.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar.2
 * JD-Core Version:    0.7.0.1
 */