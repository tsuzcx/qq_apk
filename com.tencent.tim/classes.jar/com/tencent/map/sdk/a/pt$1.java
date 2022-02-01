package com.tencent.map.sdk.a;

import android.os.Handler;

public final class pt$1
  implements Runnable
{
  public pt$1(pt parampt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5) {}
  
  public final void run()
  {
    pt.a(this.g, pt.a(this.g) + this.a);
    pt.a(this.g, this.b, pt.a(this.g));
    if (pt.b(this.g) < 10) {
      pt.c(this.g).postDelayed(this, 16L);
    }
    do
    {
      return;
      pt.a(this.g, this.b, this.c);
    } while ((this.d < 3.0F) || (this.d > 20.0F));
    if (this.e)
    {
      pt.1.1 local1 = new pt.1.1(this);
      Object localObject = pt.d(this.g).c;
      int i = (int)this.d;
      localObject = ((kl)localObject).h.g();
      if ((0L == ((pf)localObject).b) || (((pf)localObject).f == null)) {}
      for (;;)
      {
        local1.run();
        return;
        ((pf)localObject).f.a(new pf.18((pf)localObject, i));
      }
    }
    pt.d(this.g).c.a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pt.1
 * JD-Core Version:    0.7.0.1
 */