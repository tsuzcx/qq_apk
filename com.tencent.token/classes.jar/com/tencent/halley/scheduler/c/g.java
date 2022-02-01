package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.a;
import com.tencent.halley.common.b.b;
import com.tencent.halley.common.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends c
{
  private static Map c;
  public Map a = null;
  public long b = 0L;
  
  public final void a(a parama)
  {
    if (c == null)
    {
      c = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("");
      c.put(Integer.valueOf(0), localArrayList);
    }
    this.a = ((Map)parama.a(c, 0, false));
    this.b = parama.a(this.b, 1, false);
  }
  
  public final void a(b paramb)
  {
    Map localMap = this.a;
    if (localMap != null) {
      paramb.a(localMap, 0);
    }
    paramb.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.g
 * JD-Core Version:    0.7.0.1
 */