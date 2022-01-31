package com.tencent.feedback.proguard;

import com.tencent.feedback.common.e;

final class t$2
  implements Runnable
{
  t$2(t paramt, s params, int paramInt) {}
  
  public final void run()
  {
    this.a.d();
    if (this.b >= 3)
    {
      e.b("rqdp{  query finished should notify}", new Object[0]);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.t.2
 * JD-Core Version:    0.7.0.1
 */