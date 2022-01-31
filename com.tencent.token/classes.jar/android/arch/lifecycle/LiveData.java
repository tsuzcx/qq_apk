package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData
{
  private static final Object NOT_SET = new Object();
  static final int START_VERSION = -1;
  private int mActiveCount = 0;
  private volatile Object mData = NOT_SET;
  private final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private SafeIterableMap mObservers = new SafeIterableMap();
  private volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new LiveData.1(this);
  private int mVersion = -1;
  
  private static void assertMainThread(String paramString)
  {
    if (!ArchTaskExecutor.getInstance().isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background" + " thread");
    }
  }
  
  private void considerNotify(LiveData.ObserverWrapper paramObserverWrapper)
  {
    if (!paramObserverWrapper.mActive) {}
    do
    {
      return;
      if (!paramObserverWrapper.shouldBeActive())
      {
        paramObserverWrapper.activeStateChanged(false);
        return;
      }
    } while (paramObserverWrapper.mLastVersion >= this.mVersion);
    paramObserverWrapper.mLastVersion = this.mVersion;
    paramObserverWrapper.mObserver.onChanged(this.mData);
  }
  
  private void dispatchingValue(@Nullable LiveData.ObserverWrapper paramObserverWrapper)
  {
    if (this.mDispatchingValue)
    {
      this.mDispatchInvalidated = true;
      return;
    }
    this.mDispatchingValue = true;
    this.mDispatchInvalidated = false;
    LiveData.ObserverWrapper localObserverWrapper;
    if (paramObserverWrapper != null)
    {
      considerNotify(paramObserverWrapper);
      localObserverWrapper = null;
    }
    for (;;)
    {
      paramObserverWrapper = localObserverWrapper;
      if (this.mDispatchInvalidated) {
        break;
      }
      this.mDispatchingValue = false;
      return;
      SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = this.mObservers.iteratorWithAdditions();
      do
      {
        localObserverWrapper = paramObserverWrapper;
        if (!localIteratorWithAdditions.hasNext()) {
          break;
        }
        considerNotify((LiveData.ObserverWrapper)((Map.Entry)localIteratorWithAdditions.next()).getValue());
      } while (!this.mDispatchInvalidated);
      localObserverWrapper = paramObserverWrapper;
    }
  }
  
  @Nullable
  public Object getValue()
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
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer paramObserver)
  {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    LiveData.LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LiveData.LifecycleBoundObserver(this, paramLifecycleOwner, paramObserver);
      paramObserver = (LiveData.ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localLifecycleBoundObserver);
      if ((paramObserver != null) && (!paramObserver.isAttachedTo(paramLifecycleOwner))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  @MainThread
  public void observeForever(@NonNull Observer paramObserver)
  {
    LiveData.AlwaysActiveObserver localAlwaysActiveObserver = new LiveData.AlwaysActiveObserver(this, paramObserver);
    paramObserver = (LiveData.ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if ((paramObserver != null) && ((paramObserver instanceof LiveData.LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    localAlwaysActiveObserver.activeStateChanged(true);
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(Object paramObject)
  {
    for (;;)
    {
      synchronized (this.mDataLock)
      {
        if (this.mPendingData != NOT_SET) {
          break label47;
        }
        i = 1;
        this.mPendingData = paramObject;
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
  public void removeObserver(@NonNull Observer paramObserver)
  {
    assertMainThread("removeObserver");
    paramObserver = (LiveData.ObserverWrapper)this.mObservers.remove(paramObserver);
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
      if (((LiveData.ObserverWrapper)localEntry.getValue()).isAttachedTo(paramLifecycleOwner)) {
        removeObserver((Observer)localEntry.getKey());
      }
    }
  }
  
  @MainThread
  protected void setValue(Object paramObject)
  {
    assertMainThread("setValue");
    this.mVersion += 1;
    this.mData = paramObject;
    dispatchingValue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */