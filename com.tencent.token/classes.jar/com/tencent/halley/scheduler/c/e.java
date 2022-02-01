package com.tencent.halley.scheduler.c;

import com.tencent.token.md;
import com.tencent.token.me;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends com.tencent.halley.common.b.c
{
  private static Map h;
  private static g i;
  private static c j;
  private static Map k;
  private static Map l;
  public Map a = null;
  public g b = null;
  public c c = null;
  public Map d = null;
  public Map e = null;
  private String f = "";
  private int g = 0;
  
  public final void a(md parammd)
  {
    this.f = parammd.a(0, true);
    this.g = parammd.a(this.g, 1, true);
    Object localObject;
    if (h == null)
    {
      h = new HashMap();
      localObject = new f();
      h.put("", localObject);
    }
    this.a = ((Map)parammd.a(h, 2, true));
    if (i == null) {
      i = new g();
    }
    this.b = ((g)parammd.a(i, 3, false));
    if (j == null) {
      j = new c();
    }
    this.c = ((c)parammd.a(j, 4, false));
    if (k == null)
    {
      k = new HashMap();
      k.put("", "");
    }
    this.d = ((Map)parammd.a(k, 5, false));
    if (l == null)
    {
      l = new HashMap();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      l.put("", localObject);
    }
    this.e = ((Map)parammd.a(l, 6, false));
  }
  
  public final void a(me paramme)
  {
    paramme.a(this.f, 0);
    paramme.a(this.g, 1);
    paramme.a(this.a, 2);
    Object localObject = this.b;
    if (localObject != null) {
      paramme.a((com.tencent.halley.common.b.c)localObject, 3);
    }
    localObject = this.c;
    if (localObject != null) {
      paramme.a((com.tencent.halley.common.b.c)localObject, 4);
    }
    localObject = this.d;
    if (localObject != null) {
      paramme.a((Map)localObject, 5);
    }
    localObject = this.e;
    if (localObject != null) {
      paramme.a((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.e
 * JD-Core Version:    0.7.0.1
 */