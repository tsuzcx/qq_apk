package com.google.common.eventbus;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import com.google.common.reflect.TypeToken.TypeSet;

final class SubscriberRegistry$2
  extends CacheLoader<Class<?>, ImmutableSet<Class<?>>>
{
  public ImmutableSet<Class<?>> load(Class<?> paramClass)
  {
    return ImmutableSet.copyOf(TypeToken.of(paramClass).getTypes().rawTypes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.eventbus.SubscriberRegistry.2
 * JD-Core Version:    0.7.0.1
 */