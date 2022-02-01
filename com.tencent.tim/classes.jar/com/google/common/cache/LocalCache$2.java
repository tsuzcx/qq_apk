package com.google.common.cache;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$2
  extends AbstractQueue<Object>
{
  public Iterator<Object> iterator()
  {
    return ImmutableSet.of().iterator();
  }
  
  public boolean offer(Object paramObject)
  {
    return true;
  }
  
  public Object peek()
  {
    return null;
  }
  
  public Object poll()
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.2
 * JD-Core Version:    0.7.0.1
 */