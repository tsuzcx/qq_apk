package com.tencent.mobileqq.troop.utils;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

class TroopFileTransferManager$TaskPool$1
  implements Runnable
{
  TroopFileTransferManager$TaskPool$1(TroopFileTransferManager.c paramc) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      for (;;)
      {
        if (this.this$0.al.isEmpty())
        {
          this.this$0.cf.decrementAndGet();
          return;
        }
        TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)this.this$0.al.remove(0);
        localTask.run();
        if (localTask.type != 0) {
          continue;
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool.1
 * JD-Core Version:    0.7.0.1
 */