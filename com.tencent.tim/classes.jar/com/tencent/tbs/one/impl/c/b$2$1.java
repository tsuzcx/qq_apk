package com.tencent.tbs.one.impl.c;

import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.a.c;
import com.tencent.tbs.one.impl.e.h;
import java.lang.ref.WeakReference;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2, c paramc) {}
  
  public final void run()
  {
    if (this.b.i.f)
    {
      this.a.a(104, "Aborted", null);
      return;
    }
    a locala = this.b.i.b.a(this.b.d, this.b.e, new b.2.1.1(this));
    this.b.i.m = new WeakReference(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.2.1
 * JD-Core Version:    0.7.0.1
 */