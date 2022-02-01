package com.tencent.mobileqq.shortvideo;

import anfr;
import anfu;
import angb;
import angi;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoPreDownloader$3
  implements Runnable
{
  public ShortVideoPreDownloader$3(angb paramangb, anfu paramanfu, MessageForShortVideo paramMessageForShortVideo, angi paramangi) {}
  
  public void run()
  {
    angb.log("consumeShortVideoThumb", "start download thumb, fileType=" + this.a.fileType + ", uniseq:" + this.b.uniseq);
    anfr.a(this.d, this.this$0.mApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */