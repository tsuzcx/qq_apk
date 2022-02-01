package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class Pools
{
  public static abstract interface Pool<T>
  {
    @Nullable
    public abstract T acquire();
    
    public abstract boolean release(@NonNull T paramT);
  }
  
  public static class SimplePool<T>
    implements Pools.Pool<T>
  {
    private final Object[] mPool;
    private int mPoolSize;
    
    public SimplePool(int paramInt)
    {
      if (paramInt > 0)
      {
        this.mPool = new Object[paramInt];
        return;
      }
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    
    private boolean isInPool(@NonNull T paramT)
    {
      int i = 0;
      while (i < this.mPoolSize)
      {
        if (this.mPool[i] == paramT) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public T acquire()
    {
      int i = this.mPoolSize;
      if (i > 0)
      {
        int j = i - 1;
        Object[] arrayOfObject = this.mPool;
        Object localObject = arrayOfObject[j];
        arrayOfObject[j] = null;
        this.mPoolSize = (i - 1);
        return localObject;
      }
      return null;
    }
    
    public boolean release(@NonNull T paramT)
    {
      if (!isInPool(paramT))
      {
        int i = this.mPoolSize;
        Object[] arrayOfObject = this.mPool;
        if (i < arrayOfObject.length)
        {
          arrayOfObject[i] = paramT;
          this.mPoolSize = (i + 1);
          return true;
        }
        return false;
      }
      throw new IllegalStateException("Already in the pool!");
    }
  }
  
  public static class SynchronizedPool<T>
    extends Pools.SimplePool<T>
  {
    private final Object mLock = new Object();
    
    public SynchronizedPool(int paramInt)
    {
      super();
    }
    
    public T acquire()
    {
      synchronized (this.mLock)
      {
        Object localObject2 = super.acquire();
        return localObject2;
      }
    }
    
    public boolean release(@NonNull T paramT)
    {
      synchronized (this.mLock)
      {
        boolean bool = super.release(paramT);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.Pools
 * JD-Core Version:    0.7.0.1
 */