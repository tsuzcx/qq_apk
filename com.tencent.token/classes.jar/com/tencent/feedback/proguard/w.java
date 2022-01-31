package com.tencent.feedback.proguard;

import android.util.SparseArray;

public final class w
{
  public static boolean a = false;
  private SparseArray<a> b = null;
  private String c = "http://monitor.uu.qq.com/analytics/rqdsync";
  private int d = -1;
  private int e = 6;
  private String f = "";
  private String g = "";
  private boolean h = true;
  private boolean i = false;
  
  public w()
  {
    this.b.append(3, new a(3));
    this.b = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("S(@L@L").append("@)");
    this.g = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    localStringBuilder.append("*^@K#K").append("@!");
    this.f = localStringBuilder.toString();
  }
  
  public final String a()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int b()
  {
    try
    {
      int j = this.d;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.e = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int c()
  {
    try
    {
      int j = this.e;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final a c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/feedback/proguard/w:b	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 30	com/tencent/feedback/proguard/w:b	Landroid/util/SparseArray;
    //   13: iload_1
    //   14: invokevirtual 87	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 6	com/tencent/feedback/proguard/w$a
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
    //   0	35	0	this	w
    //   0	35	1	paramInt	int
    //   20	7	2	locala	a
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final String d()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean f()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean g()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    private String a = "http://monitor.uu.qq.com/analytics/rqdsync";
    private boolean b = false;
    private boolean c = true;
    private boolean d = false;
    
    public a(int paramInt) {}
    
    public final String a()
    {
      try
      {
        String str = this.a;
        return str;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      try
      {
        this.b = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final boolean b()
    {
      try
      {
        boolean bool = this.b;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final boolean c()
    {
      try
      {
        boolean bool = this.c;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final boolean d()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.w
 * JD-Core Version:    0.7.0.1
 */