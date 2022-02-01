package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.a;
import com.tencent.halley.common.b.b;
import com.tencent.halley.common.b.c;
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
  
  public final void a(a parama)
  {
    this.c = parama.a(this.c, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      e.add("");
    }
    this.a = ((ArrayList)parama.a(e, 1, true));
    this.b = parama.a(2, false);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)parama.a(f, 3, false));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.c, 0);
    paramb.a(this.a, 1);
    Object localObject = this.b;
    if (localObject != null) {
      paramb.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramb.a((Map)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.f
 * JD-Core Version:    0.7.0.1
 */