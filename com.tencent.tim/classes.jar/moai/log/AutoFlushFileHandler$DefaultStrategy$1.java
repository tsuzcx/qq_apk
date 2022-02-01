package moai.log;

import android.os.SystemClock;

class AutoFlushFileHandler$DefaultStrategy$1
  implements Runnable
{
  AutoFlushFileHandler$DefaultStrategy$1(AutoFlushFileHandler.DefaultStrategy paramDefaultStrategy) {}
  
  public void run()
  {
    for (;;)
    {
      if (AutoFlushFileHandler.DefaultStrategy.access$000(this.this$0)) {
        synchronized (AutoFlushFileHandler.DefaultStrategy.access$100(this.this$0))
        {
          boolean bool = AutoFlushFileHandler.DefaultStrategy.access$200(this.this$0);
          if (bool) {}
        }
      }
      try
      {
        AutoFlushFileHandler.DefaultStrategy.access$100(this.this$0).wait();
        label44:
        AutoFlushFileHandler.DefaultStrategy.access$202(this.this$0, true);
        SystemClock.sleep(AutoFlushFileHandler.DefaultStrategy.access$300(this.this$0));
        ??? = AutoFlushFileHandler.DefaultStrategy.access$400(this.this$0);
        int j = ???.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = ???[i];
          if (localObject2 != null) {
            localObject2.flush();
          }
          i += 1;
        }
        localObject3 = finally;
        throw localObject3;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label44;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.AutoFlushFileHandler.DefaultStrategy.1
 * JD-Core Version:    0.7.0.1
 */