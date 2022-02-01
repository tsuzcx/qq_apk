package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.NoSuchElementException;

public final class Optional<T>
{
  private static final Optional<?> EMPTY = new Optional();
  private final T value;
  
  private Optional()
  {
    this.value = null;
  }
  
  private Optional(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    this.value = paramT;
  }
  
  public static <T> Optional<T> empty()
  {
    return EMPTY;
  }
  
  public static <T> Optional<T> of(T paramT)
  {
    return new Optional(paramT);
  }
  
  public static <T> Optional<T> ofNullable(T paramT)
  {
    if (paramT == null) {
      return empty();
    }
    return of(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Optional)) {
        return false;
      }
      paramObject = (Optional)paramObject;
      if (this.value != null) {
        break;
      }
    } while (paramObject.value == null);
    return false;
    return this.value.equals(paramObject.value);
  }
  
  public Optional<T> filter(Predicate<? super T> paramPredicate)
  {
    AssertUtils.checkNotNull(paramPredicate);
    if (!isPresent()) {}
    while (paramPredicate.test(this.value)) {
      return this;
    }
    return empty();
  }
  
  public <U> Optional<U> flatMap(Function<? super T, Optional<U>> paramFunction)
  {
    AssertUtils.checkNotNull(paramFunction);
    if (!isPresent()) {
      return empty();
    }
    paramFunction = (Optional)paramFunction.apply(this.value);
    AssertUtils.checkNotNull(paramFunction);
    return paramFunction;
  }
  
  public T get()
  {
    if (this.value == null) {
      throw new NoSuchElementException("No value present");
    }
    return this.value;
  }
  
  public int hashCode()
  {
    if (this.value == null) {
      return 0;
    }
    return this.value.hashCode();
  }
  
  public void ifPresent(Consumer<? super T> paramConsumer)
  {
    if (this.value != null) {
      paramConsumer.accept(this.value);
    }
  }
  
  public boolean isPresent()
  {
    return this.value != null;
  }
  
  public <U> Optional<U> map(Function<T, U> paramFunction)
  {
    AssertUtils.checkNotNull(paramFunction);
    if (!isPresent()) {
      return empty();
    }
    return ofNullable(paramFunction.apply(this.value));
  }
  
  public T orElse(T paramT)
  {
    if (this.value != null) {
      paramT = this.value;
    }
    return paramT;
  }
  
  public T orElseGet(Supplier<? extends T> paramSupplier)
  {
    if (this.value != null) {
      return this.value;
    }
    return paramSupplier.get();
  }
  
  public <X extends Throwable> T orElseThrow(Supplier<? extends X> paramSupplier)
    throws Throwable
  {
    if (this.value != null) {
      return this.value;
    }
    throw ((Throwable)paramSupplier.get());
  }
  
  public String toString()
  {
    if (this.value != null) {
      return String.format("Optional[%s]", new Object[] { this.value });
    }
    return "Optional.empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.reactive.Optional
 * JD-Core Version:    0.7.0.1
 */