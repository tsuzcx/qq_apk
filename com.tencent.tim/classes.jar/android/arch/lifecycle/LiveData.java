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
  private volatile Object mData = NOT_SET;
  private final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private SafeIterableMap<Observer<T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap();
  private volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new LiveData.1(this);
  private int mVersion = -1;
  
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
    if (!paramLiveData.mActive) {}
    do
    {
      return;
      if (!paramLiveData.shouldBeActive())
      {
        paramLiveData.activeStateChanged(false);
        return;
      }
    } while (paramLiveData.mLastVersion >= this.mVersion);
    paramLiveData.mLastVersion = this.mVersion;
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
    this.mDispatchInvalidated = false;
    LiveData<T>.ObserverWrapper localLiveData;
    if (paramLiveData != null)
    {
      considerNotify(paramLiveData);
      localLiveData = null;
    }
    for (;;)
    {
      paramLiveData = localLiveData;
      if (this.mDispatchInvalidated) {
        break;
      }
      this.mDispatchingValue = false;
      return;
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
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
      paramObserver = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localLifecycleBoundObserver);
      if ((paramObserver != null) && (!paramObserver.isAttachedTo(paramLifecycleOwner))) {
        break;
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
    return;
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  @MainThread
  public void observeForever(@NonNull Observer<T> paramObserver)
  {
    AlwaysActiveObserver localAlwaysActiveObserver = new AlwaysActiveObserver(paramObserver);
    paramObserver = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if ((paramObserver == null) || (!(paramObserver instanceof LifecycleBoundObserver)))
    {
      if (paramObserver == null) {}
    }
    else {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    localAlwaysActiveObserver.activeStateChanged(true);
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(T paramT)
  {
    synchronized (this.mDataLock)
    {
      if (this.mPendingData == NOT_SET) {}
      for (int i = 1;; i = 0)
      {
        this.mPendingData = paramT;
        if (i != 0) {
          break;
        }
        return;
      }
      ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
      return;
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
  
  class AlwaysActiveObserver
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
    
    LifecycleBoundObserver(Observer<T> paramObserver)
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
  
  abstract class ObserverWrapper
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
      int j = 1;
      if (paramBoolean == this.mActive) {
        return;
      }
      this.mActive = paramBoolean;
      int i;
      label28:
      LiveData localLiveData;
      int k;
      if (LiveData.this.mActiveCount == 0)
      {
        i = 1;
        localLiveData = LiveData.this;
        k = localLiveData.mActiveCount;
        if (!this.mActive) {
          break label121;
        }
      }
      for (;;)
      {
        LiveData.access$302(localLiveData, j + k);
        if ((i != 0) && (this.mActive)) {
          LiveData.this.onActive();
        }
        if ((LiveData.this.mActiveCount == 0) && (!this.mActive)) {
          LiveData.this.onInactive();
        }
        if (!this.mActive) {
          break;
        }
        LiveData.this.dispatchingValue(this);
        return;
        i = 0;
        break label28;
        label121:
        j = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */