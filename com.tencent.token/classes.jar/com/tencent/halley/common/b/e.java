package com.tencent.halley.common.b;

import com.tencent.token.li;
import com.tencent.token.lj;
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
  
  public final void a(li paramli)
  {
    try
    {
      this.a = paramli.a(this.a, 1, true);
      this.f = paramli.a(this.f, 2, true);
      this.g = paramli.a(this.g, 3, true);
      this.b = paramli.a(this.b, 4, true);
      this.c = paramli.a(5, true);
      this.d = paramli.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])paramli.b(7, true));
      this.h = paramli.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramli.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramli.a(l, 10, true));
      return;
    }
    catch (Exception paramli)
    {
      paramli.printStackTrace();
      throw new RuntimeException(paramli);
    }
  }
  
  public final void a(lj paramlj)
  {
    paramlj.a(this.a, 1);
    paramlj.a(this.f, 2);
    paramlj.a(this.g, 3);
    paramlj.a(this.b, 4);
    paramlj.a(this.c, 5);
    paramlj.a(this.d, 6);
    paramlj.a(this.e, 7);
    paramlj.a(this.h, 8);
    paramlj.a(this.i, 9);
    paramlj.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b.e
 * JD-Core Version:    0.7.0.1
 */