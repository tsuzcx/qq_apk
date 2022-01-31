package com.tencent.feedback.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class S
  extends j
  implements Cloneable
{
  private static ArrayList f;
  private static Map g;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public ArrayList d = null;
  public Map e = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    if (f == null)
    {
      f = new ArrayList();
      R localR = new R();
      f.add(localR);
    }
    this.d = ((ArrayList)paramh.a(f, 3, false));
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)paramh.a(g, 4, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.b != null) {
      parami.a(this.b, 1);
    }
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    if (this.d != null) {
      parami.a(this.d, 3);
    }
    if (this.e != null) {
      parami.a(this.e, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.S
 * JD-Core Version:    0.7.0.1
 */