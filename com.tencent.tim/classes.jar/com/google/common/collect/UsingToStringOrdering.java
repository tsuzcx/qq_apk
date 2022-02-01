package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable=true)
final class UsingToStringOrdering
  extends Ordering<Object>
  implements Serializable
{
  static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
  private static final long serialVersionUID = 0L;
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString());
  }
  
  public String toString()
  {
    return "Ordering.usingToString()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.UsingToStringOrdering
 * JD-Core Version:    0.7.0.1
 */