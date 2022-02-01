package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import ogr;
import opn;

public class WeiShiCacheManager$6
  implements Runnable
{
  public WeiShiCacheManager$6(ogr paramogr, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mc.size() >= ogr.b(this.this$0))
    {
      int i = this.mc.size();
      if (this.mc.size() - this.beT > ogr.b(this.this$0)) {
        i = this.mc.size() - this.beT;
      }
      for (;;)
      {
        int j = i - ogr.b(this.this$0);
        while (j < i)
        {
          localArrayList.add(this.mc.get(j));
          j += 1;
        }
        if (this.mc.size() - this.beT > 0) {
          i = ogr.b(this.this$0);
        }
      }
    }
    localArrayList.addAll(this.mc);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    if (ogr.a(this.this$0, localstSimpleGetFeedListRsp, ogr.b(this.this$0), localArrayList.size())) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", opn.lM());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6
 * JD-Core Version:    0.7.0.1
 */