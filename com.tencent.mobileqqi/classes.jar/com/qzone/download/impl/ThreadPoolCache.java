package com.qzone.download.impl;

import com.qzone.utils.thread.ThreadPool;
import java.util.HashMap;

public class ThreadPoolCache
{
  private final String mName;
  private final int mPoolSize;
  private final HashMap<String, ThreadPool> mThreadPoolMap = new HashMap();
  
  ThreadPoolCache(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.mName = str;
    this.mPoolSize = i;
  }
  
  public ThreadPool get(String paramString)
  {
    paramString = this.mName + "-" + paramString;
    ??? = (ThreadPool)this.mThreadPoolMap.get(paramString);
    if (??? != null) {
      return ???;
    }
    ThreadPool localThreadPool;
    synchronized (this.mThreadPoolMap)
    {
      localThreadPool = (ThreadPool)this.mThreadPoolMap.get(paramString);
      if (localThreadPool != null) {
        return localThreadPool;
      }
      localThreadPool = new ThreadPool(paramString, this.mPoolSize, this.mPoolSize);
    }
    try
    {
      this.mThreadPoolMap.put(paramString, localThreadPool);
      return localThreadPool;
    }
    finally {}
    paramString = finally;
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.impl.ThreadPoolCache
 * JD-Core Version:    0.7.0.1
 */