package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;

@GwtCompatible(emulated=true)
public abstract class CacheLoader<K, V>
{
  @GwtIncompatible
  public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> paramCacheLoader, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramCacheLoader);
    Preconditions.checkNotNull(paramExecutor);
    return new CacheLoader.1(paramCacheLoader, paramExecutor);
  }
  
  public static <K, V> CacheLoader<K, V> from(Function<K, V> paramFunction)
  {
    return new FunctionToCacheLoader(paramFunction);
  }
  
  public static <V> CacheLoader<Object, V> from(Supplier<V> paramSupplier)
  {
    return new SupplierToCacheLoader(paramSupplier);
  }
  
  public abstract V load(K paramK)
    throws Exception;
  
  public Map<K, V> loadAll(Iterable<? extends K> paramIterable)
    throws Exception
  {
    throw new UnsupportedLoadingOperationException();
  }
  
  @GwtIncompatible
  public ListenableFuture<V> reload(K paramK, V paramV)
    throws Exception
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    return Futures.immediateFuture(load(paramK));
  }
  
  static final class FunctionToCacheLoader<K, V>
    extends CacheLoader<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Function<K, V> computingFunction;
    
    public FunctionToCacheLoader(Function<K, V> paramFunction)
    {
      this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public V load(K paramK)
    {
      return this.computingFunction.apply(Preconditions.checkNotNull(paramK));
    }
  }
  
  public static final class InvalidCacheLoadException
    extends RuntimeException
  {
    public InvalidCacheLoadException(String paramString)
    {
      super();
    }
  }
  
  static final class SupplierToCacheLoader<V>
    extends CacheLoader<Object, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Supplier<V> computingSupplier;
    
    public SupplierToCacheLoader(Supplier<V> paramSupplier)
    {
      this.computingSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    public V load(Object paramObject)
    {
      Preconditions.checkNotNull(paramObject);
      return this.computingSupplier.get();
    }
  }
  
  public static final class UnsupportedLoadingOperationException
    extends UnsupportedOperationException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheLoader
 * JD-Core Version:    0.7.0.1
 */