package com.tencent.token.ui;

import com.tencent.service.e;

final class hy
  implements Runnable
{
  hy(hx paramhx) {}
  
  public final void run()
  {
    synchronized (this.a.d)
    {
      if (hx.a(this.a) == null)
      {
        hx.a(this.a, true);
        long l = System.currentTimeMillis();
        hx.b(this.a);
        com.tencent.token.cv.f = (int)(System.currentTimeMillis() - l);
        hx.a(this.a, new e(hx.c(this.a), this.a, hx.d(this.a)));
        hx.a(this.a, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hy
 * JD-Core Version:    0.7.0.1
 */