package com.tribe.async.objectpool;

import com.tribe.async.log.SLog;
import com.tribe.async.utils.MonotonicClock;
import java.lang.reflect.Array;

public class ObjectPool<T>
{
  private static final String TAG = "async.ObjectPool";
  private final Allocator<T> mAllocator;
  private final Class<T> mClazz;
  private final MonotonicClock mClock;
  private final long mCompactionDelayMs;
  private final int mIncrementSize;
  private long mLastLowSupplyTimeMs;
  private final int mMaxSize;
  private final int mMinSize;
  private T[] mPool;
  private int mSize;
  
  public ObjectPool(Class<T> paramClass, int paramInt1, int paramInt2, int paramInt3, long paramLong, Allocator<T> paramAllocator, MonotonicClock paramMonotonicClock)
  {
    this.mClazz = paramClass;
    this.mMinSize = Math.max(paramInt1, 0);
    this.mMaxSize = Math.max(this.mMinSize, paramInt2);
    this.mIncrementSize = Math.max(paramInt3, 1);
    this.mCompactionDelayMs = paramLong;
    this.mAllocator = paramAllocator;
    this.mClock = paramMonotonicClock;
    this.mPool = ((Object[])Array.newInstance(this.mClazz, this.mMinSize));
  }
  
  private void resizePool(int paramInt)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(this.mClazz, paramInt);
    System.arraycopy(this.mPool, 0, arrayOfObject, 0, Math.min(this.mPool.length, paramInt));
    this.mPool = arrayOfObject;
    this.mSize = Math.min(this.mSize, paramInt);
  }
  
  /* Error */
  public T allocate()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/tribe/async/objectpool/ObjectPool:mSize	I
    //   6: ifle +47 -> 53
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 84	com/tribe/async/objectpool/ObjectPool:mSize	I
    //   14: iconst_1
    //   15: isub
    //   16: putfield 84	com/tribe/async/objectpool/ObjectPool:mSize	I
    //   19: aload_0
    //   20: getfield 68	com/tribe/async/objectpool/ObjectPool:mPool	[Ljava/lang/Object;
    //   23: aload_0
    //   24: getfield 84	com/tribe/async/objectpool/ObjectPool:mSize	I
    //   27: aaload
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 68	com/tribe/async/objectpool/ObjectPool:mPool	[Ljava/lang/Object;
    //   33: aload_0
    //   34: getfield 84	com/tribe/async/objectpool/ObjectPool:mSize	I
    //   37: aconst_null
    //   38: aastore
    //   39: aload_0
    //   40: getfield 57	com/tribe/async/objectpool/ObjectPool:mAllocator	Lcom/tribe/async/objectpool/ObjectPool$Allocator;
    //   43: aload_1
    //   44: invokeinterface 90 2 0
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: getfield 57	com/tribe/async/objectpool/ObjectPool:mAllocator	Lcom/tribe/async/objectpool/ObjectPool$Allocator;
    //   57: invokeinterface 93 1 0
    //   62: astore_1
    //   63: goto -24 -> 39
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	ObjectPool
    //   28	35	1	localObject1	Object
    //   66	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	39	66	finally
    //   39	49	66	finally
    //   53	63	66	finally
  }
  
  public void checkUsage()
  {
    try
    {
      long l = this.mClock.now();
      if (this.mSize < this.mIncrementSize * 2) {
        this.mLastLowSupplyTimeMs = l;
      }
      if (l - this.mLastLowSupplyTimeMs > this.mCompactionDelayMs)
      {
        SLog.d("async.ObjectPool", "ObjectPool.checkUsage is compacting the pool.");
        compactUsage();
      }
      return;
    }
    finally {}
  }
  
  public void compactUsage()
  {
    try
    {
      int i = Math.max(this.mPool.length - this.mIncrementSize, this.mMinSize);
      if (i != this.mPool.length) {
        resizePool(i);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getCompactionDelayMs()
  {
    return this.mCompactionDelayMs;
  }
  
  public int getIncrementSize()
  {
    return this.mIncrementSize;
  }
  
  public int getMaximumSize()
  {
    return this.mMaxSize;
  }
  
  public int getMinimumSize()
  {
    return this.mMinSize;
  }
  
  public int getPoolSize()
  {
    return this.mPool.length;
  }
  
  public int getPooledObjectCount()
  {
    return this.mSize;
  }
  
  public void release(T paramT)
  {
    try
    {
      checkUsage();
      this.mAllocator.onRelease(paramT);
      if (this.mSize < this.mMaxSize)
      {
        if (this.mSize + 1 > this.mPool.length) {
          resizePool(Math.min(this.mMaxSize, this.mPool.length + this.mIncrementSize));
        }
        Object[] arrayOfObject = this.mPool;
        int i = this.mSize;
        this.mSize = (i + 1);
        arrayOfObject[i] = paramT;
      }
      return;
    }
    finally {}
  }
  
  public static abstract interface Allocator<T>
  {
    public abstract T create();
    
    public abstract void onAllocate(T paramT);
    
    public abstract void onRelease(T paramT);
  }
  
  public static class BasicAllocator<T>
    implements ObjectPool.Allocator<T>
  {
    Class<T> mClazz;
    
    public BasicAllocator(Class<T> paramClass)
    {
      this.mClazz = paramClass;
    }
    
    public T create()
    {
      try
      {
        Object localObject = this.mClazz.newInstance();
        return localObject;
      }
      catch (InstantiationException localInstantiationException)
      {
        SLog.e("async.ObjectPool", "Couldn't instantiate object", localInstantiationException);
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          SLog.e("async.ObjectPool", "Couldn't instantiate object", localIllegalAccessException);
        }
      }
    }
    
    public void onAllocate(T paramT) {}
    
    public void onRelease(T paramT) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.objectpool.ObjectPool
 * JD-Core Version:    0.7.0.1
 */