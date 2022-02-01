package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  static final Object NOT_SET = new Object();
  static final int START_VERSION = -1;
  int mActiveCount = 0;
  private volatile Object mData = NOT_SET;
  final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap();
  volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new LiveData.1(this);
  private int mVersion = -1;
  
  private static void assertMainThread(String paramString)
  {
    if (!ArchTaskExecutor.getInstance().isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background" + " thread");
    }
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
  
  void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper paramLiveData)
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
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<? super T> paramObserver)
  {
    assertMainThread("observe");
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
      paramObserver = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localLifecycleBoundObserver);
      if ((paramObserver != null) && (!paramObserver.isAttachedTo(paramLifecycleOwner))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  @MainThread
  public void observeForever(@NonNull Observer<? super T> paramObserver)
  {
    assertMainThread("observeForever");
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
        if (this.mPendingData != NOT_SET) {
          break label47;
        }
        i = 1;
        this.mPendingData = paramT;
        if (i == 0) {
          return;
        }
      }
      ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
      return;
      label47:
      int i = 0;
    }
  }
  
  @MainThread
  public void removeObserver(@NonNull Observer<? super T> paramObserver)
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
    
    LifecycleBoundObserver(@NonNull Observer<? super T> paramObserver)
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
    final Observer<? super T> mObserver;
    
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
          break label120;
        }
      }
      for (;;)
      {
        localLiveData.mActiveCount = (j + k);
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
        label120:
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
 * Qualified Name:     androidx.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */