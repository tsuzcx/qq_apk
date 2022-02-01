package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import mnw;

class RIJUgcVideoPublishManager$5$1
  implements Runnable
{
  RIJUgcVideoPublishManager$5$1(RIJUgcVideoPublishManager.5 param5) {}
  
  public void run()
  {
    if (this.a.c.status == UgcVideo.STATUS_FINISH)
    {
      this.a.this$0.c(this.a.c);
      mnw.a(this.a.this$0, this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.5.1
 * JD-Core Version:    0.7.0.1
 */