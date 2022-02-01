package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ByFunctionOrdering<F, T>
  extends Ordering<F>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Function<F, ? extends T> function;
  final Ordering<T> ordering;
  
  ByFunctionOrdering(Function<F, ? extends T> paramFunction, Ordering<T> paramOrdering)
  {
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    this.ordering = ((Ordering)Preconditions.checkNotNull(paramOrdering));
  }
  
  public int compare(F paramF1, F paramF2)
  {
    return this.ordering.compare(this.function.apply(paramF1), this.function.apply(paramF2));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ByFunctionOrdering)) {
        break;
      }
      paramObject = (ByFunctionOrdering)paramObject;
    } while ((this.function.equals(paramObject.function)) && (this.ordering.equals(paramObject.ordering)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.function, this.ordering });
  }
  
  public String toString()
  {
    return this.ordering + ".onResultOf(" + this.function + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ByFunctionOrdering
 * JD-Core Version:    0.7.0.1
 */