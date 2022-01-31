package com.tencent.beacon.c.e;

import com.tencent.beacon.e.b;
import com.tencent.beacon.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
{
  private static ArrayList<d> e;
  private static Map<String, String> f;
  public ArrayList<d> a = null;
  public int b = 0;
  public String c = "";
  public Map<String, String> d = null;
  
  public final void a(com.tencent.beacon.e.a parama)
  {
    if (e == null)
    {
      e = new ArrayList();
      d locald = new d();
      e.add(locald);
    }
    this.a = ((ArrayList)parama.a(e, 0, true));
    this.b = parama.a(this.b, 1, true);
    this.c = parama.b(2, true);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)parama.a(f, 3, false));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
    paramb.a(this.c, 2);
    if (this.d != null) {
      paramb.a(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.c.e.a
 * JD-Core Version:    0.7.0.1
 */