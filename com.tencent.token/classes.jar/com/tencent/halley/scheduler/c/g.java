package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lp;
import com.tencent.token.lq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends c
{
  private static Map c;
  public Map a = null;
  public long b = 0L;
  
  public final void a(lp paramlp)
  {
    if (c == null)
    {
      c = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("");
      c.put(Integer.valueOf(0), localArrayList);
    }
    this.a = ((Map)paramlp.a(c, 0, false));
    this.b = paramlp.a(this.b, 1, false);
  }
  
  public final void a(lq paramlq)
  {
    Map localMap = this.a;
    if (localMap != null) {
      paramlq.a(localMap, 0);
    }
    paramlq.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.g
 * JD-Core Version:    0.7.0.1
 */