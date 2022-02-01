import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.lifecycle.livedata.LiveData.1;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class axzt<T>
{
  private static final Object NOT_SET = new Object();
  private axzs<axzv<? super T>, axzt<T>.c> b = new axzs();
  private int mActiveCount;
  private volatile Object mData = NOT_SET;
  private final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new LiveData.1(this);
  private int mVersion = -1;
  
  private void a(axzt<T>.c paramaxzt)
  {
    if (!paramaxzt.mActive) {}
    do
    {
      return;
      if (!paramaxzt.shouldBeActive())
      {
        paramaxzt.activeStateChanged(false);
        return;
      }
    } while (paramaxzt.mLastVersion >= this.mVersion);
    paramaxzt.mLastVersion = this.mVersion;
    paramaxzt.c.onChanged(this.mData);
  }
  
  private static void assertMainThread(String paramString)
  {
    if (!axzl.a().isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable axzt<T>.c paramaxzt)
  {
    if (this.mDispatchingValue)
    {
      this.mDispatchInvalidated = true;
      return;
    }
    this.mDispatchingValue = true;
    this.mDispatchInvalidated = false;
    axzt<T>.c localaxzt;
    if (paramaxzt != null)
    {
      a(paramaxzt);
      localaxzt = null;
    }
    for (;;)
    {
      paramaxzt = localaxzt;
      if (this.mDispatchInvalidated) {
        break;
      }
      this.mDispatchingValue = false;
      return;
      axzs.d locald = this.b.a();
      do
      {
        localaxzt = paramaxzt;
        if (!locald.hasNext()) {
          break;
        }
        a((axzt.c)((Map.Entry)locald.next()).getValue());
      } while (!this.mDispatchInvalidated);
      localaxzt = paramaxzt;
    }
  }
  
  public void a(@NonNull axzf paramaxzf, @NonNull axzv<? super T> paramaxzv)
  {
    assertMainThread("observe");
    if (paramaxzf.a().a() == axzd.b.a) {}
    axzt.b localb;
    do
    {
      return;
      localb = new axzt.b(paramaxzf, paramaxzv);
      paramaxzv = (axzt.c)this.b.putIfAbsent(paramaxzv, localb);
      if ((paramaxzv != null) && (!paramaxzv.a(paramaxzf))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramaxzv != null);
    paramaxzf.a().a(localb);
  }
  
  public void a(@NonNull axzv<? super T> paramaxzv)
  {
    assertMainThread("observeForever");
    axzt.a locala = new axzt.a(paramaxzv);
    paramaxzv = (axzt.c)this.b.putIfAbsent(paramaxzv, locala);
    if ((paramaxzv != null) && ((paramaxzv instanceof axzt.b))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramaxzv != null) {
      return;
    }
    locala.activeStateChanged(true);
  }
  
  public void b(@NonNull axzv<? super T> paramaxzv)
  {
    assertMainThread("removeObserver");
    paramaxzv = (axzt.c)this.b.remove(paramaxzv);
    if (paramaxzv == null) {
      return;
    }
    paramaxzv.detachObserver();
    paramaxzv.activeStateChanged(false);
  }
  
  public void g(@NonNull axzf paramaxzf)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((axzt.c)localEntry.getValue()).a(paramaxzf)) {
        b((axzv)localEntry.getKey());
      }
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
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(T paramT)
  {
    synchronized (this.mDataLock)
    {
      int i;
      if (this.mPendingData == NOT_SET)
      {
        i = 1;
        this.mPendingData = paramT;
        if (i == 0) {
          QLog.d("debug", 4, "!postTask");
        }
      }
      else
      {
        i = 0;
      }
    }
    axzl.a().postToMainThread(this.mPostValueRunnable);
  }
  
  public void setValue(T paramT)
  {
    assertMainThread("setValue");
    this.mVersion += 1;
    this.mData = paramT;
    b(null);
  }
  
  class a
    extends axzt<T>.c
  {
    a()
    {
      super(localaxzv);
    }
    
    boolean shouldBeActive()
    {
      return true;
    }
  }
  
  class b
    extends axzt<T>.c
    implements axzc
  {
    @NonNull
    final axzf b;
    
    b(@NonNull axzv<? super T> paramaxzv)
    {
      super(localaxzv);
      this.b = paramaxzv;
    }
    
    public void a(axzf paramaxzf, axzd.a parama)
    {
      if (this.b.a().a() == axzd.b.a)
      {
        axzt.this.b(this.c);
        return;
      }
      activeStateChanged(shouldBeActive());
    }
    
    boolean a(axzf paramaxzf)
    {
      return this.b == paramaxzf;
    }
    
    void detachObserver()
    {
      this.b.a().b(this);
    }
    
    boolean shouldBeActive()
    {
      return this.b.a().a().a(axzd.b.d);
    }
  }
  
  abstract class c
  {
    final axzv<? super T> c;
    boolean mActive;
    int mLastVersion = -1;
    
    c()
    {
      Object localObject;
      this.c = localObject;
    }
    
    boolean a(axzf paramaxzf)
    {
      return false;
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
      axzt localaxzt;
      int k;
      if (axzt.a(axzt.this) == 0)
      {
        i = 1;
        localaxzt = axzt.this;
        k = axzt.a(localaxzt);
        if (!this.mActive) {
          break label121;
        }
      }
      for (;;)
      {
        axzt.a(localaxzt, j + k);
        if ((i != 0) && (this.mActive)) {
          axzt.this.onActive();
        }
        if ((axzt.a(axzt.this) == 0) && (!this.mActive)) {
          axzt.this.onInactive();
        }
        if (!this.mActive) {
          break;
        }
        axzt.a(axzt.this, this);
        return;
        i = 0;
        break label28;
        label121:
        j = -1;
      }
    }
    
    void detachObserver() {}
    
    abstract boolean shouldBeActive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzt
 * JD-Core Version:    0.7.0.1
 */