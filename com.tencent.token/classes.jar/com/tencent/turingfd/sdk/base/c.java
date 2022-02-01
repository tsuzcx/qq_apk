package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
{
  public static final cx<c> a = new a();
  public Map<String, d> b = new HashMap();
  public Map<String, b> c = new HashMap();
  public f d;
  
  public final Lemon a(long paramLong1, long paramLong2, List<c> paramList)
  {
    Lemon localLemon = new Lemon();
    localLemon.duration = ((int)paramLong2);
    localLemon.od = paramLong1;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      Lichee localLichee = new Lichee();
      switch (localc.a)
      {
      default: 
        localLichee.qd = 0;
      }
      for (;;)
      {
        localLichee.x = localc.b;
        localLichee.y = localc.c;
        localLichee.rd = localc.d;
        localLichee.radius = localc.e;
        localArrayList.add(localLichee);
        break;
        localLichee.qd = 4;
        continue;
        localLichee.qd = 2;
        continue;
        localLichee.qd = 3;
        continue;
        localLichee.qd = 1;
      }
    }
    localLemon.pd = localArrayList;
    return localLemon;
  }
  
  public final List<c> a(List<c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() <= 20)
    {
      localArrayList.addAll(paramList);
      return localArrayList;
    }
    c localc1 = (c)paramList.get(0);
    c localc2 = (c)paramList.get(paramList.size() - 1);
    paramList.remove(localc1);
    paramList.remove(localc2);
    int j = (int)Math.ceil(paramList.size() / 18);
    localArrayList.add(localc1);
    int i = 1;
    while (i < paramList.size())
    {
      localArrayList.add(paramList.get(i));
      i += j;
    }
    localArrayList.add(localc2);
    return localArrayList;
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getClass().getName();
    Object localObject = (d)this.b.get(paramActivity);
    i.c.remove(localObject);
    this.b.remove(paramActivity);
    localObject = (b)this.c.get(paramActivity);
    i.d.remove(localObject);
    this.c.remove(paramActivity);
  }
  
  public void a(Activity paramActivity, int paramInt, f paramf)
  {
    paramActivity.getApplicationContext();
    this.d = paramf;
    paramf = paramActivity.getClass().getName();
    paramActivity = new d(paramActivity.getClass().getName(), paramInt);
    this.b.put(paramf, paramActivity);
    i.c.add(paramActivity);
    paramActivity = new b(paramInt);
    this.c.put(paramf, paramActivity);
    i.d.add(paramActivity);
  }
  
  public static final class a
    extends cx<c>
  {
    public Object a()
    {
      return new c(null);
    }
  }
  
  private final class b
    implements g
  {
    public int a;
    
    public b(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void a(String paramString, View paramView)
    {
      c.a(c.this).a(paramString, this.a, 3, null);
    }
  }
  
  public class c
  {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    
    public c(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = paramInt;
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramFloat3;
      this.e = paramFloat4;
    }
  }
  
  private class d
  {
    public int a;
    public long b = -1L;
    public long c;
    public List<c.c> d = new ArrayList();
    public String e;
    public boolean f = false;
    public boolean g = false;
    
    public d(String paramString, int paramInt)
    {
      this.a = paramInt;
      this.e = paramString;
    }
    
    public final void a()
    {
      this.b = -1L;
      this.c = 0L;
      this.d.clear();
      this.f = false;
      this.g = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.c
 * JD-Core Version:    0.7.0.1
 */