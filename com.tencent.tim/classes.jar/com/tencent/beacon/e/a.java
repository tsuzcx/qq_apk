package com.tencent.beacon.e;

import java.util.Map;

public class a
  implements c
{
  private static volatile a a;
  public boolean b = false;
  private String c = "oth.str.mdt.qq.com";
  private int d = 360;
  private int e = 100;
  private Map<String, String> f = null;
  private boolean g = false;
  private d h = new d(1);
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/beacon/e/a:f	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: aload_1
    //   13: invokeinterface 58 2 0
    //   18: checkcast 60	java/lang/String
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aconst_null
    //   27: astore_1
    //   28: goto -6 -> 22
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	a
    //   0	36	1	paramString	String
    //   6	6	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	22	31	finally
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(Map<String, String> paramMap)
  {
    try
    {
      this.f = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String b(String paramString)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((d)localObject).a();
      if (localObject != null) {
        return (String)((Map)localObject).get(paramString);
      }
    }
    return null;
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/beacon/e/a:f	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +55 -> 63
    //   11: aload_3
    //   12: ldc 71
    //   14: invokeinterface 58 2 0
    //   19: checkcast 60	java/lang/String
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +39 -> 63
    //   27: aload_3
    //   28: invokevirtual 75	java/lang/String:trim	()Ljava/lang/String;
    //   31: ldc 77
    //   33: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifne +27 -> 63
    //   39: aload_0
    //   40: getfield 35	com/tencent/beacon/e/a:e	I
    //   43: istore_1
    //   44: aload_3
    //   45: invokestatic 87	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: istore_2
    //   49: iload_2
    //   50: istore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: astore_3
    //   56: aload_3
    //   57: invokestatic 92	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   60: goto -9 -> 51
    //   63: aload_0
    //   64: getfield 35	com/tencent/beacon/e/a:e	I
    //   67: istore_1
    //   68: goto -17 -> 51
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   43	25	1	i	int
    //   48	2	2	j	int
    //   6	39	3	localObject1	Object
    //   55	2	3	localException	java.lang.Exception
    //   71	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	49	55	java/lang/Exception
    //   2	7	71	finally
    //   11	23	71	finally
    //   27	44	71	finally
    //   44	49	71	finally
    //   56	60	71	finally
    //   63	68	71	finally
  }
  
  public d d()
  {
    return this.h;
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/beacon/e/a:f	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +46 -> 54
    //   11: ldc 96
    //   13: aload_3
    //   14: ldc 98
    //   16: invokeinterface 58 2 0
    //   21: checkcast 60	java/lang/String
    //   24: invokevirtual 102	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   27: ifeq +27 -> 54
    //   30: invokestatic 108	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: bipush 11
    //   35: invokevirtual 111	java/util/Calendar:get	(I)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifne +9 -> 49
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_2
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_2
    //   51: goto -6 -> 45
    //   54: iconst_0
    //   55: istore_2
    //   56: goto -11 -> 45
    //   59: astore_3
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   38	2	1	i	int
    //   44	12	2	bool	boolean
    //   6	8	3	localMap	Map
    //   59	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	59	finally
    //   11	39	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.e.a
 * JD-Core Version:    0.7.0.1
 */