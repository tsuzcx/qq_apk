package com.tencent.feedback.anr;

import com.tencent.feedback.common.e;
import java.util.HashMap;
import java.util.Map;

final class d
  implements g
{
  d(f paramf, boolean paramBoolean) {}
  
  public final boolean a(long paramLong)
  {
    e.b("process end %d", new Object[] { Long.valueOf(paramLong) });
    if ((this.a.a > 0L) && (this.a.c > 0L)) {
      return this.a.b == null;
    }
    return true;
  }
  
  public final boolean a(long paramLong1, long paramLong2, String paramString)
  {
    e.b("new process %s", new Object[] { paramString });
    f localf = this.a;
    localf.a = paramLong1;
    localf.b = paramString;
    localf.c = paramLong2;
    return this.b;
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    e.b("new thread %s", new Object[] { paramString1 });
    if ((this.a.a > 0L) && (this.a.c > 0L))
    {
      if (this.a.b == null) {
        return true;
      }
      if (this.a.d == null) {
        this.a.d = new HashMap();
      }
      this.a.d.put(paramString1, new String[] { paramString2, paramString3, String.valueOf(paramInt) });
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.d
 * JD-Core Version:    0.7.0.1
 */