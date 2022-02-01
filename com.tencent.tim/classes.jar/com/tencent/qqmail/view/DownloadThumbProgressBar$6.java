package com.tencent.qqmail.view;

import android.animation.ValueAnimator;

class DownloadThumbProgressBar$6
  implements Runnable
{
  DownloadThumbProgressBar$6(DownloadThumbProgressBar paramDownloadThumbProgressBar) {}
  
  public void run()
  {
    DownloadThumbProgressBar.access$502(this.this$0, true);
    DownloadThumbProgressBar.access$602(this.this$0, DownloadThumbProgressBar.access$700(this.this$0));
    this.this$0.setState(3);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { DownloadThumbProgressBar.access$600(this.this$0), this.this$0.getMeasuredWidth() * 1.5F / 2.0F });
    localValueAnimator.addUpdateListener(new DownloadThumbProgressBar.6.1(this));
    localValueAnimator.addListener(new DownloadThumbProgressBar.6.2(this));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.DownloadThumbProgressBar.6
 * JD-Core Version:    0.7.0.1
 */