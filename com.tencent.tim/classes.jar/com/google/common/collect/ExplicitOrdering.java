package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ExplicitOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableMap<T, Integer> rankMap;
  
  ExplicitOrdering(ImmutableMap<T, Integer> paramImmutableMap)
  {
    this.rankMap = paramImmutableMap;
  }
  
  ExplicitOrdering(List<T> paramList)
  {
    this(Maps.indexMap(paramList));
  }
  
  private int rank(T paramT)
  {
    Integer localInteger = (Integer)this.rankMap.get(paramT);
    if (localInteger == null) {
      throw new Ordering.IncomparableValueException(paramT);
    }
    return localInteger.intValue();
  }
  
  public int compare(T paramT1, T paramT2)
  {
    return rank(paramT1) - rank(paramT2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ExplicitOrdering))
    {
      paramObject = (ExplicitOrdering)paramObject;
      return this.rankMap.equals(paramObject.rankMap);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.rankMap.hashCode();
  }
  
  public String toString()
  {
    return "Ordering.explicit(" + this.rankMap.keySet() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ExplicitOrdering
 * JD-Core Version:    0.7.0.1
 */