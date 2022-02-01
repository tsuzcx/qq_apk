package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;
import wtl;

public class AIOIconChangeByTimeHelper$2
  implements Runnable
{
  public AIOIconChangeByTimeHelper$2(wtl paramwtl) {}
  
  public void run()
  {
    synchronized (wtl.a(this.this$0))
    {
      if ((wtl.a(this.this$0).get() == 1) && (wtl.a(this.this$0) != null) && (wtl.a(this.this$0).mContext != null) && (wtl.a(this.this$0) != null))
      {
        wtl.a(this.this$0).set(0);
        wtl.a(this.this$0).mContext.unregisterReceiver(wtl.a(this.this$0));
        wtl.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */