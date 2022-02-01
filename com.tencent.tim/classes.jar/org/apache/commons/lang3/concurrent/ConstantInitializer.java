package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.ObjectUtils;

public class ConstantInitializer<T>
  implements ConcurrentInitializer<T>
{
  private static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
  private final T object;
  
  public ConstantInitializer(T paramT)
  {
    this.object = paramT;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ConstantInitializer)) {
      return false;
    }
    paramObject = (ConstantInitializer)paramObject;
    return ObjectUtils.equals(getObject(), paramObject.getObject());
  }
  
  public T get()
    throws ConcurrentException
  {
    return getObject();
  }
  
  public final T getObject()
  {
    return this.object;
  }
  
  public int hashCode()
  {
    if (getObject() != null) {
      return getObject().hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return String.format("ConstantInitializer@%d [ object = %s ]", new Object[] { Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.ConstantInitializer
 * JD-Core Version:    0.7.0.1
 */