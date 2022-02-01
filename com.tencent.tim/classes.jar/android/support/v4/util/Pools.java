package android.support.v4.util;

public final class Pools
{
  public static abstract interface Pool<T>
  {
    public abstract T acquire();
    
    public abstract boolean release(T paramT);
  }
  
  public static class SimplePool<T>
    implements Pools.Pool<T>
  {
    private final Object[] mPool;
    private int mPoolSize;
    
    public SimplePool(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("The max pool size must be > 0");
      }
      this.mPool = new Object[paramInt];
    }
    
    private boolean isInPool(T paramT)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.mPoolSize)
        {
          if (this.mPool[i] == paramT) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public T acquire()
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        Object localObject = this.mPool[i];
        this.mPool[i] = null;
        this.mPoolSize -= 1;
        return localObject;
      }
      return null;
    }
    
    public boolean release(T paramT)
    {
      if (isInPool(paramT)) {
        throw new IllegalStateException("Already in the pool!");
      }
      if (this.mPoolSize < this.mPool.length)
      {
        this.mPool[this.mPoolSize] = paramT;
        this.mPoolSize += 1;
        return true;
      }
      return false;
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
    
    public boolean release(T paramT)
    {
      synchronized (this.mLock)
      {
        boolean bool = super.release(paramT);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.util.Pools
 * JD-Core Version:    0.7.0.1
 */