package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

final class Collections2$1
  implements Function<Object, Object>
{
  Collections2$1(Collection paramCollection) {}
  
  public Object apply(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == this.val$collection) {
      localObject = "(this Collection)";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Collections2.1
 * JD-Core Version:    0.7.0.1
 */