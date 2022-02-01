package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ComputableLiveData<T>
{
  private AtomicBoolean mComputing = new AtomicBoolean(false);
  private final Executor mExecutor;
  private AtomicBoolean mInvalid = new AtomicBoolean(true);
  @VisibleForTesting
  final Runnable mInvalidationRunnable = new ComputableLiveData.3(this);
  private final LiveData<T> mLiveData;
  @VisibleForTesting
  final Runnable mRefreshRunnable = new ComputableLiveData.2(this);
  
  public ComputableLiveData()
  {
    this(ArchTaskExecutor.getIOThreadExecutor());
  }
  
  public ComputableLiveData(@NonNull Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
    this.mLiveData = new ComputableLiveData.1(this);
  }
  
  @WorkerThread
  protected abstract T compute();
  
  @NonNull
  public LiveData<T> getLiveData()
  {
    return this.mLiveData;
  }
  
  public void invalidate()
  {
    ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.lifecycle.ComputableLiveData
 * JD-Core Version:    0.7.0.1
 */