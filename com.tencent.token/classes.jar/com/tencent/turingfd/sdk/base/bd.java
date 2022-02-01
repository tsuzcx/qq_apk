package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class bd
{
  public static bd a = new bd();
  public static Map<Integer, Integer> b = new HashMap();
  public Map<Integer, Integer> c = new HashMap();
  public Map<Integer, Integer> d = new HashMap();
  public Map<Integer, Integer> e = new HashMap();
  public ba f;
  
  static
  {
    b.put(Integer.valueOf(Gooseberry.Wj.value), Integer.valueOf(0));
    b.put(Integer.valueOf(10001), Integer.valueOf(0));
    b.put(Integer.valueOf(Gooseberry.Uj.value), Integer.valueOf(0));
    b.put(Integer.valueOf(Gooseberry.qk.value), Integer.valueOf(0));
  }
  
  public String a()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.c.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.c.get(localObject3)).intValue() == 0) {
        ((Set)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    localObject2 = new StringBuilder();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      if (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(",");
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(Context paramContext)
  {
    try
    {
      this.c.clear();
      Object localObject = b.keySet().iterator();
      Integer localInteger;
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.c.putAll(b);
      paramContext = bc.a.a(paramContext);
      localObject = paramContext.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.c.putAll(paramContext);
      paramContext = this.d.keySet().iterator();
      int i;
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (a(i)) {
          this.c.put(Integer.valueOf(i), this.d.get(Integer.valueOf(i)));
        }
      }
      paramContext = this.e.keySet().iterator();
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (a(i)) {
          this.c.put(Integer.valueOf(i), this.e.get(Integer.valueOf(i)));
        }
      }
      if (a(Gooseberry.Uj.value))
      {
        this.c.put(Integer.valueOf(Gooseberry.nk.value), Integer.valueOf(0));
        this.c.put(Integer.valueOf(Gooseberry.qk.value), Integer.valueOf(0));
      }
      paramContext = this.c.keySet().iterator();
      while (paramContext.hasNext()) {
        localObject = (Integer)paramContext.next();
      }
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    if (!this.c.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    HashMap localHashMap;
    label144:
    try
    {
      long l = bc.a.c(paramContext);
      paramLong = Math.abs(System.currentTimeMillis() - paramLong);
      if (paramLong <= l * 1000L) {
        return false;
      }
      localObject = new byte[0];
      localHashMap = new HashMap();
      StringBuilder localStringBuilder = ci.a("");
      localStringBuilder.append(cv.a);
      localHashMap.put("1", localStringBuilder.toString());
      localHashMap.put("101", paramString1);
      localHashMap.put("2002", bc.a.e(paramContext));
      localHashMap.put("207", paramString2);
    }
    finally {}
    try
    {
      paramString1 = TuringDIDService.aa.e(cm.e(), paramContext, localHashMap, paramInt);
      if (cm.a(paramString1) != 0) {
        paramString1 = (String)localObject;
      } else {
        paramString1 = cm.b(paramString1);
      }
    }
    catch (Throwable paramString1)
    {
      paramString1 = (String)localObject;
      break label144;
    }
    int i = paramString1.length;
    boolean bool = true;
    if (i != 0)
    {
      paramString1 = as.a(((ap)this.f).a, paramContext, paramString1, 8119, 18119);
      if (paramString1.b != 0) {
        paramString1 = new byte[0];
      } else {
        paramString1 = paramString1.a();
      }
      if (paramInt != 1) {}
    }
    try
    {
      paramString1 = TuringDIDService.aa.f(cm.e(), paramString1, paramInt);
      paramString1 = cm.b(paramString1);
      break label233;
      if (paramInt != 0) {
        paramString1 = new byte[0];
      }
      label233:
      paramString2 = new Kiwifruit();
      paramString1 = new cy(paramString1);
      paramString2.ld = paramString1.a(paramString2.ld, 0, true);
      paramString2.md = ((Hickory)paramString1.a(Kiwifruit.kd, 1, false));
      paramString2.Jb = paramString1.a(paramString2.Jb, 2, true);
      if (paramString2.ld >= 0)
      {
        if (paramString2.ld == 1)
        {
          paramString1 = new Hickory();
          break label451;
        }
        paramString2 = paramString2.md;
        if (paramString2 == null)
        {
          paramString1 = new Hickory();
          break label451;
        }
        paramString1 = paramString2.gd.keySet().iterator();
        while (paramString1.hasNext()) {
          localObject = (Integer)paramString1.next();
        }
        localObject = paramString2.jd;
        paramString1 = paramString2;
        if (localObject == null) {
          break label451;
        }
        localObject = ((Map)localObject).keySet().iterator();
        for (;;)
        {
          paramString1 = paramString2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramString1 = (String)((Iterator)localObject).next();
        }
      }
    }
    catch (Throwable paramString1)
    {
      label449:
      break label449;
    }
    paramString1 = null;
    label451:
    if (paramString1 == null)
    {
      bool = false;
    }
    else
    {
      paramString2 = paramString1.gd;
      localObject = bc.a;
      if ((paramString2 != null) && (paramString2.size() != 0)) {
        ((bc)localObject).a(paramContext, paramString1);
      } else {
        ((bc)localObject).d(paramContext);
      }
    }
    return bool;
  }
  
  public String b(Context paramContext)
  {
    return bc.a.b(paramContext);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.e.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bd
 * JD-Core Version:    0.7.0.1
 */