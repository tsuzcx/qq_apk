package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.a;
import com.tencent.halley.common.b.b;
import com.tencent.halley.common.b.c;
import java.util.HashMap;
import java.util.Map;

public final class i
  extends c
{
  private static Map c;
  public Map a = null;
  public int b = 0;
  
  public final void a(a parama)
  {
    if (c == null)
    {
      c = new HashMap();
      c.put(Integer.valueOf(0), Byte.valueOf((byte)0));
    }
    this.a = ((Map)parama.a(c, 0, true));
    this.b = parama.a(this.b, 1, true);
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
    paramb.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.i
 * JD-Core Version:    0.7.0.1
 */