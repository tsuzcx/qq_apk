package com.tencent.qqmail.utilities.thread;

import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class QMSchedulers
{
  private static final String AVATAR_POOL = "QMAvatarPool";
  private static Scheduler BackgroundScheduler;
  private static final String COMMON_POOL = "QMCommonPool";
  private static final String FUTURE_POOL = "QMFutureTaskPool";
  private static Scheduler FutureTaskScheduler;
  private static final String IMAGE_POOL = "QMImagePool";
  private static Scheduler IOScheduler;
  private static final String IO_POOL = "QMIOPool";
  private static final String NETWORK_POOL = "QMNetworkPool";
  private static final String OSSLOG_POOL = "OssLog";
  private static final String PRELOAD_POOL = "QMPreloadPool";
  private static final String TAG = "QMScheduler";
  private static final ThreadPoolExecutor avatar = new ThreadPoolExecutor(3, 2147483647, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new MThreadFactory("QMAvatarPool", 2), new LogRejectedExecutionHandler("QMAvatarPool"));
  private static Scheduler avatarScheduler = Schedulers.from(avatar);
  public static final ScheduledThreadPoolExecutor background;
  public static final ThreadPoolExecutor futureTask;
  public static final ThreadPoolExecutor io = new ThreadPoolExecutor(3, 2147483647, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new MThreadFactory("QMIOPool", 3), new LogRejectedExecutionHandler("QMIOPool"));
  public static final ThreadPoolExecutor network;
  private static Scheduler networkScheduler;
  
  static
  {
    IOScheduler = Schedulers.from(io);
    futureTask = new ThreadPoolExecutor(5, 2147483647, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(5), new MThreadFactory("QMFutureTaskPool", 4), new LogRejectedExecutionHandler("QMFutureTaskPool"));
    FutureTaskScheduler = Schedulers.from(futureTask);
    background = new ScheduledThreadPoolExecutor(5, new MThreadFactory("QMCommonPool", 3), new LogRejectedExecutionHandler("QMCommonPool"));
    BackgroundScheduler = Schedulers.from(background);
    network = new ThreadPoolExecutor(5, 2147483647, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, new QMSchedulers.1()), new MThreadFactory("QMNetworkPool", 4), new LogRejectedExecutionHandler("QMNetworkPool"));
    networkScheduler = Schedulers.from(network);
  }
  
  public static Scheduler avatar()
  {
    return avatarScheduler;
  }
  
  public static Scheduler background()
  {
    return BackgroundScheduler;
  }
  
  public static Scheduler futureTask()
  {
    return FutureTaskScheduler;
  }
  
  public static Scheduler io()
  {
    return IOScheduler;
  }
  
  public static Scheduler network()
  {
    return networkScheduler;
  }
  
  static class LogRejectedExecutionHandler
    implements RejectedExecutionHandler
  {
    private String name;
    
    public LogRejectedExecutionHandler(String paramString)
    {
      this.name = paramString;
    }
    
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      QMLog.log(7, "QMScheduler", "rejectedExecution, pool: " + this.name + ", runnable: " + paramRunnable + ", executor: " + paramThreadPoolExecutor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.thread.QMSchedulers
 * JD-Core Version:    0.7.0.1
 */