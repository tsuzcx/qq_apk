package com.tencent.map.sdk.a;

import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class os
{
  private static final ow.f<a> a = ow.a(30, new os.1());
  private static volatile AtomicInteger b = new AtomicInteger();
  private static HashSet<String> c = new HashSet();
  private static Map<String, Map<String, b>> d = Collections.synchronizedMap(new Hashtable());
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    Map localMap = (Map)d.get(paramString1);
    if (localMap != null) {}
    for (paramString1 = (b)localMap.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        if (paramString1.a != null) {
          localObject = paramString1.a.get(paramString2);
        }
        if ((localObject instanceof AtomicInteger))
        {
          int i = paramInt;
          if (paramInt <= 0) {
            i = 1;
          }
          paramInt = ((AtomicInteger)localObject).get() + i;
          ((AtomicInteger)localObject).set(paramInt);
          return paramInt;
        }
        localObject = new AtomicInteger(1);
        if (paramString1.a == null) {
          paramString1.a = new Hashtable();
        }
        paramString1.a.put(paramString2, localObject);
        return 1;
      }
      return -1;
    }
  }
  
  public static a a(String paramString)
  {
    b.incrementAndGet();
    a locala = (a)a.a();
    locala.a = paramString;
    return locala;
  }
  
  public static void a() {}
  
  public static void b() {}
  
  public static void b(String paramString)
  {
    c.add(paramString);
  }
  
  public static void c() {}
  
  public static int d()
  {
    return 0;
  }
  
  public static int e()
  {
    return -1;
  }
  
  public static long f()
  {
    return 0L;
  }
  
  public static long g()
  {
    return 0L;
  }
  
  public static final class a
    implements ow.g
  {
    String a = "TM-SDK";
    private int b = 3;
    
    public final void a()
    {
      os.h().incrementAndGet();
      os.i();
      os.j().a(this);
    }
    
    @NonNull
    public final ow.k b()
    {
      return new ow.c();
    }
  }
  
  public static final class b
  {
    Map<String, Object> a;
    private String b;
    
    public final String toString()
    {
      return "TraceInfo{id='" + this.b + '\'' + ", values=" + this.a + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.os
 * JD-Core Version:    0.7.0.1
 */