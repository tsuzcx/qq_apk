package com.tencent.feedback.proguard;

import java.util.HashMap;
import java.util.Map;

public final class R
  extends j
  implements Cloneable
{
  private static Map<String, String> g = new HashMap();
  public long a = 0L;
  public byte b = 0;
  public String c = "";
  public String d = "";
  public Map<String, String> e = null;
  private String f = "";
  
  static
  {
    g.put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.b(2, false);
    this.d = paramh.b(3, false);
    this.f = paramh.b(4, false);
    this.e = ((Map)paramh.a(g, 5, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    if (this.d != null) {
      parami.a(this.d, 3);
    }
    if (this.f != null) {
      parami.a(this.f, 4);
    }
    if (this.e != null) {
      parami.a(this.e, 5);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.R
 * JD-Core Version:    0.7.0.1
 */