package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ComputableLiveData<T>
{
  final AtomicBoolean mComputing = new AtomicBoolean(false);
  final Executor mExecutor;
  final AtomicBoolean mInvalid = new AtomicBoolean(true);
  @VisibleForTesting
  final Runnable mInvalidationRunnable = new ComputableLiveData.3(this);
  final LiveData<T> mLiveData;
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
 * Qualified Name:     androidx.lifecycle.ComputableLiveData
 * JD-Core Version:    0.7.0.1
 */