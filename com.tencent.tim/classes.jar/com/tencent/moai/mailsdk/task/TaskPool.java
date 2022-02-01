package com.tencent.moai.mailsdk.task;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;

public class TaskPool
{
  public static final int MAX_DOWNLOAD_HANDLER_NUM = 4;
  public static final int MAX_HANDLER_NUM = 4;
  public static final int MAX_POP_HANDLER_NUM = 5;
  private static final String TAG = "TaskPool";
  public static final int TASKPOOL_TYPE_IMAP_DOWNLOAD = 2;
  public static final int TASKPOOL_TYPE_IMAP_MAIL = 1;
  public static final int TASKPOOL_TYPE_POP = 3;
  public static final int TASKPOOL_TYPE_SMTP = 4;
  private ThreadPoolExecutor executorService;
  private final ThreadLocal<Handler> handlerLocal = new TaskPool.1(this);
  private int maxSize;
  private Profile profile;
  private int protocolType;
  private String tag;
  private int type;
  
  public TaskPool(Profile paramProfile, int paramInt1, int paramInt2, int paramInt3)
  {
    this.profile = paramProfile;
    this.protocolType = paramInt1;
    this.maxSize = paramInt2;
    this.type = paramInt3;
    initExecutor();
  }
  
  private Observable<Void> create(Task paramTask, Handler paramHandler)
  {
    return Observable.create(new TaskPool.2(this, paramTask, paramHandler));
  }
  
