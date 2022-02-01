package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible
public final class Suppliers
{
  public static <F, T> Supplier<T> compose(Function<? super F, T> paramFunction, Supplier<F> paramSupplier)
  {
    Preconditions.checkNotNull(paramFunction);
    Preconditions.checkNotNull(paramSupplier);
    return new SupplierComposition(paramFunction, paramSupplier);
  }
  
  public static <T> Supplier<T> memoize(Supplier<T> paramSupplier)
  {
    if ((paramSupplier instanceof MemoizingSupplier)) {
      return paramSupplier;
    }
    return new MemoizingSupplier((Supplier)Preconditions.checkNotNull(paramSupplier));
  }
  
  public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit)
  {
    return new ExpiringMemoizingSupplier(paramSupplier, paramLong, paramTimeUnit);
  }
  
  public static <T> Supplier<T> ofInstance(@Nullable T paramT)
  {
    return new SupplierOfInstance(paramT);
  }
  
  public static <T> Function<Supplier<T>, T> supplierFunction()
  {
    return SupplierFunctionImpl.INSTANCE;
  }
  
  public static <T> Supplier<T> synchronizedSupplier(Supplier<T> paramSupplier)
  {
    return new ThreadSafeSupplier((Supplier)Preconditions.checkNotNull(paramSupplier));
  }
  
  @VisibleForTesting
  static class ExpiringMemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    final long durationNanos;
    volatile transient long expirationNanos;
    volatile transient T value;
    
    ExpiringMemoizingSupplier(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit)
    {
      this.delegate = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      this.durationNanos = paramTimeUnit.toNanos(paramLong);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        return;
      }
    }
    
    public T get()
    {
      long l1 = this.expirationNanos;
      long l2 = Platform.systemNanoTime();
      if ((l1 == 0L) || (l2 - l1 >= 0L)) {}
      try
      {
        if (l1 == this.expirationNanos)
        {
          Object localObject1 = this.delegate.get();
          this.value = localObject1;
          l2 += this.durationNanos;
          l1 = l2;
          if (l2 == 0L) {
            l1 = 1L;
          }
          this.expirationNanos = l1;
          return localObject1;
        }
        return this.value;
      }
      finally {}
    }
    
    public String toString()
    {
      return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
    }
  }
  
  @VisibleForTesting
  static class MemoizingSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    volatile transient boolean initialized;
    transient T value;
    
    MemoizingSupplier(Supplier<T> paramSupplier)
    {
      this.delegate = paramSupplier;
    }
    
    public T get()
    {
      if (!this.initialized) {}
      try
      {
        if (!this.initialized)
        {
          Object localObject1 = this.delegate.get();
          this.value = localObject1;
          this.initialized = true;
          return localObject1;
        }
        return this.value;
      }
      finally {}
    }
    
    public String toString()
    {
      return "Suppliers.memoize(" + this.delegate + ")";
    }
  }
  
  static class SupplierComposition<F, T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Function<? super F, T> function;
    final Supplier<F> supplier;
    
    SupplierComposition(Function<? super F, T> paramFunction, Supplier<F> paramSupplier)
    {
      this.function = paramFunction;
      this.supplier = paramSupplier;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof SupplierComposition))
      {
        paramObject = (SupplierComposition)paramObject;
        bool1 = bool2;
        if (this.function.equals(paramObject.function))
        {
          bool1 = bool2;
          if (this.supplier.equals(paramObject.supplier)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public T get()
    {
      return this.function.apply(this.supplier.get());
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.function, this.supplier });
    }
    
    public String toString()
    {
      return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
    }
  }
  
  static abstract interface SupplierFunction<T>
    extends Function<Supplier<T>, T>
  {}
  
  static enum SupplierFunctionImpl
    implements Suppliers.SupplierFunction<Object>
  {
    INSTANCE;
    
    private SupplierFunctionImpl() {}
    
    public Object apply(Supplier<Object> paramSupplier)
    {
      return paramSupplier.get();
    }
    
    public String toString()
    {
      return "Suppliers.supplierFunction()";
    }
  }
  
  static class SupplierOfInstance<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final T instance;
    
    SupplierOfInstance(@Nullable T paramT)
    {
      this.instance = paramT;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof SupplierOfInstance))
      {
        paramObject = (SupplierOfInstance)paramObject;
        return Objects.equal(this.instance, paramObject.instance);
      }
      return false;
    }
    
    public T get()
    {
      return this.instance;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { this.instance });
    }
    
    public String toString()
    {
      return "Suppliers.ofInstance(" + this.instance + ")";
    }
  }
  
  static class ThreadSafeSupplier<T>
    implements Supplier<T>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Supplier<T> delegate;
    
    ThreadSafeSupplier(Supplier<T> paramSupplier)
    {
      this.delegate = paramSupplier;
    }
    
    public T get()
    {
      synchronized (this.delegate)
      {
        Object localObject1 = this.delegate.get();
        return localObject1;
      }
    }
    
    public String toString()
    {
      return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Suppliers
 * JD-Core Version:    0.7.0.1
 */