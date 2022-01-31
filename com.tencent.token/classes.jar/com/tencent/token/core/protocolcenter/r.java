package com.tencent.token.core.protocolcenter;

import com.tencent.token.ev;
import com.tencent.token.global.f;
import java.util.concurrent.Callable;

final class r
  implements Callable
{
  r(ev paramev) {}
  
  public f a()
  {
    f localf = new f();
    e locale = b.a(this.a.a);
    if (locale != null)
    {
      localf = locale.c(this.a);
      this.a.l.a(this.a, localf);
    }
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.r
 * JD-Core Version:    0.7.0.1
 */