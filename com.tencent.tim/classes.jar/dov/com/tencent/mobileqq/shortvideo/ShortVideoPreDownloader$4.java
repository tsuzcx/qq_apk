package dov.com.tencent.mobileqq.shortvideo;

import azaa;
import azab;
import azae;
import azaf;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$4
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.this$0.f.iterator();
    while (localIterator.hasNext())
    {
      azaf localazaf = (azaf)localIterator.next();
      azaa.a(localazaf, this.this$0.mApp);
      if (localazaf.a != null) {
        azae.log("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localazaf.a.uniseq);
      }
    }
    this.this$0.f.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */