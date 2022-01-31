package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.halley.common.b.d;
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
  
  public final void a(com.tencent.halley.common.b.a parama)
  {
    if (d == null)
    {
      d = new ArrayList();
      a locala = new a();
      d.add(locala);
    }
    this.a = ((ArrayList)parama.a(d, 0, true));
    this.b = parama.a(1, true);
    if (e == null)
    {
      e = new HashMap();
      e.put("", "");
    }
    this.c = ((Map)parama.a(e, 2, false));
  }
  
  public final void a(d paramd)
  {
    paramd.a(this.a, 0);
    paramd.a(this.b, 1);
    if (this.c != null) {
      paramd.a(this.c, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.b
 * JD-Core Version:    0.7.0.1
 */