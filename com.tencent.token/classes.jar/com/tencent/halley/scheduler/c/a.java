package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.md;
import com.tencent.token.me;
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
  
  public final void a(md parammd)
  {
    this.a = parammd.a(0, true);
    this.b = parammd.a(1, true);
    if (f == null)
    {
      f = new ArrayList();
      h localh = new h();
      f.add(localh);
    }
    this.c = ((ArrayList)parammd.a(f, 2, true));
    this.d = parammd.a(this.d, 3, true);
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)parammd.a(g, 4, false));
  }
  
  public final void a(me paramme)
  {
    paramme.a(this.a, 0);
    paramme.a(this.b, 1);
    paramme.a(this.c, 2);
    paramme.a(this.d, 3);
    Map localMap = this.e;
    if (localMap != null) {
      paramme.a(localMap, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.a
 * JD-Core Version:    0.7.0.1
 */