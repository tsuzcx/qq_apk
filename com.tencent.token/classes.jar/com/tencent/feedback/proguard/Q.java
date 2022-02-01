package com.tencent.feedback.proguard;

import java.util.HashMap;
import java.util.Map;

public final class Q
  extends j
  implements Cloneable
{
  private static P h;
  private static Map<String, String> i;
  public String a = "";
  public Map<String, String> b = null;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private String f = "";
  private P g = null;
  
  public final void a(h paramh)
  {
    boolean bool = this.c;
    this.c = paramh.a(0, true);
    bool = this.d;
    this.d = paramh.a(1, true);
    bool = this.e;
    this.e = paramh.a(2, true);
    this.a = paramh.b(3, false);
    this.f = paramh.b(4, false);
    if (h == null) {
      h = new P();
    }
    this.g = ((P)paramh.a(h, 5, false));
    if (i == null)
    {
      i = new HashMap();
      i.put("", "");
    }
    this.b = ((Map)paramh.a(i, 6, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.c, 0);
    parami.a(this.d, 1);
    parami.a(this.e, 2);
    if (this.a != null) {
      parami.a(this.a, 3);
    }
    if (this.f != null) {
      parami.a(this.f, 4);
    }
    if (this.g != null) {
      parami.a(this.g, 5);
    }
    if (this.b != null) {
      parami.a(this.b, 6);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.Q
 * JD-Core Version:    0.7.0.1
 */