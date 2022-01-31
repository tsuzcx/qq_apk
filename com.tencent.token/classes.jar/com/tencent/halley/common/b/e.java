package com.tencent.halley.common.b;

import java.util.HashMap;
import java.util.Map;

public final class e
  extends c
{
  private static byte[] k = null;
  private static Map l = null;
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
  
  public final void a(a parama)
  {
    try
    {
      this.a = parama.a(this.a, 1, true);
      this.f = parama.a(this.f, 2, true);
      this.g = parama.a(this.g, 3, true);
      this.b = parama.a(this.b, 4, true);
      this.c = parama.a(5, true);
      this.d = parama.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      Object localObject = k;
      this.e = ((byte[])parama.b(7, true));
      this.h = parama.a(this.h, 8, true);
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.i = ((Map)parama.a(l, 9, true));
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.j = ((Map)parama.a(l, 10, true));
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
      throw new RuntimeException(parama);
    }
  }
  
  public final void a(d paramd)
  {
    paramd.a(this.a, 1);
    paramd.a(this.f, 2);
    paramd.a(this.g, 3);
    paramd.a(this.b, 4);
    paramd.a(this.c, 5);
    paramd.a(this.d, 6);
    paramd.a(this.e, 7);
    paramd.a(this.h, 8);
    paramd.a(this.i, 9);
    paramd.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b.e
 * JD-Core Version:    0.7.0.1
 */