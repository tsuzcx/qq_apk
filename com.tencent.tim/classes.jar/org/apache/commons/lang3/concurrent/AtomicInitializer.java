package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T>
  implements ConcurrentInitializer<T>
{
  private final AtomicReference<T> reference = new AtomicReference();
  
  public T get()
    throws ConcurrentException
  {
    Object localObject2 = this.reference.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = initialize();
      localObject1 = localObject2;
      if (!this.reference.compareAndSet(null, localObject2)) {
        localObject1 = this.reference.get();
      }
    }
    return localObject1;
  }
  
  protected abstract T initialize()
    throws ConcurrentException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.AtomicInitializer
 * JD-Core Version:    0.7.0.1
 */