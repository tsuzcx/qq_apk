import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.FutureListener;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobControlHandler;
import com.tribe.async.async.JobController;
import com.tribe.async.async.JobController.CancelCommand;
import com.tribe.async.async.LightWeightExecutor;
import com.tribe.async.async.MonitorThreadPoolExecutor.ThreadPoolMonitorListener;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class pmf
  implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener
{
  private static final int bjo = Runtime.getRuntime().availableProcessors();
  private static final int bjp = Runtime.getRuntime().availableProcessors();
  private static final int bjq = Runtime.getRuntime().availableProcessors();
  private final Executor[] a = new Executor[3];
  private final Executor i = new pmf.a("StoryBoss.NetworkExecutor", 128, bjq, null);
  private final Executor j = new pmf.a("StoryBoss.CpuExecutor", 16, bjo, null);
  private final Executor k = new pmf.a("StoryBoss.FileExecutor", 64, bjp, null);
  private Handler mHandler;
  private final JobController mJobController;
  private final LightWeightExecutor mLightWeightExecutor;
  private long mReportExceedSize;
  private long mReportExceedTime;
  
  public pmf(Context paramContext)
  {
    this.a[0] = this.i;
    this.a[1] = this.j;
    this.a[2] = this.k;
    this.mLightWeightExecutor = new LightWeightExecutor(pmi.a().getDefaultLooper(), 100);
    this.mLightWeightExecutor.setMonitorListener(this);
    this.mHandler = new Handler(pmi.a().getDefaultLooper());
    this.mJobController = new JobController(this);
    pmi.a().registerSubscriber("root_group", this.mJobController);
  }
  
  @NonNull
  private <Params, Progress, Result> Future<Result> scheduleJobDelayedInternal(Job<Params, Progress, Result> paramJob, int paramInt1, int paramInt2, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramInt2, paramFutureListener, paramParams);
    paramJob.addFutureListener(new pmg(this, paramJob));
    if (paramInt1 == 0)
    {
      pmi.a().dispatch(paramJob);
      return paramJob;
    }
    pmi.a().dispatchDelayed(paramJob, paramInt1);
    return paramJob;
  }
  
  public <Result> void cancelJob(Future<Result> paramFuture, boolean paramBoolean)
  {
    if ((paramFuture instanceof Worker)) {
      pmi.a().cancelDispatch("", (Worker)paramFuture);
    }
    pmi.a().dispatch(new JobController.CancelCommand(paramFuture, paramBoolean));
  }
  
  public <Params, Progress, Result> Future<Result> executeJobInternal(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramJob.getJobType(), paramFutureListener, paramParams);
    this.mJobController.getDefaultHandler().handleExecute(this.a, paramJob);
    if (paramJob != null) {
      ram.d("StoryBoss", "work hash code:" + paramJob.hashCode());
    }
    return paramJob;
  }
  
  @NonNull
  public Executor getExecutor(int paramInt)
  {
    Executor localExecutor = this.j;
    switch (paramInt)
    {
    default: 
      return localExecutor;
    case 2: 
      return this.j;
    case 4: 
      return this.k;
    case 8: 
      return this.k;
    }
    return this.i;
  }
  
  @NonNull
  public Executor[] getExecutors()
  {
    return this.a;
  }
  
  @NonNull
  public JobController getJobController()
  {
    return this.mJobController;
  }
  
  @NonNull
  public Executor getLightWeightExecutor()
  {
    return this.mLightWeightExecutor;
  }
  
  public void onQueueExceedLimit(String paramString, int paramInt)
  {
    ram.e("StoryBoss", paramString + " onQueueExceedLimit, size = " + paramInt);
    if (SystemClock.uptimeMillis() - this.mReportExceedSize > 7200000L) {
      this.mReportExceedSize = SystemClock.uptimeMillis();
    }
  }
  
  public void onWorkerExceedTime(String paramString, List<Runnable> paramList, int paramInt)
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      paramList = localRunnable.getClass().getSimpleName();
      if (!(localRunnable instanceof Worker)) {
        break label117;
      }
      paramList = ((Worker)localRunnable).getJob().getClass().getSimpleName();
    }
    label117:
    for (;;)
    {
      ram.e("StoryBoss", paramString + " onWorkerExceedTime, runnable = " + paramList);
      if (SystemClock.uptimeMillis() - this.mReportExceedTime <= 7200000L) {
        break;
      }
      this.mReportExceedTime = SystemClock.uptimeMillis();
      break;
      return;
    }
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob)
  {
    return executeJobInternal(paramJob, null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return executeJobInternal(paramJob, paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return executeJobInternal(paramJob, null, paramParams);
  }
  
  public void postLightWeightJob(Runnable paramRunnable, int paramInt)
  {
    if (paramInt == 0)
    {
      this.mLightWeightExecutor.execute(paramRunnable);
      return;
    }
    this.mHandler.postDelayed(paramRunnable, paramInt);
  }
  
  @NonNull
  public <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    rom.checkNotNull(paramJob);
    paramJob.setJobType(paramInt);
    paramJob.setParams(paramParams);
    paramParams = new Worker(paramJob);
    if (paramFutureListener != null) {
      paramParams.addFutureListener(paramFutureListener);
    }
    paramJob.onPost();
    return paramParams;
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob)
  {
    return scheduleJobDelayedInternal(paramJob, 0, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, 0, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, 0, paramJob.getJobType(), null, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt)
  {
    return scheduleJobDelayedInternal(paramJob, paramInt, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, paramInt, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable Params paramParams)
  {
    return scheduleJobDelayedInternal(paramJob, paramInt, paramJob.getJobType(), null, paramParams);
  }
  
  public void shutdown() {}
  
  static class a
    implements Executor
  {
    private final String TAG;
    private final AtomicInteger ag;
    private int bjr;
    private int mThreadType;
    private final Queue<Runnable> o;
    
    private a(@NonNull String paramString, int paramInt1, @IntRange(from=0L) int paramInt2)
    {
      this.TAG = paramString;
      this.mThreadType = paramInt1;
      this.bjr = paramInt2;
      this.o = new ConcurrentLinkedQueue();
      this.ag = new AtomicInteger(0);
    }
    
    public void execute(@NonNull Runnable paramRunnable)
    {
      this.o.offer(paramRunnable);
      int i = this.o.size();
      if (i > Runtime.getRuntime().availableProcessors()) {
        ram.d(this.TAG, "too many runnable remained in the queue, size " + i);
      }
      if (this.ag.get() <= this.bjr)
      {
        ram.d(this.TAG, "current number of task threshold is " + this.ag.get());
        while (!this.o.isEmpty())
        {
          paramRunnable = (Runnable)this.o.poll();
          if (paramRunnable != null) {
            ThreadManager.excute(paramRunnable, this.mThreadType, new pmh(this, paramRunnable), false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmf
 * JD-Core Version:    0.7.0.1
 */