package com.tencent.qqmini.sdk.monitor.common;

import android.os.Handler;
import java.util.Vector;

class FPSCalculator$2
  implements Runnable
{
  FPSCalculator$2(FPSCalculator paramFPSCalculator) {}
  
  public void run()
  {
    Object localObject1 = FPSCalculator.access$400(this.this$0);
    int i = 0;
    try
    {
      while (i < FPSCalculator.access$500(this.this$0).size())
      {
        FPSCalculator.GetFPSListener localGetFPSListener = (FPSCalculator.GetFPSListener)FPSCalculator.access$500(this.this$0).get(i);
        FPSCalculator.access$602(this.this$0, System.currentTimeMillis());
        localGetFPSListener.onInfo(FPSCalculator.access$600(this.this$0), 60.0D);
        i += 1;
      }
      FPSCalculator.access$300(this.this$0).postDelayed(FPSCalculator.access$700(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */