package com.tencent.turingfd.sdk.base;

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
    _c = new HashMap();
    _c.put("", "");
    ad = new HashMap();
    ad.put(Integer.valueOf(0), Integer.valueOf(0));
    bd = new HashMap();
    bd.put("", "");
  }
  
  public void a(cy paramcy)
  {
    this.dd = paramcy.a(this.dd, 0, true);
    this.ed = paramcy.a(this.ed, 1, true);
    this.version = paramcy.a(this.version, 2, true);
    this.path = ((Map)paramcy.a(_c, 3, true));
    this.gd = ((Map)paramcy.a(ad, 4, true));
    this.hd = paramcy.a(this.hd, 5, true);
    this.jd = ((Map)paramcy.a(bd, 6, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.dd, 0);
    paramdb.a(this.ed, 1);
    paramdb.a(this.version, 2);
    paramdb.a(this.path, 3);
    paramdb.a(this.gd, 4);
    paramdb.a(this.hd, 5);
    Map localMap = this.jd;
    if (localMap != null) {
      paramdb.a(localMap, 6);
    }
  }
  
  public Object clone()
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
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (Hickory)paramObject;
    boolean bool1 = bool2;
    if (ce.a(this.dd, paramObject.dd))
    {
      bool1 = bool2;
      if (ce.a(this.ed, paramObject.ed))
      {
        bool1 = bool2;
        if (ce.a(this.version, paramObject.version))
        {
          bool1 = bool2;
          if (ce.a(this.path, paramObject.path))
          {
            bool1 = bool2;
            if (ce.a(this.gd, paramObject.gd))
            {
              bool1 = bool2;
              if (ce.a(this.hd, paramObject.hd))
              {
                bool1 = bool2;
                if (ce.a(this.jd, paramObject.jd)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
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