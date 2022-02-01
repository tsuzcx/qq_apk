package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import ogr;
import oks;
import ooz;

public class WeiShiCacheManager$7
  implements Runnable
{
  public void run()
  {
    ooz.d("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.GK()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = ogr.a(this.this$0, 1);
    oks.a().I(new WeiShiCacheManager.7.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.7
 * JD-Core Version:    0.7.0.1
 */