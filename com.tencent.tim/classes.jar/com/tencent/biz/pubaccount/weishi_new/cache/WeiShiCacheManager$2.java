package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import mqq.util.WeakReference;
import ogr;
import oks;
import ooz;

public class WeiShiCacheManager$2
  implements Runnable
{
  public WeiShiCacheManager$2(ogr paramogr, WeakReference paramWeakReference) {}
  
  public void run()
  {
    ooz.d("CacheResponseLog", "getCacheDataForFollow startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.GK()) {
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)ogr.a(this.this$0, new stFollowFeedsRsp(), 3);
    oks.a().I(new WeiShiCacheManager.2.1(this, localstFollowFeedsRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2
 * JD-Core Version:    0.7.0.1
 */