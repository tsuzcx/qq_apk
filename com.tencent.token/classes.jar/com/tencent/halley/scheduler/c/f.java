package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lp;
import com.tencent.token.lq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends c
{
  private static ArrayList e;
  private static Map f;
  public ArrayList a = null;
  public String b = "";
  private int c = 0;
  private Map d = null;
  
  public final void a(lp paramlp)
  {
    this.c = paramlp.a(this.c, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      e.add("");
    }
    this.a = ((ArrayList)paramlp.a(e, 1, true));
    this.b = paramlp.a(2, false);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)paramlp.a(f, 3, false));
  }
  
  public final void a(lq paramlq)
  {
    paramlq.a(this.c, 0);
    paramlq.a(this.a, 1);
    Object localObject = this.b;
    if (localObject != null) {
      paramlq.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramlq.a((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.f
 * JD-Core Version:    0.7.0.1
 */