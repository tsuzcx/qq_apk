package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
public abstract class AbstractLoadingCache<K, V>
  extends AbstractCache<K, V>
  implements LoadingCache<K, V>
{
  public final V apply(K paramK)
  {
    return getUnchecked(paramK);
  }
  
  public ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable)
    throws ExecutionException
  {
    LinkedHashMap localLinkedHashMap = Maps.newLinkedHashMap();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, get(localObject));
      }
    }
    return ImmutableMap.copyOf(localLinkedHashMap);
  }
  
  public V getUnchecked(K paramK)
  {
    try
    {
      paramK = get(paramK);
      return paramK;
    }
    catch (ExecutionException paramK)
    {
      throw new UncheckedExecutionException(paramK.getCause());
    }
  }
  
  public void refresh(K paramK)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.AbstractLoadingCache
 * JD-Core Version:    0.7.0.1
 */