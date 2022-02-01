package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.b;
import com.tencent.halley.common.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
{
  private static ArrayList f;
  private static Map g;
  public String a = "";
  public String b = "";
  public ArrayList c = null;
  public int d = 0;
  private Map e = null;
  
  public final void a(com.tencent.halley.common.b.a parama)
  {
    this.a = parama.a(0, true);
    this.b = parama.a(1, true);
    if (f == null)
    {
      f = new ArrayList();
      h localh = new h();
      f.add(localh);
    }
    this.c = ((ArrayList)parama.a(f, 2, true));
    this.d = parama.a(this.d, 3, true);
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)parama.a(g, 4, false));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    paramb.a(this.d, 3);
    if (this.e != null) {
      paramb.a(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.a
 * JD-Core Version:    0.7.0.1
 */