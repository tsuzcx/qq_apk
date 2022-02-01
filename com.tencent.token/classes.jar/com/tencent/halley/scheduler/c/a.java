package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.li;
import com.tencent.token.lj;
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
  
  public final void a(li paramli)
  {
    this.a = paramli.a(0, true);
    this.b = paramli.a(1, true);
    if (f == null)
    {
      f = new ArrayList();
      h localh = new h();
      f.add(localh);
    }
    this.c = ((ArrayList)paramli.a(f, 2, true));
    this.d = paramli.a(this.d, 3, true);
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)paramli.a(g, 4, false));
  }
  
  public final void a(lj paramlj)
  {
    paramlj.a(this.a, 0);
    paramlj.a(this.b, 1);
    paramlj.a(this.c, 2);
    paramlj.a(this.d, 3);
    Map localMap = this.e;
    if (localMap != null) {
      paramlj.a(localMap, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.a
 * JD-Core Version:    0.7.0.1
 */