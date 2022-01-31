package com.tencent.feedback.proguard;

import com.tencent.feedback.common.b;
import com.tencent.feedback.common.e;
import java.util.Date;

final class y$1
  implements Runnable
{
  y$1(y paramy) {}
  
  public final void run()
  {
    long l2 = this.a.f();
    long l1 = new Date().getTime();
    l2 -= l1;
    b localb = this.a.g();
    if (localb != null)
    {
      if (l2 > 0L) {
        localb.a(this, l2 + 1000L);
      }
    }
    else {
      return;
    }
    e.b("rqdp{  next day to upload}", new Object[0]);
    this.a.d();
    l2 = this.a.e();
    this.a.b(l2);
    localb.a(this, l2 - l1);
    e.b("rqdp{ next day %d}", new Object[] { Long.valueOf(l2 - l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.y.1
 * JD-Core Version:    0.7.0.1
 */