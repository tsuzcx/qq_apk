package com.tencent.halley.scheduler.c;

import com.tencent.halley.common.b.c;
import com.tencent.token.lj;
import com.tencent.token.lk;
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
  
  public final void a(lj paramlj)
  {
    this.a = paramlj.a(0, true);
    this.b = paramlj.a(1, true);
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.c = ((ArrayList)paramlj.a(k, 2, true));
    this.d = paramlj.a(3, false);
    this.e = paramlj.a(4, false);
    this.f = paramlj.a(this.f, 5, false);
    this.g = paramlj.a(this.g, 6, false);
    this.h = paramlj.a(this.h, 7, false);
    this.i = paramlj.a(8, false);
    if (l == null)
    {
      l = new HashMap();
      l.put("", "");
    }
    this.j = ((Map)paramlj.a(l, 9, false));
  }
  
  public final void a(lk paramlk)
  {
    paramlk.a(this.a, 0);
    paramlk.a(this.b, 1);
    paramlk.a(this.c, 2);
    Object localObject = this.d;
    if (localObject != null) {
      paramlk.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramlk.a((String)localObject, 4);
    }
    paramlk.a(this.f, 5);
    paramlk.a(this.g, 6);
    paramlk.a(this.h, 7);
    localObject = this.i;
    if (localObject != null) {
      paramlk.a((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramlk.a((Map)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.scheduler.c.d
 * JD-Core Version:    0.7.0.1
 */