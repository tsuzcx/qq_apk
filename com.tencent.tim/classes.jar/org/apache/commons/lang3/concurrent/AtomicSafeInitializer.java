package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicSafeInitializer<T>
  implements ConcurrentInitializer<T>
{
  private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference();
  private final AtomicReference<T> reference = new AtomicReference();
  
  public final T get()
    throws ConcurrentException
  {
    Object localObject;
    for (;;)
    {
      localObject = this.reference.get();
      if (localObject != null) {
        break;
      }
      if (this.factory.compareAndSet(null, this)) {
        this.reference.set(initialize());
      }
    }
    return localObject;
  }
  
  protected abstract T initialize()
    throws ConcurrentException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.AtomicSafeInitializer
 * JD-Core Version:    0.7.0.1
 */