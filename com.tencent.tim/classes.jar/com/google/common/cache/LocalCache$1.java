package com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$1
  implements LocalCache.ValueReference<Object, Object>
{
  public LocalCache.ValueReference<Object, Object> copyFor(ReferenceQueue<Object> paramReferenceQueue, @Nullable Object paramObject, LocalCache.ReferenceEntry<Object, Object> paramReferenceEntry)
  {
    return this;
  }
  
  public Object get()
  {
    return null;
  }
  
  public LocalCache.ReferenceEntry<Object, Object> getEntry()
  {
    return null;
  }
  
  public int getWeight()
  {
    return 0;
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  public boolean isLoading()
  {
    return false;
  }
  
  public void notifyNewValue(Object paramObject) {}
  
  public Object waitForValue()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.1
 * JD-Core Version:    0.7.0.1
 */