  /* Error */
  private void doTask(Task paramTask, Handler paramHandler, Subscriber paramSubscriber)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 70	com/tencent/moai/mailsdk/task/TaskPool:getThreadMsg	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload_2
    //   7: ifnonnull +56 -> 63
    //   10: bipush 6
    //   12: ldc 20
    //   14: new 103	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   21: ldc 106
    //   23: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokeinterface 115 1 0
    //   32: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 4
    //   37: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   46: aload_3
    //   47: new 126	com/tencent/moai/mailsdk/exception/MessageException
    //   50: dup
    //   51: iconst_1
    //   52: ldc 127
    //   54: ldc 129
    //   56: invokespecial 132	com/tencent/moai/mailsdk/exception/MessageException:<init>	(IILjava/lang/String;)V
    //   59: invokevirtual 138	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   62: return
    //   63: iconst_4
    //   64: ldc 20
    //   66: new 103	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   73: ldc 140
    //   75: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokeinterface 115 1 0
    //   84: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 142
    //   89: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 144	com/tencent/moai/mailsdk/task/TaskPool:executorService	Ljava/util/concurrent/ThreadPoolExecutor;
    //   96: invokevirtual 150	java/util/concurrent/ThreadPoolExecutor:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   99: invokeinterface 156 1 0
    //   104: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: aload 4
    //   109: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   118: aload_2
    //   119: invokeinterface 165 1 0
    //   124: ifne +42 -> 166
    //   127: iconst_4
    //   128: ldc 20
    //   130: new 103	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   137: ldc 167
    //   139: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokestatic 173	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   145: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   154: aload_2
    //   155: invokeinterface 179 1 0
    //   160: aload_2
    //   161: invokeinterface 182 1 0
    //   166: aload_2
    //   167: invokeinterface 185 1 0
    //   172: ifne +19 -> 191
    //   175: aload_1
    //   176: invokeinterface 188 1 0
    //   181: ifeq +10 -> 191
    //   184: aload_2
    //   185: iconst_0
    //   186: invokeinterface 192 2 0
    //   191: aload_1
    //   192: aload_2
    //   193: invokeinterface 195 2 0
    //   198: iconst_4
    //   199: ldc 20
    //   201: new 103	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   208: ldc 197
    //   210: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokeinterface 115 1 0
    //   219: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 4
    //   224: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   233: return
    //   234: astore 5
    //   236: bipush 6
    //   238: ldc 20
    //   240: new 103	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   247: ldc 199
    //   249: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokeinterface 115 1 0
    //   258: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 4
    //   263: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   272: aload_2
    //   273: invokeinterface 179 1 0
    //   278: aload_3
    //   279: aload 5
    //   281: invokevirtual 138	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   284: return
    //   285: astore 5
    //   287: bipush 6
    //   289: ldc 20
    //   291: new 103	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   298: ldc 201
    //   300: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokeinterface 115 1 0
    //   309: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 4
    //   314: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   323: aload_2
    //   324: invokeinterface 179 1 0
    //   329: aload_3
    //   330: aload 5
    //   332: invokevirtual 138	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   335: return
    //   336: astore 5
    //   338: bipush 6
    //   340: ldc 20
    //   342: new 103	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   349: ldc 203
    //   351: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_1
    //   355: invokeinterface 115 1 0
    //   360: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 4
    //   365: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   374: aload_2
    //   375: invokeinterface 179 1 0
    //   380: aload 5
    //   382: instanceof 126
    //   385: ifeq +59 -> 444
    //   388: aload 5
    //   390: checkcast 126	com/tencent/moai/mailsdk/exception/MessageException
    //   393: astore_1
    //   394: bipush 6
    //   396: ldc 20
    //   398: new 103	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   405: ldc 203
    //   407: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_1
    //   411: invokevirtual 206	com/tencent/moai/mailsdk/exception/MessageException:getResultCode	()I
    //   414: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: ldc 208
    //   419: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_1
    //   423: invokevirtual 211	com/tencent/moai/mailsdk/exception/MessageException:getDetailMessage	()Ljava/lang/String;
    //   426: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 124	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   435: aload_0
    //   436: aload_3
    //   437: aload_1
    //   438: invokespecial 215	com/tencent/moai/mailsdk/task/TaskPool:throwAuthError	(Lrx/Subscriber;Lcom/tencent/moai/mailsdk/exception/MessageException;)Z
    //   441: ifne -379 -> 62
    //   444: aload_3
    //   445: new 126	com/tencent/moai/mailsdk/exception/MessageException
    //   448: dup
    //   449: iconst_5
    //   450: aload 5
    //   452: invokevirtual 218	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokespecial 221	com/tencent/moai/mailsdk/exception/MessageException:<init>	(ILjava/lang/String;)V
    //   458: invokevirtual 138	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   461: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	TaskPool
    //   0	462	1	paramTask	Task
    //   0	462	2	paramHandler	Handler
    //   0	462	3	paramSubscriber	Subscriber
    //   4	360	4	str	String
    //   234	46	5	localException1	Exception
    //   285	46	5	localException2	Exception
    //   336	115	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   191	233	234	java/lang/Exception
    //   154	166	285	java/lang/Exception
    //   184	191	336	java/lang/Exception
  }
  
  private String getThreadMsg()
  {
    return "";
  }
  
  private void initExecutor()
  {
    this.executorService = new ThreadPoolExecutor(this.maxSize, this.maxSize, 3L, TimeUnit.MINUTES, new PriorityBlockingQueue(), new TaskThreadFactory());
    this.executorService.allowCoreThreadTimeOut(true);
  }
  
  private boolean throwAuthError(Subscriber paramSubscriber, MessageException paramMessageException)
  {
    int i = LoginUtility.getProtocolLoginError(paramMessageException.getDetailMessage());
    if (i == 4)
    {
      paramSubscriber.onError(new MessageException(10, paramMessageException.getDetailCode(), paramMessageException.getDetailMessage()));
      return true;
    }
    if ((paramMessageException.getResultCode() == 8) || (i == 1) || (i == 5) || (i == 0))
    {
      paramSubscriber.onError(paramMessageException);
      return true;
    }
    return false;
  }
  
  public List<Runnable> clearAndWait()
  {
    if ((this.executorService != null) && (!this.executorService.isShutdown()))
    {
      Logger.log(4, "TaskPool", "shut down now:" + getTag());
      List localList = this.executorService.shutdownNow();
      try
      {
        this.executorService.awaitTermination(3L, TimeUnit.SECONDS);
        return localList;
      }
      catch (InterruptedException localInterruptedException)
      {
        Logger.log(6, "TaskPool", "wait termination error:" + localInterruptedException.toString());
        return localList;
      }
    }
    return new ArrayList();
  }
  
  public int getMaxSize()
  {
    return this.maxSize;
  }
  
  public String getTag()
  {
    if (StringUtility.isNullOrEmpty(this.tag)) {}
    switch (this.protocolType)
    {
    default: 
      return this.tag;
    case 2: 
      return this.profile.getImapName();
    case 3: 
      return this.profile.getPopName();
    }
    return this.profile.getSmtpName();
  }
  
  public void post(Task paramTask, TaskCallBack paramTaskCallBack)
  {
    try
    {
      if ((this.executorService == null) || (this.executorService.isShutdown()))
      {
        Logger.log(6, "TaskPool", "executor null or shutdown:" + getTag());
        initExecutor();
      }
      this.executorService.execute(new TaskRunnable(paramTask, paramTaskCallBack));
      return;
    }
    catch (Exception localException)
    {
      do
      {
        Logger.log(6, "TaskPool", "executor task error:" + paramTask.getTag() + "\r\n" + Log.getStackTraceString(localException));
      } while (paramTaskCallBack == null);
      paramTaskCallBack.onError(localException);
    }
  }
  
  public void postRunnableList(List<Runnable> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Runnable localRunnable = (Runnable)paramList.next();
        try
        {
          if ((this.executorService == null) || (this.executorService.isShutdown()))
          {
            Logger.log(6, "TaskPool", "executor null or shutdown:" + getTag());
            initExecutor();
          }
          this.executorService.execute(localRunnable);
        }
        catch (Exception localException)
        {
          Logger.log(6, "TaskPool", "executor runnable error:" + Log.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void shutDown()
  {
    if ((this.executorService != null) && (!this.executorService.isShutdown()))
    {
      Logger.log(4, "TaskPool", "shutDown executor:" + getTag());
      this.executorService.shutdown();
    }
  }
  
  @NonNull
  public List<Runnable> shutDownNow()
  {
    if ((this.executorService != null) && (!this.executorService.isShutdown()))
    {
      Logger.log(4, "TaskPool", "shutDownNow executor:" + getTag());
      return this.executorService.shutdownNow();
    }
    return new ArrayList();
  }
  
  public class TaskRunnable
    implements Comparable<TaskRunnable>, Runnable
  {
    TaskCallBack callback;
    Task task;
    
    TaskRunnable(Task paramTask, TaskCallBack paramTaskCallBack)
    {
      this.task = paramTask;
      this.callback = paramTaskCallBack;
    }
    
    public int compareTo(TaskRunnable paramTaskRunnable)
    {
      return paramTaskRunnable.task.getPriority() - this.task.getPriority();
    }
    
    public TaskCallBack getCallback()
    {
      return this.callback;
    }
    
    public Task getTask()
    {
      return this.task;
    }
    
    public void run()
    {
      Handler localHandler = (Handler)TaskPool.this.handlerLocal.get();
      localHandler.setTag(Thread.currentThread().toString());
      TaskPool.this.create(this.task, localHandler).subscribe(new TaskPool.TaskRunnable.1(this), new TaskPool.TaskRunnable.2(this), new TaskPool.TaskRunnable.3(this, localHandler));
    }
  }
  
  class TaskThreadFactory
    implements ThreadFactory
  {
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger poolNumber = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    TaskThreadFactory()
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.group = ((ThreadGroup)localObject);
        this.namePrefix = (TaskPool.this.getTag() + "-p" + TaskPool.this.type + "-" + this.poolNumber.getAndIncrement() + "-t-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement());
      paramRunnable.setPriority(4);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.task.TaskPool
 * JD-Core Version:    0.7.0.1
 */