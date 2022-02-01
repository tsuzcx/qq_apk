package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import java.util.ArrayList;
import lcr;
import ogo;
import ogr;
import oks;
import ooz;
import opn;

public class WeiShiCacheManager$1
  implements Runnable
{
  public WeiShiCacheManager$1(ogr paramogr, ogo paramogo) {}
  
  public void run()
  {
    ooz.d("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.GK()) {
      return;
    }
    boolean bool = false;
    Object localObject = opn.a();
    if (localObject != null) {
      bool = opn.a((lcr)localObject);
    }
    ooz.d("WeiShiCacheManager", "isRedDotMsg = " + bool);
    if (bool) {
      if ((this.this$0.GJ()) && (this.this$0.ro() >= 8))
      {
        ooz.d("WeiShiCacheManager", "仅读取红点缓存");
        localObject = ogr.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      oks.a().I(new WeiShiCacheManager.1.1(this, (stSimpleGetFeedListRsp)localObject));
      return;
      ooz.d("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
      localObject = ogr.a(this.this$0, 2);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = ogr.a(this.this$0, 1);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp1.feeds = new ArrayList();
      if (localObject != null)
      {
        ooz.d("WeiShiCacheManager", "红点缓存数量 = " + ((stSimpleGetFeedListRsp)localObject).feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(((stSimpleGetFeedListRsp)localObject).feeds);
      }
      localObject = localstSimpleGetFeedListRsp1;
      if (localstSimpleGetFeedListRsp2 != null)
      {
        ooz.d("WeiShiCacheManager", "瀑布流缓存数量 = " + localstSimpleGetFeedListRsp2.feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
        localObject = localstSimpleGetFeedListRsp1;
        continue;
        ooz.d("WeiShiCacheManager", "读取瀑布流缓存数据");
        localObject = ogr.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1
 * JD-Core Version:    0.7.0.1
 */