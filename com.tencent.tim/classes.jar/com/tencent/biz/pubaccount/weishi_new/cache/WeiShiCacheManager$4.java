package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import ogr;
import opn;

public class WeiShiCacheManager$4
  implements Runnable
{
  public WeiShiCacheManager$4(ogr paramogr, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.ik.size() > ogr.a(this.this$0))
    {
      int i = 0;
      while (i < ogr.a(this.this$0))
      {
        localArrayList.add(this.ik.get(i));
        i += 1;
      }
    }
    for (;;)
    {
      stFollowFeedsRsp localstFollowFeedsRsp = new stFollowFeedsRsp();
      localstFollowFeedsRsp.feeds = localArrayList;
      if (ogr.a(this.this$0, localstFollowFeedsRsp, ogr.a(this.this$0), localArrayList.size())) {
        LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", opn.lM());
      }
      return;
      localArrayList = new ArrayList(this.ik);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4
 * JD-Core Version:    0.7.0.1
 */