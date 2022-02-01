package com.tencent.halley.common.b;

import com.tencent.token.lj;
import com.tencent.token.lk;
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
  
  public final void a(lj paramlj)
  {
    try
    {
      this.a = paramlj.a(this.a, 1, true);
      this.f = paramlj.a(this.f, 2, true);
      this.g = paramlj.a(this.g, 3, true);
      this.b = paramlj.a(this.b, 4, true);
      this.c = paramlj.a(5, true);
      this.d = paramlj.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])paramlj.b(7, true));
      this.h = paramlj.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramlj.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramlj.a(l, 10, true));
      return;
    }
    catch (Exception paramlj)
    {
      paramlj.printStackTrace();
      throw new RuntimeException(paramlj);
    }
  }
  
  public final void a(lk paramlk)
  {
    paramlk.a(this.a, 1);
    paramlk.a(this.f, 2);
    paramlk.a(this.g, 3);
    paramlk.a(this.b, 4);
    paramlk.a(this.c, 5);
    paramlk.a(this.d, 6);
    paramlk.a(this.e, 7);
    paramlk.a(this.h, 8);
    paramlk.a(this.i, 9);
    paramlk.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b.e
 * JD-Core Version:    0.7.0.1
 */