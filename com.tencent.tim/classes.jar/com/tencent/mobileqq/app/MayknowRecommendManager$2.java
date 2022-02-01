package com.tencent.mobileqq.app;

import achg;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(achg paramachg) {}
  
  public void run()
  {
    if (achg.a(this.this$0).a.Bd() == 1)
    {
      achg.b(this.this$0);
      return;
    }
    synchronized (achg.a(this.this$0))
    {
      if (!achg.a(this.this$0)) {
        achg.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */