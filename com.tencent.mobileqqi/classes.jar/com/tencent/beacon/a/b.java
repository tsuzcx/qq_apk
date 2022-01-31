package com.tencent.beacon.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class b
  implements Runnable
{
  private Context a;
  private int b;
  private int c;
  private Runnable d;
  
  public b(Context paramContext, int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramRunnable;
  }
  
  public final void run()
  {
    long l;
    boolean bool;
    com.tencent.beacon.a.a.e locale;
    if (this.b > 0)
    {
      l = new Date().getTime();
      bool = a.g(this.a);
      locale = e.l(this.a);
      if (locale != null) {
        break label260;
      }
      locale = new com.tencent.beacon.a.a.e();
      locale.c(l);
      locale.d(l);
      locale.b(0L);
      locale.a(0L);
    }
    label260:
    for (;;)
    {
      locale.a(locale.a() + this.b);
      if (bool) {
        locale.b(locale.b() + this.b);
      }
      locale.d(l);
      Context localContext = this.a;
      if ((localContext == null) || (locale == null)) {}
      for (;;)
      {
        com.tencent.beacon.d.a.e(" used:%d  seen:%d  next:%d", new Object[] { Long.valueOf(locale.a()), Long.valueOf(locale.b()), Integer.valueOf(this.b) });
        if (locale.a() >= this.c) {
          c.a().a(this.d);
        }
        return;
        ArrayList localArrayList = new ArrayList();
        com.tencent.beacon.a.a.a locala = new com.tencent.beacon.a.a.a(8, 0, locale.d(), com.tencent.beacon.b.a.a(locale));
        locala.a(locale.e());
        localArrayList.add(locala);
        com.tencent.beacon.a.a.a.b(localContext, localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b
 * JD-Core Version:    0.7.0.1
 */