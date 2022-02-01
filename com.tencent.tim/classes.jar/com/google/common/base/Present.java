package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Present<T>
  extends Optional<T>
{
  private static final long serialVersionUID = 0L;
  private final T reference;
  
  Present(T paramT)
  {
    this.reference = paramT;
  }
  
  public Set<T> asSet()
  {
    return Collections.singleton(this.reference);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof Present))
    {
      paramObject = (Present)paramObject;
      return this.reference.equals(paramObject.reference);
    }
    return false;
  }
  
  public T get()
  {
    return this.reference;
  }
  
  public int hashCode()
  {
    return 1502476572 + this.reference.hashCode();
  }
  
  public boolean isPresent()
  {
    return true;
  }
  
  public Optional<T> or(Optional<? extends T> paramOptional)
  {
    Preconditions.checkNotNull(paramOptional);
    return this;
  }
  
  public T or(Supplier<? extends T> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    return this.reference;
  }
  
  public T or(T paramT)
  {
    Preconditions.checkNotNull(paramT, "use Optional.orNull() instead of Optional.or(null)");
    return this.reference;
  }
  
  public T orNull()
  {
    return this.reference;
  }
  
  public String toString()
  {
    return "Optional.of(" + this.reference + ")";
  }
  
  public <V> Optional<V> transform(Function<? super T, V> paramFunction)
  {
    return new Present(Preconditions.checkNotNull(paramFunction.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Present
 * JD-Core Version:    0.7.0.1
 */