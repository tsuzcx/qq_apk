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
    boolean bool = false;
    e.b("process end %d", new Object[] { Long.valueOf(paramLong) });
    if ((this.a.a <= 0L) || (this.a.c <= 0L) || (this.a.b == null)) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean a(long paramLong1, long paramLong2, String paramString)
  {
    e.b("new process %s", new Object[] { paramString });
    if (!paramString.equals(paramString)) {}
    do
    {
      return true;
      this.a.a = paramLong1;
      this.a.b = paramString;
      this.a.c = paramLong2;
    } while (this.b);
    return false;
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    e.b("new thread %s", new Object[] { paramString1 });
    if ((this.a.a <= 0L) || (this.a.c <= 0L) || (this.a.b == null)) {
      return true;
    }
    if (this.a.d == null) {
      this.a.d = new HashMap();
    }
    this.a.d.put(paramString1, new String[] { paramString2, paramString3, paramInt });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.d
 * JD-Core Version:    0.7.0.1
 */