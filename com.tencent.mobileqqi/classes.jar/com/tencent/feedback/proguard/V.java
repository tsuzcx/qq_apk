package com.tencent.feedback.proguard;

import java.util.HashMap;
import java.util.Map;

public final class V
  extends j
{
  private static Map<String, byte[]> f;
  public boolean a = true;
  public boolean b = true;
  public int c = 0;
  public int d = 0;
  private Map<String, byte[]> e = null;
  
  public final void a(h paramh)
  {
    boolean bool = this.a;
    this.a = paramh.a(0, true);
    if (f == null)
    {
      f = new HashMap();
      f.put("", new byte[] { 0 });
    }
    this.e = ((Map)paramh.a(f, 1, false));
    bool = this.b;
    this.b = paramh.a(2, false);
    this.c = paramh.a(this.c, 3, false);
    this.d = paramh.a(this.d, 4, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.e != null) {
      parami.a(this.e, 1);
    }
    parami.a(this.b, 2);
    parami.a(this.c, 3);
    parami.a(this.d, 4);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.V
 * JD-Core Version:    0.7.0.1
 */