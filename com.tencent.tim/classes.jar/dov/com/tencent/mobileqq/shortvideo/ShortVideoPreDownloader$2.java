package dov.com.tencent.mobileqq.shortvideo;

import azae;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoPreDownloader$2
  extends TimerTask
{
  public void run()
  {
    if (!this.this$0.dJ.get())
    {
      this.this$0.dJ.set(true);
      azae.log("off", "Timer count off, mIsPreDownloaderOpen=" + this.this$0.dJ.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */