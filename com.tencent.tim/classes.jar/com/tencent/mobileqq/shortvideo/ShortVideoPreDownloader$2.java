package com.tencent.mobileqq.shortvideo;

import angb;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoPreDownloader$2
  implements Runnable
{
  public ShortVideoPreDownloader$2(angb paramangb) {}
  
  public void run()
  {
    if (!this.this$0.dJ.get())
    {
      this.this$0.dJ.set(true);
      angb.log("openRunnable", "Timer count off, mIsPreDownloaderOpen=" + this.this$0.dJ.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */