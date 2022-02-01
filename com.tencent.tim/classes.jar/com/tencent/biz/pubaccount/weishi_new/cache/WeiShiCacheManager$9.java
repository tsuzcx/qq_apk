package com.tencent.biz.pubaccount.weishi_new.cache;

import aqhq;
import cooperation.qzone.LocalMultiProcConfig;
import ogr;

public class WeiShiCacheManager$9
  implements Runnable
{
  public WeiShiCacheManager$9(ogr paramogr) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis());
    LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
    aqhq.delete(ogr.c(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */