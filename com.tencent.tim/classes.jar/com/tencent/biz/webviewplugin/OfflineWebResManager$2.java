package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import sud;

public class OfflineWebResManager$2
  implements Runnable
{
  public OfflineWebResManager$2(sud paramsud, int paramInt) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(this.val$delay * 1000);
      if (!sud.aNg)
      {
        sud.bAP();
        if (!sud.isEnable)
        {
          this.this$0.c.drop(OfflineWebRes.class.getSimpleName());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      sud.aNg = this.this$0.c.tabbleIsExist(OfflineWebRes.class.getSimpleName());
      Object localObject;
      if (!sud.aNg)
      {
        localObject = new OfflineWebRes();
        ((OfflineWebRes)localObject).fileName = "test";
        ((OfflineWebRes)localObject).hashName = "test";
        ((OfflineWebRes)localObject).md5 = "test_md5";
        this.this$0.c.persist((Entity)localObject);
      }
      while (!sud.q.isEmpty())
      {
        localObject = (String)sud.q.poll();
        this.this$0.tN((String)localObject);
      }
      this.this$0.bAN();
      this.this$0.bi.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager.2
 * JD-Core Version:    0.7.0.1
 */