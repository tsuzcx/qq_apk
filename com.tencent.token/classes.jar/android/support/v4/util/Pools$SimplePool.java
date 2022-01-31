package android.support.v4.util;

import android.support.annotation.NonNull;

public class Pools$SimplePool
  implements Pools.Pool
{
  private final Object[] mPool;
  private int mPoolSize;
  
  public Pools$SimplePool(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.mPool = new Object[paramInt];
  }
  
  private boolean isInPool(@NonNull Object paramObject)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mPoolSize)
      {
        if (this.mPool[i] == paramObject) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public Object acquire()
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
  
  public boolean release(@NonNull Object paramObject)
  {
    if (isInPool(paramObject)) {
      throw new IllegalStateException("Already in the pool!");
    }
    if (this.mPoolSize < this.mPool.length)
    {
      this.mPool[this.mPoolSize] = paramObject;
      this.mPoolSize += 1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.Pools.SimplePool
 * JD-Core Version:    0.7.0.1
 */