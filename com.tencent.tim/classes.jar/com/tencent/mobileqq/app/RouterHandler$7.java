package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.Session;
import java.util.HashMap;

class RouterHandler$7
  implements Runnable
{
  RouterHandler$7(RouterHandler paramRouterHandler, long paramLong, int paramInt) {}
  
  public void run()
  {
    Session localSession = (Session)this.this$0.iF.get(Long.valueOf(this.EN));
    if ((this.cuO == 2) && (localSession != null)) {
      this.this$0.iF.remove(Long.valueOf(this.EN));
    }
    this.this$0.a(2, localSession, 0.0D, this.cuO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.7
 * JD-Core Version:    0.7.0.1
 */