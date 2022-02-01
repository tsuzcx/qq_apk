package com.tencent.mobileqq.shortvideo;

import anfr;
import anfu;
import angb;
import angi;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(angb paramangb) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.f.iterator();
    while (localIterator.hasNext())
    {
      angi localangi = (angi)localIterator.next();
      anfr.a(localangi, this.this$0.mApp);
      if (localangi.b != null) {
        angb.log("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localangi.b.uniseq);
      }
    }
    this.this$0.f.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */