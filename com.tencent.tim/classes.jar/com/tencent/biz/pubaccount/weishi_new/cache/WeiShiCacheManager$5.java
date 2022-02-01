package com.tencent.biz.pubaccount.weishi_new.cache;

import aqhq;
import ogr;

public class WeiShiCacheManager$5
  implements Runnable
{
  public WeiShiCacheManager$5(ogr paramogr) {}
  
  public void run()
  {
    aqhq.delete(ogr.b(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5
 * JD-Core Version:    0.7.0.1
 */