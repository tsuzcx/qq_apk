package com.tencent.qqmail.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DownloadThumbProgressBar$6$1
  implements ValueAnimator.AnimatorUpdateListener
{
  DownloadThumbProgressBar$6$1(DownloadThumbProgressBar.6 param6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    DownloadThumbProgressBar.access$602(this.this$1.this$0, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.this$1.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar.6.1
 * JD-Core Version:    0.7.0.1
 */