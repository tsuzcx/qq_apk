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
    Object localObject = this.a;
    if (localObject != null) {
      parami.a((String)localObject, 3);
    }
    localObject = this.f;
    if (localObject != null) {
      parami.a((String)localObject, 4);
    }
    localObject = this.g;
    if (localObject != null) {
      parami.a((j)localObject, 5);
    }
    localObject = this.b;
    if (localObject != null) {
      parami.a((Map)localObject, 6);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.Q
 * JD-Core Version:    0.7.0.1
 */