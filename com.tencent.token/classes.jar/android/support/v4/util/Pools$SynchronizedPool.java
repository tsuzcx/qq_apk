package android.support.v4.util;

import android.support.annotation.NonNull;

public class Pools$SynchronizedPool
  extends Pools.SimplePool
{
  private final Object mLock = new Object();
  
  public Pools$SynchronizedPool(int paramInt)
  {
    super(paramInt);
  }
  
  public Object acquire()
  {
    synchronized (this.mLock)
    {
      Object localObject2 = super.acquire();
      return localObject2;
    }
  }
  
  public boolean release(@NonNull Object paramObject)
  {
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramObject);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.Pools.SynchronizedPool
 * JD-Core Version:    0.7.0.1
 */