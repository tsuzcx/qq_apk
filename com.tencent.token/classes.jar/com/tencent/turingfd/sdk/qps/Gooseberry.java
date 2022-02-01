package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;
import com.tencent.token.afj;
import java.util.HashMap;
import java.util.Map;

public final class Gooseberry
  extends Orion
  implements Cloneable
{
  public static Map<String, String> a;
  public static Map<Integer, Integer> b;
  public static Map<String, String> c;
  public long e = 0L;
  public boolean f = true;
  public long g = 0L;
  public Map<String, String> h = null;
  public Map<Integer, Integer> i = null;
  public long j = 0L;
  public Map<String, String> k = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("", "");
    b = new HashMap();
    b.put(Integer.valueOf(0), Integer.valueOf(0));
    localHashMap = new HashMap();
    c = localHashMap;
    localHashMap.put("", "");
  }
  
  public final void a(afb paramafb)
  {
    this.e = paramafb.a(this.e, 0, true);
    this.f = paramafb.a(this.f, 1, true);
    this.g = paramafb.a(this.g, 2, true);
    this.h = ((Map)paramafb.a(a, 3, true));
    this.i = ((Map)paramafb.a(b, 4, true));
    this.j = paramafb.a(this.j, 5, true);
    this.k = ((Map)paramafb.a(c, 6, false));
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.e, 0);
    paramafd.a((byte)this.f, 1);
    paramafd.a(this.g, 2);
    paramafd.a(this.h, 3);
    paramafd.a(this.i, 4);
    paramafd.a(this.j, 5);
    Map localMap = this.k;
    if (localMap != null) {
      paramafd.a(localMap, 6);
    }
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (d) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Gooseberry)paramObject;
    if (afj.a(this.e, paramObject.e))
    {
      int m;
      if (this.f == paramObject.f) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m != 0) && (afj.a(this.g, paramObject.g)) && (this.h.equals(paramObject.h)) && (this.i.equals(paramObject.i)) && (afj.a(this.j, paramObject.j)) && (this.k.equals(paramObject.k))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Gooseberry
 * JD-Core Version:    0.7.0.1
 */