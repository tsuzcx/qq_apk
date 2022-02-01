package com.tencent.mobileqq.activity.aio.photo;

import xsk;

public class AIOGalleryScene$28
  implements Runnable
{
  public AIOGalleryScene$28(xsk paramxsk) {}
  
  public void run()
  {
    if (this.this$0.aGH) {
      return;
    }
    xsk localxsk = this.this$0;
    localxsk.progress += this.this$0.bpE;
    if (this.this$0.progress > 99)
    {
      this.this$0.progress = 99;
      this.this$0.updateProgress(this.this$0.progress);
      return;
    }
    this.this$0.updateProgress(this.this$0.progress);
    this.this$0.adc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */