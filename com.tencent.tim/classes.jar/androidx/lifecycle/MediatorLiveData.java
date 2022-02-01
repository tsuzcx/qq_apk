package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T>
  extends MutableLiveData<T>
{
  private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap();
  
  @MainThread
  public <S> void addSource(@NonNull LiveData<S> paramLiveData, @NonNull Observer<? super S> paramObserver)
  {
    Source localSource = new Source(paramLiveData, paramObserver);
    paramLiveData = (Source)this.mSources.putIfAbsent(paramLiveData, localSource);
    if ((paramLiveData != null) && (paramLiveData.mObserver != paramObserver)) {
      throw new IllegalArgumentException("This source was already added with the different observer");
    }
    if (paramLiveData != null) {}
    while (!hasActiveObservers()) {
      return;
    }
    localSource.plug();
  }
  
  @CallSuper
  protected void onActive()
  {
    Iterator localIterator = this.mSources.iterator();
    while (localIterator.hasNext()) {
      ((Source)((Map.Entry)localIterator.next()).getValue()).plug();
    }
  }
  
  @CallSuper
  protected void onInactive()
  {
    Iterator localIterator = this.mSources.iterator();
    while (localIterator.hasNext()) {
      ((Source)((Map.Entry)localIterator.next()).getValue()).unplug();
    }
  }
  
  @MainThread
  public <S> void removeSource(@NonNull LiveData<S> paramLiveData)
  {
    paramLiveData = (Source)this.mSources.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.unplug();
    }
  }
  
  static class Source<V>
    implements Observer<V>
  {
    final LiveData<V> mLiveData;
    final Observer<? super V> mObserver;
    int mVersion = -1;
    
    Source(LiveData<V> paramLiveData, Observer<? super V> paramObserver)
    {
      this.mLiveData = paramLiveData;
      this.mObserver = paramObserver;
    }
    
    public void onChanged(@Nullable V paramV)
    {
      if (this.mVersion != this.mLiveData.getVersion())
      {
        this.mVersion = this.mLiveData.getVersion();
        this.mObserver.onChanged(paramV);
      }
    }
    
    void plug()
    {
      this.mLiveData.observeForever(this);
    }
    
    void unplug()
    {
      this.mLiveData.removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.MediatorLiveData
 * JD-Core Version:    0.7.0.1
 */