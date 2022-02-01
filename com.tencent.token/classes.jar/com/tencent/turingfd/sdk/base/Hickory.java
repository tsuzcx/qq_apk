package com.tencent.turingfd.sdk.base;

import com.tencent.token.aeq;
import com.tencent.token.afk;
import com.tencent.token.afn;
import java.util.HashMap;
import java.util.Map;

public final class Hickory
  extends break
  implements Cloneable
{
  public static Map<String, String> _c;
  public static Map<Integer, Integer> ad;
  public static Map<String, String> bd;
  public long dd = 0L;
  public boolean ed = true;
  public Map<Integer, Integer> gd = null;
  public long hd = 0L;
  public Map<String, String> jd = null;
  public Map<String, String> path = null;
  public long version = 0L;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _c = localHashMap;
    localHashMap.put("", "");
    ad = new HashMap();
    ad.put(Integer.valueOf(0), Integer.valueOf(0));
    localHashMap = new HashMap();
    bd = localHashMap;
    localHashMap.put("", "");
  }
  
  public final void a(afk paramafk)
  {
    this.dd = paramafk.a(this.dd, 0, true);
    this.ed = paramafk.a(this.ed, 1, true);
    this.version = paramafk.a(this.version, 2, true);
    this.path = ((Map)paramafk.a(_c, 3, true));
    this.gd = ((Map)paramafk.a(ad, 4, true));
    this.hd = paramafk.a(this.hd, 5, true);
    this.jd = ((Map)paramafk.a(bd, 6, false));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.dd, 0);
    paramafn.a((byte)this.ed, 1);
    paramafn.a(this.version, 2);
    paramafn.a(this.path, 3);
    paramafn.a(this.gd, 4);
    paramafn.a(this.hd, 5);
    Map localMap = this.jd;
    if (localMap != null) {
      paramafn.a(localMap, 6);
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
    if (cd) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (Hickory)paramObject;
    return (aeq.a(this.dd, paramObject.dd)) && (aeq.a(this.ed, paramObject.ed)) && (aeq.a(this.version, paramObject.version)) && (aeq.a(this.path, paramObject.path)) && (aeq.a(this.gd, paramObject.gd)) && (aeq.a(this.hd, paramObject.hd)) && (aeq.a(this.jd, paramObject.jd));
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.Hickory
 * JD-Core Version:    0.7.0.1
 */