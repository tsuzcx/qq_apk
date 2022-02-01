package com.tencent.beacon.qimei;

import java.util.List;

class d
  implements Runnable
{
  d(QimeiSDK paramQimeiSDK, IAsyncQimeiListener paramIAsyncQimeiListener) {}
  
  public void run()
  {
    synchronized (QimeiSDK.access$000(this.b))
    {
      Qimei localQimei = this.b.getQimei();
      if (localQimei != null)
      {
        boolean bool = localQimei.isEmpty();
        if (!bool) {
          try
          {
            this.a.onQimeiDispatch(localQimei);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              this.b.logQimeiCallbackError(localThrowable);
            }
          }
        }
      }
    }
    QimeiSDK.access$000(this.b).add(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.qimei.d
 * JD-Core Version:    0.7.0.1
 */