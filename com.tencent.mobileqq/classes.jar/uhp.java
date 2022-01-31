import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public class uhp
  implements Boss, MonitorThreadPoolExecutor.ThreadPoolMonitorListener
{
  private static final int jdField_a_of_type_Int = Runtime.getRuntime().availableProcessors();
  private static final int jdField_b_of_type_Int = Runtime.getRuntime().availableProcessors();
  private static final int jdField_c_of_type_Int = Runtime.getRuntime().availableProcessors();
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final JobController jdField_a_of_type_ComTribeAsyncAsyncJobController;
  private final LightWeightExecutor jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor;
  private final Executor jdField_a_of_type_JavaUtilConcurrentExecutor = new uhr("StoryBoss.NetworkExecutor", 128, jdField_c_of_type_Int, null);
  private final Executor[] jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor = new Executor[3];
  private long jdField_b_of_type_Long;
  private final Executor jdField_b_of_type_JavaUtilConcurrentExecutor = new uhr("StoryBoss.CpuExecutor", 16, jdField_a_of_type_Int, null);
  private final Executor jdField_c_of_type_JavaUtilConcurrentExecutor = new uhr("StoryBoss.FileExecutor", 64, jdField_b_of_type_Int, null);
  
  public uhp(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor[0] = this.jdField_a_of_type_JavaUtilConcurrentExecutor;
    this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor[1] = this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor[2] = this.jdField_c_of_type_JavaUtilConcurrentExecutor;
    this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor = new LightWeightExecutor(uht.a().getDefaultLooper(), 100);
    this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor.setMonitorListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(uht.a().getDefaultLooper());
    this.jdField_a_of_type_ComTribeAsyncAsyncJobController = new JobController(this);
    uht.a().registerSubscriber("root_group", this.jdField_a_of_type_ComTribeAsyncAsyncJobController);
  }
  
  @NonNull
  private <Params, Progress, Result> Future<Result> a(Job<Params, Progress, Result> paramJob, int paramInt1, int paramInt2, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramInt2, paramFutureListener, paramParams);
    paramJob.addFutureListener(new uhq(this, paramJob));
    if (paramInt1 == 0)
    {
      uht.a().dispatch(paramJob);
      return paramJob;
    }
    uht.a().dispatchDelayed(paramJob, paramInt1);
    return paramJob;
  }
  
  public <Params, Progress, Result> Future<Result> a(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    paramJob = prepareWorker(paramJob, paramJob.getJobType(), paramFutureListener, paramParams);
    this.jdField_a_of_type_ComTribeAsyncAsyncJobController.getDefaultHandler().handleExecute(this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor, paramJob);
    if (paramJob != null) {
      wsv.b("StoryBoss", "work hash code:" + paramJob.hashCode());
    }
    return paramJob;
  }
  
  public <Result> void cancelJob(Future<Result> paramFuture, boolean paramBoolean)
  {
    if ((paramFuture instanceof Worker)) {
      uht.a().cancelDispatch("", (Worker)paramFuture);
    }
    uht.a().dispatch(new JobController.CancelCommand(paramFuture, paramBoolean));
  }
  
  @NonNull
  public Executor getExecutor(int paramInt)
  {
    Executor localExecutor = this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    switch (paramInt)
    {
    default: 
      return localExecutor;
    case 2: 
      return this.jdField_b_of_type_JavaUtilConcurrentExecutor;
    case 4: 
      return this.jdField_c_of_type_JavaUtilConcurrentExecutor;
    case 8: 
      return this.jdField_c_of_type_JavaUtilConcurrentExecutor;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentExecutor;
  }
  
  @NonNull
  public Executor[] getExecutors()
  {
    return this.jdField_a_of_type_ArrayOfJavaUtilConcurrentExecutor;
  }
  
  @NonNull
  public JobController getJobController()
  {
    return this.jdField_a_of_type_ComTribeAsyncAsyncJobController;
  }
  
  @NonNull
  public Executor getLightWeightExecutor()
  {
    return this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor;
  }
  
  public void onQueueExceedLimit(String paramString, int paramInt)
  {
    wsv.e("StoryBoss", paramString + " onQueueExceedLimit, size = " + paramInt);
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long > 7200000L) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
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
        break label116;
      }
      paramList = ((Worker)localRunnable).getJob().getClass().getSimpleName();
    }
    label116:
    for (;;)
    {
      wsv.e("StoryBoss", paramString + " onWorkerExceedTime, runnable = " + paramList);
      if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long <= 7200000L) {
        break;
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      break;
      return;
    }
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob)
  {
    return a(paramJob, null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return a(paramJob, paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> postJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return a(paramJob, null, paramParams);
  }
  
  public void postLightWeightJob(Runnable paramRunnable, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTribeAsyncAsyncLightWeightExecutor.execute(paramRunnable);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramInt);
  }
  
  @NonNull
  public <Params, Progress, Result> Worker<Progress, Result> prepareWorker(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    xmh.a(paramJob);
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
    return a(paramJob, 0, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return a(paramJob, 0, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJob(Job<Params, Progress, Result> paramJob, @Nullable Params paramParams)
  {
    return a(paramJob, 0, paramJob.getJobType(), null, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), null, null);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable FutureListener<Progress, Result> paramFutureListener, @Nullable Params paramParams)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), paramFutureListener, paramParams);
  }
  
  @NonNull
  public <Params, Progress, Result> Future<Result> scheduleJobDelayed(Job<Params, Progress, Result> paramJob, int paramInt, @Nullable Params paramParams)
  {
    return a(paramJob, paramInt, paramJob.getJobType(), null, paramParams);
  }
  
  public void shutdown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */