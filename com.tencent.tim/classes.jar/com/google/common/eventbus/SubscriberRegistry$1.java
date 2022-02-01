package com.google.common.eventbus;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Method;

final class SubscriberRegistry$1
  extends CacheLoader<Class<?>, ImmutableList<Method>>
{
  public ImmutableList<Method> load(Class<?> paramClass)
    throws Exception
  {
    return SubscriberRegistry.access$000(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.SubscriberRegistry.1
 * JD-Core Version:    0.7.0.1
 */