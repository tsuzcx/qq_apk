package com.tencent.moai.downloader.thread;

import com.tencent.moai.downloader.GlobalConfig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager
{
  private static final String TAG = "ThreadManager";
  private static ThreadManager instance;
  private ExecutorService executorService = Executors.newFixedThreadPool(GlobalConfig.MAX_THREAD_SIZE);
  
  public static ThreadManager createInstance()
  {
    instance = new ThreadManager();
    return instance;
  }
  
  public static ThreadManager shareInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ThreadManager();
      }
      return instance;
    }
    finally {}
  }
  
  public void start(Runnable paramRunnable)
  {
    this.executorService.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */