package android.arch.core.executor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ArchTaskExecutor
  extends TaskExecutor
{
  @NonNull
  private static final Executor sIOThreadExecutor = new ArchTaskExecutor.2();
  private static volatile ArchTaskExecutor sInstance;
  @NonNull
  private static final Executor sMainThreadExecutor = new ArchTaskExecutor.1();
  @NonNull
  private TaskExecutor mDefaultTaskExecutor = new DefaultTaskExecutor();
  @NonNull
  private TaskExecutor mDelegate = this.mDefaultTaskExecutor;
  
  @NonNull
  public static Executor getIOThreadExecutor()
  {
    return sIOThreadExecutor;
  }
  
  @NonNull
  public static ArchTaskExecutor getInstance()
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null) {
        sInstance = new ArchTaskExecutor();
      }
      return sInstance;
    }
    finally {}
  }
  
  @NonNull
  public static Executor getMainThreadExecutor()
  {
    return sMainThreadExecutor;
  }
  
  public void executeOnDiskIO(Runnable paramRunnable)
  {
    this.mDelegate.executeOnDiskIO(paramRunnable);
  }
  
  public boolean isMainThread()
  {
    return this.mDelegate.isMainThread();
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    this.mDelegate.postToMainThread(paramRunnable);
  }
  
  public void setDelegate(@Nullable TaskExecutor paramTaskExecutor)
  {
    TaskExecutor localTaskExecutor = paramTaskExecutor;
    if (paramTaskExecutor == null) {
      localTaskExecutor = this.mDefaultTaskExecutor;
    }
    this.mDelegate = localTaskExecutor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.core.executor.ArchTaskExecutor
 * JD-Core Version:    0.7.0.1
 */