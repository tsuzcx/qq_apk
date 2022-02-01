package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  private static final Object NOT_SET = new Object();
  static final int START_VERSION = -1;
  private int mActiveCount = 0;
  private volatile Object mData;
  private final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private SafeIterableMap<Observer<T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap();
  private volatile Object mPendingData;
  private final Runnable mPostValueRunnable;
  private int mVersion;
  
  public LiveData()
  {
    Object localObject = NOT_SET;
    this.mData = localObject;
    this.mPendingData = localObject;
    this.mVersion = -1;
    this.mPostValueRunnable = new Runnable()
    {
      public void run()
      {
        synchronized (LiveData.this.mDataLock)
        {
          Object localObject2 = LiveData.this.mPendingData;
          LiveData.access$102(LiveData.this, LiveData.NOT_SET);
          LiveData.this.setValue(localObject2);
          return;
        }
      }
    };
  }
  
  private static void assertMainThread(String paramString)
  {
    if (ArchTaskExecutor.getInstance().isMainThread()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot invoke ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" on a background");
    localStringBuilder.append(" thread");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void considerNotify(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (!paramLiveData.mActive) {
      return;
    }
    if (!paramLiveData.shouldBeActive())
    {
      paramLiveData.activeStateChanged(false);
      return;
    }
    int i = paramLiveData.mLastVersion;
    int j = this.mVersion;
    if (i >= j) {
      return;
    }
    paramLiveData.mLastVersion = j;
    paramLiveData.mObserver.onChanged(this.mData);
  }
  
  private void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (this.mDispatchingValue)
    {
      this.mDispatchInvalidated = true;
      return;
    }
    this.mDispatchingValue = true;
    do
    {
      this.mDispatchInvalidated = false;
      LiveData<T>.ObserverWrapper localLiveData;
      if (paramLiveData != null)
      {
        considerNotify(paramLiveData);
        localLiveData = null;
      }
      else
      {
        SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = this.mObservers.iteratorWithAdditions();
        do
        {
          localLiveData = paramLiveData;
          if (!localIteratorWithAdditions.hasNext()) {
            break;
          }
          considerNotify((ObserverWrapper)((Map.Entry)localIteratorWithAdditions.next()).getValue());
        } while (!this.mDispatchInvalidated);
        localLiveData = paramLiveData;
      }
      paramLiveData = localLiveData;
    } while (this.mDispatchInvalidated);
    this.mDispatchingValue = false;
  }
  
  @Nullable
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != NOT_SET) {
      return localObject;
    }
    return null;
  }
  
  int getVersion()
  {
    return this.mVersion;
  }
  
  public boolean hasActiveObservers()
  {
    return this.mActiveCount > 0;
  }
  
  public boolean hasObservers()
  {
    return this.mObservers.size() > 0;
  }
  
  @MainThread
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<T> paramObserver)
  {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
      return;
    }
    LifecycleBoundObserver localLifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
    paramObserver = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localLifecycleBoundObserver);
    if ((paramObserver != null) && (!paramObserver.isAttachedTo(paramLifecycleOwner))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  @MainThread
  public void observeForever(@NonNull Observer<T> paramObserver)
  {
    AlwaysActiveObserver localAlwaysActiveObserver = new AlwaysActiveObserver(paramObserver);
    paramObserver = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if ((paramObserver != null) && ((paramObserver instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    localAlwaysActiveObserver.activeStateChanged(true);
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(T paramT)
  {
    for (;;)
    {
      synchronized (this.mDataLock)
      {
        if (this.mPendingData == NOT_SET)
        {
          i = 1;
          this.mPendingData = paramT;
          if (i == 0) {
            return;
          }
          ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
          return;
        }
      }
      int i = 0;
    }
  }
  
  @MainThread
  public void removeObserver(@NonNull Observer<T> paramObserver)
  {
    assertMainThread("removeObserver");
    paramObserver = (ObserverWrapper)this.mObservers.remove(paramObserver);
    if (paramObserver == null) {
      return;
    }
    paramObserver.detachObserver();
    paramObserver.activeStateChanged(false);
  }
  
  @MainThread
  public void removeObservers(@NonNull LifecycleOwner paramLifecycleOwner)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ObserverWrapper)localEntry.getValue()).isAttachedTo(paramLifecycleOwner)) {
        removeObserver((Observer)localEntry.getKey());
      }
    }
  }
  
  @MainThread
  protected void setValue(T paramT)
  {
    assertMainThread("setValue");
    this.mVersion += 1;
    this.mData = paramT;
    dispatchingValue(null);
  }
  
  private class AlwaysActiveObserver
    extends LiveData<T>.ObserverWrapper
  {
    AlwaysActiveObserver()
    {
      super(localObserver);
    }
    
    boolean shouldBeActive()
    {
      return true;
    }
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.ObserverWrapper
    implements GenericLifecycleObserver
  {
    @NonNull
    final LifecycleOwner mOwner;
    
    LifecycleBoundObserver(@NonNull Observer<T> paramObserver)
    {
      super(localObserver);
      this.mOwner = paramObserver;
    }
    
    void detachObserver()
    {
      this.mOwner.getLifecycle().removeObserver(this);
    }
    
    boolean isAttachedTo(LifecycleOwner paramLifecycleOwner)
    {
      return this.mOwner == paramLifecycleOwner;
    }
    
    public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      {
        LiveData.this.removeObserver(this.mObserver);
        return;
      }
      activeStateChanged(shouldBeActive());
    }
    
    boolean shouldBeActive()
    {
      return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }
  }
  
  private abstract class ObserverWrapper
  {
    boolean mActive;
    int mLastVersion = -1;
    final Observer<T> mObserver;
    
    ObserverWrapper()
    {
      Object localObject;
      this.mObserver = localObject;
    }
    
    void activeStateChanged(boolean paramBoolean)
    {
      if (paramBoolean == this.mActive) {
        return;
      }
      this.mActive = paramBoolean;
      int i = LiveData.this.mActiveCount;
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      LiveData localLiveData = LiveData.this;
      int k = localLiveData.mActiveCount;
      if (!this.mActive) {
        j = -1;
      }
      LiveData.access$302(localLiveData, k + j);
      if ((i != 0) && (this.mActive)) {
        LiveData.this.onActive();
      }
      if ((LiveData.this.mActiveCount == 0) && (!this.mActive)) {
        LiveData.this.onInactive();
      }
      if (this.mActive) {
        LiveData.this.dispatchingValue(this);
      }
    }
    
    void detachObserver() {}
    
    boolean isAttachedTo(LifecycleOwner paramLifecycleOwner)
    {
      return false;
    }
    
    abstract boolean shouldBeActive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */