package com.tencent.mobileqq.secspy;

import amzn;
import amzn.a;
import android.os.Handler;
import apzu;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(amzn paramamzn, amzn.a parama, long paramLong) {}
  
  public void run()
  {
    if (amzn.a.a(this.a)) {
      return;
    }
    float f = amzn.a.a(this.a) / amzn.a.b(this.a);
    this.this$0.a(this.kQ, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.z().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */