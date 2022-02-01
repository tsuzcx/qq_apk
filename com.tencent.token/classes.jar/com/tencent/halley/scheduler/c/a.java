package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lp;
import com.tencent.token.lq;
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
  
  public final void a(lp paramlp)
  {
    this.a = paramlp.a(0, true);
    this.b = paramlp.a(1, true);
    if (f == null)
    {
      f = new ArrayList();
      h localh = new h();
      f.add(localh);
    }
    this.c = ((ArrayList)paramlp.a(f, 2, true));
    this.d = paramlp.a(this.d, 3, true);
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)paramlp.a(g, 4, false));
  }
  
  public final void a(lq paramlq)
  {
    paramlq.a(this.a, 0);
    paramlq.a(this.b, 1);
    paramlq.a(this.c, 2);
    paramlq.a(this.d, 3);
    Map localMap = this.e;
    if (localMap != null) {
      paramlq.a(localMap, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.a
 * JD-Core Version:    0.7.0.1
 */