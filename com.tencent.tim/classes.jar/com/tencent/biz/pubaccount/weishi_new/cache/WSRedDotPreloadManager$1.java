package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import ogp;
import ooz;

public class WSRedDotPreloadManager$1
  implements Runnable
{
  public WSRedDotPreloadManager$1(ogp paramogp, WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt) {}
  
  public void run()
  {
    ogp.a(this.this$0, this.c, this.yL, this.beS - 1);
    ooz.d("WSRedDotPreloadManager", "checkSendRequest postDelayed finish: 30s");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */