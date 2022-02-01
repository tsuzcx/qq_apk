package com.tencent.halley.common.b;

import com.tencent.token.lp;
import com.tencent.token.lq;
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
  
  public final void a(lp paramlp)
  {
    try
    {
      this.a = paramlp.a(this.a, 1, true);
      this.f = paramlp.a(this.f, 2, true);
      this.g = paramlp.a(this.g, 3, true);
      this.b = paramlp.a(this.b, 4, true);
      this.c = paramlp.a(5, true);
      this.d = paramlp.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])paramlp.b(7, true));
      this.h = paramlp.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramlp.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramlp.a(l, 10, true));
      return;
    }
    catch (Exception paramlp)
    {
      paramlp.printStackTrace();
      throw new RuntimeException(paramlp);
    }
  }
  
  public final void a(lq paramlq)
  {
    paramlq.a(this.a, 1);
    paramlq.a(this.f, 2);
    paramlq.a(this.g, 3);
    paramlq.a(this.b, 4);
    paramlq.a(this.c, 5);
    paramlq.a(this.d, 6);
    paramlq.a(this.e, 7);
    paramlq.a(this.h, 8);
    paramlq.a(this.i, 9);
    paramlq.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b.e
 * JD-Core Version:    0.7.0.1
 */