package com.tencent.biz.pubaccount.weishi_new.cache;

import aqhq;
import ogr;

public class WeiShiCacheManager$3
  implements Runnable
{
  public WeiShiCacheManager$3(ogr paramogr) {}
  
  public void run()
  {
    aqhq.delete(ogr.a(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3
 * JD-Core Version:    0.7.0.1
 */