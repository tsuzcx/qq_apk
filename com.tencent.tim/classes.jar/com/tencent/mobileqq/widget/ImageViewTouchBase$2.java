package com.tencent.mobileqq.widget;

import android.os.Handler;

class ImageViewTouchBase$2
  implements Runnable
{
  ImageViewTouchBase$2(ImageViewTouchBase paramImageViewTouchBase, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.pf, (float)(l - this.val$startTime));
    float f2 = this.pg;
    float f3 = this.ph;
    this.this$0.zoomTo(f2 + f3 * f1, this.ik, this.il);
    if (f1 < this.pf) {
      this.this$0.mHandler.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageViewTouchBase.2
 * JD-Core Version:    0.7.0.1
 */