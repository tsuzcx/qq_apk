package com.tencent.halley.common.b;

import com.tencent.token.md;
import com.tencent.token.me;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends c
{
  private static byte[] k;
  private static Map l;
  public short a = 3;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map i;
  private Map j;
  
  public final void a(md parammd)
  {
    try
    {
      this.a = parammd.a(this.a, 1, true);
      this.f = parammd.a(this.f, 2, true);
      this.g = parammd.a(this.g, 3, true);
      this.b = parammd.a(this.b, 4, true);
      this.c = parammd.a(5, true);
      this.d = parammd.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])parammd.b(7, true));
      this.h = parammd.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)parammd.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)parammd.a(l, 10, true));
      return;
    }
    catch (Exception parammd)
    {
      parammd.printStackTrace();
      throw new RuntimeException(parammd);
    }
  }
  
  public final void a(me paramme)
  {
    paramme.a(this.a, 1);
    paramme.a(this.f, 2);
    paramme.a(this.g, 3);
    paramme.a(this.b, 4);
    paramme.a(this.c, 5);
    paramme.a(this.d, 6);
    paramme.a(this.e, 7);
    paramme.a(this.h, 8);
    paramme.a(this.i, 9);
    paramme.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b.e
 * JD-Core Version:    0.7.0.1
 */