package com.facebook.stetho.server.http;

import java.util.ArrayList;

public class HandlerRegistry
{
  private final ArrayList<HttpHandler> mHttpHandlers = new ArrayList();
  private final ArrayList<PathMatcher> mPathMatchers = new ArrayList();
  
  /* Error */
  @android.support.annotation.Nullable
  public HttpHandler lookup(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/facebook/stetho/server/http/HandlerRegistry:mPathMatchers	Ljava/util/ArrayList;
    //   6: invokevirtual 28	java/util/ArrayList:size	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmpge +46 -> 60
    //   17: aload_0
    //   18: getfield 18	com/facebook/stetho/server/http/HandlerRegistry:mPathMatchers	Ljava/util/ArrayList;
    //   21: iload_2
    //   22: invokevirtual 32	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 34	com/facebook/stetho/server/http/PathMatcher
    //   28: aload_1
    //   29: invokeinterface 38 2 0
    //   34: ifeq +19 -> 53
    //   37: aload_0
    //   38: getfield 20	com/facebook/stetho/server/http/HandlerRegistry:mHttpHandlers	Ljava/util/ArrayList;
    //   41: iload_2
    //   42: invokevirtual 32	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   45: checkcast 40	com/facebook/stetho/server/http/HttpHandler
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -45 -> 12
    //   60: aconst_null
    //   61: astore_1
    //   62: goto -13 -> 49
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	HandlerRegistry
    //   0	70	1	paramString	java.lang.String
    //   11	46	2	i	int
    //   9	6	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	10	65	finally
    //   17	49	65	finally
  }
  
  public void register(PathMatcher paramPathMatcher, HttpHandler paramHttpHandler)
  {
    try
    {
      this.mPathMatchers.add(paramPathMatcher);
      this.mHttpHandlers.add(paramHttpHandler);
      return;
    }
    finally
    {
      paramPathMatcher = finally;
      throw paramPathMatcher;
    }
  }
  
  /* Error */
  public boolean unregister(PathMatcher paramPathMatcher, HttpHandler paramHttpHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/facebook/stetho/server/http/HandlerRegistry:mPathMatchers	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 53	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   10: istore_3
    //   11: iload_3
    //   12: iflt +41 -> 53
    //   15: aload_2
    //   16: aload_0
    //   17: getfield 20	com/facebook/stetho/server/http/HandlerRegistry:mHttpHandlers	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 32	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: if_acmpne +29 -> 53
    //   27: aload_0
    //   28: getfield 18	com/facebook/stetho/server/http/HandlerRegistry:mPathMatchers	Ljava/util/ArrayList;
    //   31: iload_3
    //   32: invokevirtual 56	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   35: pop
    //   36: aload_0
    //   37: getfield 20	com/facebook/stetho/server/http/HandlerRegistry:mHttpHandlers	Ljava/util/ArrayList;
    //   40: iload_3
    //   41: invokevirtual 56	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   44: pop
    //   45: iconst_1
    //   46: istore 4
    //   48: aload_0
    //   49: monitorexit
    //   50: iload 4
    //   52: ireturn
    //   53: iconst_0
    //   54: istore 4
    //   56: goto -8 -> 48
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	HandlerRegistry
    //   0	64	1	paramPathMatcher	PathMatcher
    //   0	64	2	paramHttpHandler	HttpHandler
    //   10	31	3	i	int
    //   46	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   15	45	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.HandlerRegistry
 * JD-Core Version:    0.7.0.1
 */