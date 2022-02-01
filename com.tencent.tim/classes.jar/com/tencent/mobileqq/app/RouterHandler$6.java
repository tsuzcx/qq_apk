package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.Session;
import java.util.HashMap;

class RouterHandler$6
  implements Runnable
{
  RouterHandler$6(RouterHandler paramRouterHandler, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    Session localSession = (Session)this.this$0.iF.get(Long.valueOf(this.EN));
    this.this$0.a(1, localSession, (float)((float)this.bj * 1.0D / (float)this.bk), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.6
 * JD-Core Version:    0.7.0.1
 */