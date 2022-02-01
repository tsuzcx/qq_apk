package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import com.tencent.token.agu;
import java.util.HashMap;
import java.util.Map;

public final class Ginkgo
  extends final
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
  
  public final void a(agd paramagd)
  {
    this.e = paramagd.a(this.e, 0, true);
    this.f = paramagd.a(this.f, 1, true);
    this.g = paramagd.a(this.g, 2, true);
    this.h = ((Map)paramagd.a(a, 3, true));
    this.i = ((Map)paramagd.a(b, 4, true));
    this.j = paramagd.a(this.j, 5, true);
    this.k = ((Map)paramagd.a(c, 6, false));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.e, 0);
    paramage.a((byte)this.f, 1);
    paramage.a(this.g, 2);
    paramage.a(this.h, 3);
    paramage.a(this.i, 4);
    paramage.a(this.j, 5);
    Map localMap = this.k;
    if (localMap != null) {
      paramage.a(localMap, 6);
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
    paramObject = (Ginkgo)paramObject;
    if (agu.a(this.e, paramObject.e))
    {
      int m;
      if (this.f == paramObject.f) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m != 0) && (agu.a(this.g, paramObject.g)) && (this.h.equals(paramObject.h)) && (this.i.equals(paramObject.i)) && (agu.a(this.j, paramObject.j)) && (this.k.equals(paramObject.k))) {
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
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Ginkgo
 * JD-Core Version:    0.7.0.1
 */