package com.tencent.trackrecordlib.core;

import android.view.View;
import android.widget.EditText;
import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.g.i;

class c$1
  implements Runnable
{
  c$1(c paramc, int paramInt1, int paramInt2, long paramLong1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2, View paramView) {}
  
  public void run()
  {
    Object localObject3 = null;
    d.a locala = null;
    Object localObject1 = null;
    try
    {
      switch (this.a & 0xFF)
      {
      case 0: 
        c.a(this.j, this.b);
        c.a(this.j, this.c);
        c.a(this.j, this.d);
        c.b(this.j, this.e);
        c.c(this.j, this.f);
        c.d(this.j, this.g);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    c.b(this.j, this.b);
    c.e(this.j, this.d);
    c.f(this.j, this.e);
    return;
    c.g(this.j, this.d);
    c.h(this.j, this.e);
    return;
    int k = (int)(this.h - c.a(this.j));
    Object localObject2;
    if ((c.b(this.j) != -1) && (c.c(this.j) == -1))
    {
      bool1 = c.a(this.j, this.f, this.g);
      bool2 = c.b(this.j, this.h);
      if ((!bool1) && (!bool2))
      {
        localObject3 = f.a((int)this.d, (int)this.e, (int)this.f, (int)this.g);
        localObject3 = new d.a().a(UiAction.CLICK).a((a)localObject3).a(this.i.getClass().getName()).b(i.a(this.i));
        if ((RecordManager.getInstance().b) && ((this.i instanceof EditText)))
        {
          localObject2 = ((d.a)localObject3).c(localThrowable).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
          RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject2);
          c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject2);
        }
      }
    }
    while ((c.b(this.j) == -1) || (c.c(this.j) == -1))
    {
      boolean bool1;
      for (;;)
      {
        boolean bool2;
        c.a(this.j, -1);
        c.b(this.j, -1);
        return;
        localObject2 = i.c(this.i);
      }
      if (!bool1)
      {
        localObject2 = f.a((int)this.d, (int)this.e, (int)this.f, (int)this.g, k);
        locala = new d.a().a(UiAction.LONG_PRESS).a((a)localObject2).a(this.i.getClass().getName()).b(i.a(this.i));
        if ((RecordManager.getInstance().b) && ((this.i instanceof EditText))) {}
        for (localObject2 = localObject3;; localObject2 = i.c(this.i))
        {
          localObject2 = locala.c((String)localObject2).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
          RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject2);
          c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject2);
          break;
        }
      }
      localObject2 = f.a((int)c.d(this.j), (int)c.e(this.j), (int)this.d, (int)this.e, (int)c.f(this.j), (int)c.g(this.j), (int)this.f, (int)this.g, k);
      localObject3 = new d.a().a(UiAction.SCROLL).a((a)localObject2).a(this.i.getClass().getName()).b(i.a(this.i));
      if ((RecordManager.getInstance().b) && ((this.i instanceof EditText))) {}
      for (localObject2 = locala;; localObject2 = i.c(this.i))
      {
        localObject2 = ((d.a)localObject3).c((String)localObject2).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
        RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject2);
        c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject2);
        break;
      }
    }
    if (c.b(this.j) == this.b) {
      localObject2 = f.a((int)c.d(this.j), (int)c.e(this.j), (int)c.h(this.j), (int)c.i(this.j), (int)this.d, (int)this.e, (int)c.j(this.j), (int)c.k(this.j));
    }
    for (;;)
    {
      label955:
      localObject3 = new d.a().a(UiAction.ZOOM).a((a)localObject2).a(this.i.getClass().getName()).b(i.a(this.i));
      if ((RecordManager.getInstance().b) && ((this.i instanceof EditText))) {}
      for (localObject2 = null;; localObject2 = i.c(this.i))
      {
        localObject2 = ((d.a)localObject3).c((String)localObject2).d(i.b(this.i)).e(i.f(this.i)).f(i.d(this.i)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
        RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject2);
        c.a(this.j, (com.tencent.trackrecordlib.c.b)localObject2);
        break;
        if (c.c(this.j) != this.b) {
          break label1186;
        }
        localObject2 = f.a((int)c.d(this.j), (int)c.e(this.j), (int)c.h(this.j), (int)c.i(this.j), (int)c.j(this.j), (int)c.k(this.j), (int)this.d, (int)this.e);
        break label955;
      }
      label1186:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.1
 * JD-Core Version:    0.7.0.1
 */