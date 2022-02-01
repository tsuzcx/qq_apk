package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mnw;
import mnw.b;

class RIJUgcVideoPublishManager$8$1
  implements Runnable
{
  RIJUgcVideoPublishManager$8$1(RIJUgcVideoPublishManager.8 param8, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.jr.iterator();
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (!mnw.a(this.a.this$0).contains(localUgcVideo)) {
        mnw.a(this.a.this$0).add(localUgcVideo);
      }
    }
    mnw.a(this.a.this$0, true);
    localIterator = mnw.b(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((mnw.b)localIterator.next()).onFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.8.1
 * JD-Core Version:    0.7.0.1
 */