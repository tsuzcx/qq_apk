package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.a;
import com.tencent.halley.common.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends c
{
  private static ArrayList k;
  private static Map l;
  private String a = "";
  private String b = "";
  private ArrayList c = null;
  private String d = "";
  private String e = "";
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private Map j = null;
  
  public d() {}
  
  public d(String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, Map paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramString5;
    this.j = paramMap;
  }
  
  public final void a(a parama)
  {
    this.a = parama.a(0, true);
    this.b = parama.a(1, true);
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.c = ((ArrayList)parama.a(k, 2, true));
    this.d = parama.a(3, false);
    this.e = parama.a(4, false);
    this.f = parama.a(this.f, 5, false);
    this.g = parama.a(this.g, 6, false);
    this.h = parama.a(this.h, 7, false);
    this.i = parama.a(8, false);
    if (l == null)
    {
      l = new HashMap();
      l.put("", "");
    }
    this.j = ((Map)parama.a(l, 9, false));
  }
  
  public final void a(com.tencent.halley.common.b.d paramd)
  {
    paramd.a(this.a, 0);
    paramd.a(this.b, 1);
    paramd.a(this.c, 2);
    if (this.d != null) {
      paramd.a(this.d, 3);
    }
    if (this.e != null) {
      paramd.a(this.e, 4);
    }
    paramd.a(this.f, 5);
    paramd.a(this.g, 6);
    paramd.a(this.h, 7);
    if (this.i != null) {
      paramd.a(this.i, 8);
    }
    if (this.j != null) {
      paramd.a(this.j, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.d
 * JD-Core Version:    0.7.0.1
 */