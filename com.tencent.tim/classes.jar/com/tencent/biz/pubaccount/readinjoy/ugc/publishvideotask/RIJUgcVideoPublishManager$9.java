package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import mnw;

public class RIJUgcVideoPublishManager$9
  implements Runnable
{
  public RIJUgcVideoPublishManager$9(mnw parammnw, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    mnw.a(this.this$0).persistOrReplace(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.9
 * JD-Core Version:    0.7.0.1
 */