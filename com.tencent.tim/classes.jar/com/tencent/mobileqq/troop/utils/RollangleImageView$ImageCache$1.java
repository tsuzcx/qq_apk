package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import java.util.LinkedList;

class RollangleImageView$ImageCache$1
  implements Runnable
{
  RollangleImageView$ImageCache$1(RollangleImageView.a parama) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      if (this.this$0.cSd) {
        return;
      }
      try
      {
        Thread.sleep(100L);
        label19:
        synchronized (this.this$0)
        {
          if (RollangleImageView.a.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          RollangleImageView.a.a(this.this$0).poll();
        }
        if (RollangleImageView.a.a(this.this$0).isEmpty()) {
          return;
        }
        RollangleImageView.a.a locala = (RollangleImageView.a.a)RollangleImageView.a.a(this.this$0).peek();
        ??? = RollangleImageView.M(locala.path);
        Object localObject3 = locala;
        if (??? == null) {
          continue;
        }
        RollangleImageView.mMemoryCache.put("troopfileimage://" + locala.path, ???);
        RollangleImageView.a.a(this.this$0).obtainMessage(0, new Object[] { locala.a, locala.path, ??? }).sendToTarget();
        localObject3 = locala;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label19;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache.1
 * JD-Core Version:    0.7.0.1
 */