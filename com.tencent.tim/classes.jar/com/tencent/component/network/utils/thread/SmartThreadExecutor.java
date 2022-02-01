package com.tencent.component.network.utils.thread;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.component.network.module.base.Config;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SmartThreadExecutor
  implements Handler.Callback, Executor
{
  private static final long CHECK_PERIOD = TimeUnit.SECONDS.toMillis(30L);
  private static final int FIRST_ANTI_JITTER_TEMP_WORKER_SIZE = 2;
  private static final long FIRST_CHECK_PERIOD = TimeUnit.SECONDS.toMillis(2L);
  private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
  private static final int MAX_TEMP_THREAD_CNT = 2;
  private static final int MSG_WHAT_CHK_BASE = 7500;
  private static final String MTA_REPORT_EVENT = "qzone_downloader_smart_thread_event_temp_thread";
  private static final String MTA_REPORT_TYPE_START = "start";
  private static final String MTA_REPORT_TYPE_TOTAL = "total";
  private static final String MTA_REPORT_TYPE_VALID = "valid";
  private static final String TAG = "SmartThreadExecutor";
  private static final int TEMP_THREAD_VALID_REPORT_TIME_IN_SEC = 2;
  private static volatile int sAliveCnt = 0;
  private static volatile HandlerThread sChkThread;
  private int antiJitterTempWorkerSize;
  private final SmartThreadFactory factory = new SmartThreadFactory(null);
  private final Handler handler;
  private final int id = ID_GENERATOR.getAndIncrement();
  private volatile boolean isAlive = true;
  private final AtomicBoolean isNeedTempWorker = new AtomicBoolean(false);
  private String lastTaskId;
  private final int msgWhat = this.id + 7500;
  private final Executor normExecutor;
  private final LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
  private final List<TempTask> tempThreads = new LinkedList();
  
  public SmartThreadExecutor(Executor paramExecutor)
  {
    Log.i("SmartThreadExecutor", "SmartThreadExecutor: " + this.id);
    this.normExecutor = paramExecutor;
    try
    {
      if (sChkThread == null)
      {
        sChkThread = new HandlerThread("smart-check-thread", 10);
        sChkThread.start();
      }
      sAliveCnt += 1;
      for (;;)
      {
        paramExecutor = sChkThread.getLooper();
        if (paramExecutor != null) {
          break;
        }
        Thread.yield();
      }
      this.handler = new Handler(paramExecutor, this);
    }
    finally {}
    this.handler.sendEmptyMessageDelayed(this.msgWhat, FIRST_CHECK_PERIOD);
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (!this.isAlive) {
      return;
    }
    this.normExecutor.execute(new IdTask(paramRunnable, null));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMessage.what != this.msgWhat) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!this.isAlive);
    Log.i("SmartThreadExecutor", "handleMessage: start check " + this.id);
    paramMessage = (Runnable)this.taskQueue.peek();
    if ((paramMessage instanceof IdTask)) {}
    for (paramMessage = ((IdTask)paramMessage).id;; paramMessage = null)
    {
      for (;;)
      {
        if ((this.isAlive) && (paramMessage != null) && (paramMessage.equals(this.lastTaskId)))
        {
          this.isNeedTempWorker.set(true);
          this.antiJitterTempWorkerSize = 2;
          synchronized (this.tempThreads)
          {
            if ((this.isAlive) && (this.tempThreads.size() < 2))
            {
              Log.i("SmartThreadExecutor", "handleMessage: start temp task " + this.id);
              Object localObject2 = new TempTask(null);
              this.factory.newThread((Runnable)localObject2).start();
              this.tempThreads.add(localObject2);
              localObject2 = new Properties();
              ((Properties)localObject2).put("start", Integer.valueOf(1));
              Config.reportToMta("qzone_downloader_smart_thread_event_temp_thread", (Properties)localObject2);
            }
            Log.i("SmartThreadExecutor", "handleMessage: check end " + this.id + " " + this.antiJitterTempWorkerSize + " " + this.isNeedTempWorker.get());
            this.lastTaskId = paramMessage;
            bool1 = bool2;
            if (!this.isAlive) {
              break;
            }
            this.handler.sendEmptyMessageDelayed(this.msgWhat, CHECK_PERIOD);
            return true;
          }
        }
      }
      ??? = this.isNeedTempWorker;
      int i = this.antiJitterTempWorkerSize - 1;
      this.antiJitterTempWorkerSize = i;
      if (i > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        ((AtomicBoolean)???).compareAndSet(true, bool1);
        break;
      }
    }
  }
  
  public void shutdown()
  {
    this.isAlive = false;
    if ((this.normExecutor instanceof ExecutorService)) {
      ((ExecutorService)this.normExecutor).shutdownNow();
    }
    this.handler.removeMessages(this.msgWhat);
    synchronized (this.tempThreads)
    {
      Iterator localIterator = this.tempThreads.iterator();
      while (localIterator.hasNext())
      {
        Thread localThread = ((TempTask)localIterator.next()).currentThread;
        if (localThread != null) {
          localThread.interrupt();
        }
      }
    }
    this.tempThreads.clear();
    try
    {
      int i = sAliveCnt - 1;
      sAliveCnt = i;
      if (i < 1) {
        sChkThread.quit();
      }
      return;
    }
    finally {}
  }
  
  static class IdTask
    implements Comparable<IdTask>, Runnable
  {
    private final String id = UUID.randomUUID().toString();
    private final Runnable task;
    
    private IdTask(Runnable paramRunnable)
    {
      this.task = paramRunnable;
    }
    
    public int compareTo(IdTask paramIdTask)
    {
      if (this.task == null) {
        return -1;
      }
      if (paramIdTask.task == null) {
        return 1;
      }
      if ((this.task.getClass() == paramIdTask.task.getClass()) && ((this.task instanceof Comparable))) {
        return ((Comparable)this.task).compareTo(paramIdTask.task);
      }
      return this.id.compareTo(paramIdTask.id);
    }
    
    public void run()
    {
      if (this.task != null) {
        this.task.run();
      }
    }
  }
  
  static class SmartThreadFactory
    implements ThreadFactory
  {
    private static final AtomicInteger ID = new AtomicInteger();
    private static final String TAG = "SmartThreadFactory";
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new SmartThreadExecutor.SmartThreadFactory.1(this, "smart-" + ID.incrementAndGet(), paramRunnable);
      paramRunnable.setPriority(5);
      paramRunnable.setDaemon(false);
      return paramRunnable;
    }
  }
  
  class TempTask
    implements Runnable
  {
    private static final String TAG = "TempTask";
    private volatile Thread currentThread;
    
    private TempTask() {}
    
    public void run()
    {
      Log.i("TempTask", "run: start");
      this.currentThread = Thread.currentThread();
      int i = 1;
      if ((SmartThreadExecutor.this.isAlive) && (SmartThreadExecutor.this.isNeedTempWorker.get())) {}
      label285:
      for (;;)
      {
        try
        {
          Object localObject1 = (Runnable)SmartThreadExecutor.this.taskQueue.take();
          if (localObject1 == null) {
            break label285;
          }
          Log.i("TempTask", "run: execute task " + localObject1.getClass().getSimpleName());
          long l = System.nanoTime();
          ((Runnable)localObject1).run();
          l = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - l);
          Log.i("TempTask", "run: execute task pass time " + l);
          if (l <= 2L)
          {
            localObject1 = new Properties();
            ((Properties)localObject1).put("total", Integer.valueOf(1));
            if (i != 0) {
              ((Properties)localObject1).put("valid", Integer.valueOf(1));
            }
            Config.reportToMta("qzone_downloader_smart_thread_event_temp_thread", (Properties)localObject1);
          }
          i = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.i("TempTask", "run: interrupted " + localInterruptedException.getMessage());
          ??? = null;
          continue;
        }
        synchronized (SmartThreadExecutor.this.tempThreads)
        {
          SmartThreadExecutor.this.tempThreads.remove(this);
          this.currentThread = null;
          Log.i("TempTask", "run: end");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor
 * JD-Core Version:    0.7.0.1
 */