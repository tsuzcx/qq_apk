package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lp;
import com.tencent.token.lq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends c
{
  private static ArrayList d;
  private static Map e;
  public ArrayList a = null;
  public String b = "";
  private Map c = null;
  
  public final void a(lp paramlp)
  {
    if (d == null)
    {
      d = new ArrayList();
      a locala = new a();
      d.add(locala);
    }
    this.a = ((ArrayList)paramlp.a(d, 0, true));
    this.b = paramlp.a(1, true);
    if (e == null)
    {
      e = new HashMap();
      e.put("", "");
    }
    this.c = ((Map)paramlp.a(e, 2, false));
  }
  
  public final void a(lq paramlq)
  {
    paramlq.a(this.a, 0);
    paramlq.a(this.b, 1);
    Map localMap = this.c;
    if (localMap != null) {
      paramlq.a(localMap, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.b
 * JD-Core Version:    0.7.0.1
 */