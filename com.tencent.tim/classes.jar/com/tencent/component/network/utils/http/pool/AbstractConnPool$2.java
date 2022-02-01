package com.tencent.component.network.utils.http.pool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;

class AbstractConnPool$2
  extends PoolEntryFuture<E>
{
  AbstractConnPool$2(AbstractConnPool paramAbstractConnPool, Lock paramLock, FutureCallback paramFutureCallback, Object paramObject1, Object paramObject2)
  {
    super(paramLock, paramFutureCallback);
  }
  
  public E getPoolEntry(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException, IOException
  {
    return AbstractConnPool.access$000(this.this$0, this.val$route, this.val$state, paramLong, paramTimeUnit, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.AbstractConnPool.2
 * JD-Core Version:    0.7.0.1
 */