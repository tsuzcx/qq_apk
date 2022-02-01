package com.tencent.feedback.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class S
  extends j
  implements Cloneable
{
  private static ArrayList<R> f;
  private static Map<String, String> g;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public ArrayList<R> d = null;
  public Map<String, String> e = null;
  
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
    Object localObject = this.b;
    if (localObject != null) {
      parami.a((String)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      parami.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      parami.a((Collection)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      parami.a((Map)localObject, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.S
 * JD-Core Version:    0.7.0.1
 */