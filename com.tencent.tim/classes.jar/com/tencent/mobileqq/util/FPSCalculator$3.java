package com.tencent.mobileqq.util;

import android.os.Handler;
import aqda;
import aqda.a;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(aqda paramaqda) {}
  
  public void run()
  {
    Object localObject1 = aqda.a(this.this$0);
    int i = 0;
    try
    {
      while (i < aqda.a(this.this$0).size())
      {
        aqda.a locala = (aqda.a)aqda.a(this.this$0).get(i);
        aqda.a(this.this$0, System.currentTimeMillis());
        locala.onInfo(aqda.a(this.this$0), 60.0D);
        i += 1;
      }
      aqda.a(this.this$0).postDelayed(aqda.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */