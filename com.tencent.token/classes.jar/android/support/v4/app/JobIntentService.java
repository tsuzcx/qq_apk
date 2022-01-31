package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService
  extends Service
{
  static final boolean DEBUG = false;
  static final String TAG = "JobIntentService";
  static final HashMap sClassWorkEnqueuer = new HashMap();
  static final Object sLock = new Object();
  final ArrayList mCompatQueue;
  JobIntentService.WorkEnqueuer mCompatWorkEnqueuer;
  JobIntentService.CommandProcessor mCurProcessor;
  boolean mDestroyed = false;
  boolean mInterruptIfStopped = false;
  JobIntentService.CompatJobEngine mJobImpl;
  boolean mStopped = false;
  
  public JobIntentService()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mCompatQueue = null;
      return;
    }
    this.mCompatQueue = new ArrayList();
  }
  
  public static void enqueueWork(@NonNull Context paramContext, @NonNull ComponentName paramComponentName, int paramInt, @NonNull Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("work must not be null");
    }
    synchronized (sLock)
    {
      paramContext = getWorkEnqueuer(paramContext, paramComponentName, true, paramInt);
      paramContext.ensureJobId(paramInt);
      paramContext.enqueueWork(paramIntent);
      return;
    }
  }
  
  public static void enqueueWork(@NonNull Context paramContext, @NonNull Class paramClass, int paramInt, @NonNull Intent paramIntent)
  {
    enqueueWork(paramContext, new ComponentName(paramContext, paramClass), paramInt, paramIntent);
  }
  
  static JobIntentService.WorkEnqueuer getWorkEnqueuer(Context paramContext, ComponentName paramComponentName, boolean paramBoolean, int paramInt)
  {
    JobIntentService.WorkEnqueuer localWorkEnqueuer = (JobIntentService.WorkEnqueuer)sClassWorkEnqueuer.get(paramComponentName);
    Object localObject = localWorkEnqueuer;
    if (localWorkEnqueuer == null)
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label69;
      }
      if (!paramBoolean) {
        throw new IllegalArgumentException("Can't be here without a job id");
      }
    }
    label69:
    for (paramContext = new JobIntentService.JobWorkEnqueuer(paramContext, paramComponentName, paramInt);; paramContext = new JobIntentService.CompatWorkEnqueuer(paramContext, paramComponentName))
    {
      sClassWorkEnqueuer.put(paramComponentName, paramContext);
      localObject = paramContext;
      return localObject;
    }
  }
  
  JobIntentService.GenericWorkItem dequeueWork()
  {
    if (this.mJobImpl != null) {
      return this.mJobImpl.dequeueWork();
    }
    synchronized (this.mCompatQueue)
    {
      if (this.mCompatQueue.size() > 0)
      {
        JobIntentService.GenericWorkItem localGenericWorkItem = (JobIntentService.GenericWorkItem)this.mCompatQueue.remove(0);
        return localGenericWorkItem;
      }
    }
    return null;
  }
  
  boolean doStopCurrentWork()
  {
    if (this.mCurProcessor != null) {
      this.mCurProcessor.cancel(this.mInterruptIfStopped);
    }
    this.mStopped = true;
    return onStopCurrentWork();
  }
  
  void ensureProcessorRunningLocked(boolean paramBoolean)
  {
    if (this.mCurProcessor == null)
    {
      this.mCurProcessor = new JobIntentService.CommandProcessor(this);
      if ((this.mCompatWorkEnqueuer != null) && (paramBoolean)) {
        this.mCompatWorkEnqueuer.serviceProcessingStarted();
      }
      this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  public boolean isStopped()
  {
    return this.mStopped;
  }
  
  public IBinder onBind(@NonNull Intent paramIntent)
  {
    if (this.mJobImpl != null) {
      return this.mJobImpl.compatGetBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mJobImpl = new JobIntentService.JobServiceEngineImpl(this);
      this.mCompatWorkEnqueuer = null;
      return;
    }
    this.mJobImpl = null;
    this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mCompatQueue != null) {
      synchronized (this.mCompatQueue)
      {
        this.mDestroyed = true;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();
        return;
      }
    }
  }
  
  protected abstract void onHandleWork(@NonNull Intent paramIntent);
  
  public int onStartCommand(@Nullable Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (this.mCompatQueue != null)
    {
      this.mCompatWorkEnqueuer.serviceStartReceived();
      synchronized (this.mCompatQueue)
      {
        ArrayList localArrayList2 = this.mCompatQueue;
        if (paramIntent != null)
        {
          localArrayList2.add(new JobIntentService.CompatWorkItem(this, paramIntent, paramInt2));
          ensureProcessorRunningLocked(true);
          return 3;
        }
        paramIntent = new Intent();
      }
    }
    return 2;
  }
  
  public boolean onStopCurrentWork()
  {
    return true;
  }
  
  void processorFinished()
  {
    if (this.mCompatQueue != null) {
      synchronized (this.mCompatQueue)
      {
        this.mCurProcessor = null;
        if ((this.mCompatQueue != null) && (this.mCompatQueue.size() > 0)) {
          ensureProcessorRunningLocked(false);
        }
        while (this.mDestroyed) {
          return;
        }
        this.mCompatWorkEnqueuer.serviceProcessingFinished();
      }
    }
  }
  
  public void setInterruptIfStopped(boolean paramBoolean)
  {
    this.mInterruptIfStopped = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.JobIntentService
 * JD-Core Version:    0.7.0.1
 */