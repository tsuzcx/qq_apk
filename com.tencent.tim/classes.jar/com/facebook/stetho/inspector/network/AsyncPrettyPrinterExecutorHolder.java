package com.facebook.stetho.inspector.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

final class AsyncPrettyPrinterExecutorHolder
{
  private static ExecutorService sExecutorService;
  
  public static void ensureInitialized()
  {
    if (sExecutorService == null) {
      sExecutorService = Executors.newCachedThreadPool();
    }
  }
  
  @Nullable
  public static ExecutorService getExecutorService()
  {
    return sExecutorService;
  }
  
  public static void shutdown()
  {
    sExecutorService.shutdown();
    sExecutorService = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.AsyncPrettyPrinterExecutorHolder
 * JD-Core Version:    0.7.0.1
 */