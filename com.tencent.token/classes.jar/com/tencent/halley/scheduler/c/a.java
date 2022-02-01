package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lj;
import com.tencent.token.lk;
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
  
  public final void a(lj paramlj)
  {
    this.a = paramlj.a(0, true);
    this.b = paramlj.a(1, true);
    if (f == null)
    {
      f = new ArrayList();
      h localh = new h();
      f.add(localh);
    }
    this.c = ((ArrayList)paramlj.a(f, 2, true));
    this.d = paramlj.a(this.d, 3, true);
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.e = ((Map)paramlj.a(g, 4, false));
  }
  
  public final void a(lk paramlk)
  {
    paramlk.a(this.a, 0);
    paramlk.a(this.b, 1);
    paramlk.a(this.c, 2);
    paramlk.a(this.d, 3);
    Map localMap = this.e;
    if (localMap != null) {
      paramlk.a(localMap, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.a
 * JD-Core Version:    0.7.0.1
 */