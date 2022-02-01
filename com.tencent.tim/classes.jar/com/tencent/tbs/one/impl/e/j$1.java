package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.c;
import com.tencent.tbs.one.impl.common.d;

final class j$1
  extends c<e<d>>
{
  j$1(j paramj, String paramString, i parami) {}
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    f.c("[%s] Failed to request the latest DEPS, error: [%d] %s", new Object[] { this.a, Integer.valueOf(paramInt), paramString, paramThrowable });
    this.c.a(paramInt, paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.j.1
 * JD-Core Version:    0.7.0.1
 */