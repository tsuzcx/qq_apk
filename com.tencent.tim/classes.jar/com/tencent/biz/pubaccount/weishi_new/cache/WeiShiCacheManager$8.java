package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import ogr;
import ooz;
import opn;

public class WeiShiCacheManager$8
  implements Runnable
{
  public WeiShiCacheManager$8(ogr paramogr, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, ArrayList paramArrayList, long paramLong, List paramList) {}
  
  public void run()
  {
    boolean bool = ogr.a(this.this$0, this.b, ogr.c(this.this$0), this.mc.size());
    if (bool)
    {
      LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis() + this.yM);
      LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", this.ik.size());
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", opn.lM());
      opn.t(this.mc, true);
    }
    ooz.e("WeiShiCacheManager", "cacheRedDotData isSuccess: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */