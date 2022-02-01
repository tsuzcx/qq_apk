package com.tencent.mobileqq.shortvideo;

import anfu;
import angb;
import angi;

public class ShortVideoPreDownloader$4
  implements Runnable
{
  public ShortVideoPreDownloader$4(angb paramangb, angi paramangi) {}
  
  public void run()
  {
    angb.log("consumeShortVideo", "start pre download short video type=" + this.d.dFl + " uniseq=" + this.d.b.uniseq + ", uuid=" + this.d.b.uuid);
    this.this$0.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */