package com.tencent.beacon.a.b;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e
{
  private static e a = null;
  private String b = "http://strategy.beacon.qq.com/analytics/upload";
  private int c = 3600;
  private SparseArray<a> d = null;
  private Map<String, String> e = null;
  private byte f = 1;
  private byte g = 1;
  private String h = "*^@K#K@!";
  
  private e()
  {
    this.d.put(1, new a(1));
    this.d.put(2, new a(2));
    this.d.put(3, new a(3));
  }
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new e();
      }
      return a;
    }
    finally {}
  }
  
  public final void a(byte paramByte)
  {
    try
    {
      this.f = paramByte;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  /* Error */
  public final a b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/a/b/e:d	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 38	com/tencent/beacon/a/b/e:d	Landroid/util/SparseArray;
    //   13: iload_1
    //   14: invokevirtual 70	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 6	com/tencent/beacon/a/b/e$a
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: aconst_null
    //   26: astore_2
    //   27: goto -6 -> 21
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	e
    //   0	35	1	paramInt	int
    //   20	7	2	locala	a
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final void b(byte paramByte)
  {
    try
    {
      this.g = paramByte;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final boolean c(int paramInt)
  {
    boolean bool = false;
    try
    {
      if (this.d != null) {
        bool = a.a((a)this.d.get(2));
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Map<String, String> d()
  {
    return this.e;
  }
  
  /* Error */
  public final SparseArray<a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/a/b/e:d	Landroid/util/SparseArray;
    //   6: ifnull +23 -> 29
    //   9: new 81	com/tencent/beacon/d/c
    //   12: dup
    //   13: invokespecial 82	com/tencent/beacon/d/c:<init>	()V
    //   16: pop
    //   17: aload_0
    //   18: getfield 38	com/tencent/beacon/a/b/e:d	Landroid/util/SparseArray;
    //   21: invokestatic 85	com/tencent/beacon/d/c:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -6 -> 25
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	e
    //   24	7	1	localSparseArray	SparseArray
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
  }
  
  public final byte f()
  {
    try
    {
      byte b1 = this.f;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final byte g()
  {
    try
    {
      byte b1 = this.g;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String h()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    private final int a;
    private boolean b = false;
    private String c = "";
    private Map<String, String> d = new HashMap(10);
    private Set<String> e = new HashSet(10);
    private com.tencent.beacon.c.e.e f = null;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a(com.tencent.beacon.c.e.e parame)
    {
      this.f = parame;
    }
    
    public final void a(String paramString)
    {
      this.c = paramString;
    }
    
    public final void a(Map<String, String> paramMap)
    {
      this.d = paramMap;
    }
    
    public final void a(Set<String> paramSet)
    {
      this.e = paramSet;
    }
    
    public final void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public final boolean a()
    {
      return this.b;
    }
    
    public final String b()
    {
      return this.c;
    }
    
    public final Map<String, String> c()
    {
      return this.d;
    }
    
    public final Set<String> d()
    {
      return this.e;
    }
    
    public final com.tencent.beacon.c.e.e e()
    {
      return this.f;
    }
    
    public final int f()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.e
 * JD-Core Version:    0.7.0.1
 */