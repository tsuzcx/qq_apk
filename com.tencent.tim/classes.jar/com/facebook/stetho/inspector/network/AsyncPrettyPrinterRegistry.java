package com.facebook.stetho.inspector.network;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class AsyncPrettyPrinterRegistry
{
  private final Map<String, AsyncPrettyPrinterFactory> mRegistry = new HashMap();
  
  @Nullable
  public AsyncPrettyPrinterFactory lookup(String paramString)
  {
    try
    {
      paramString = (AsyncPrettyPrinterFactory)this.mRegistry.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void register(String paramString, AsyncPrettyPrinterFactory paramAsyncPrettyPrinterFactory)
  {
    try
    {
      this.mRegistry.put(paramString, paramAsyncPrettyPrinterFactory);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean unregister(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/facebook/stetho/inspector/network/AsyncPrettyPrinterRegistry:mRegistry	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 41 2 0
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +9 -> 23
    //   17: iconst_1
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	AsyncPrettyPrinterRegistry
    //   0	33	1	paramString	String
    //   18	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.AsyncPrettyPrinterRegistry
 * JD-Core Version:    0.7.0.1
 */