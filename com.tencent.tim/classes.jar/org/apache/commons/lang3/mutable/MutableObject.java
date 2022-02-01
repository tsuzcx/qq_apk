package org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableObject<T>
  implements Serializable, Mutable<T>
{
  private static final long serialVersionUID = 86241875189L;
  private T value;
  
  public MutableObject() {}
  
  public MutableObject(T paramT)
  {
    this.value = paramT;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (getClass() != paramObject.getClass());
    paramObject = (MutableObject)paramObject;
    return this.value.equals(paramObject.value);
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    if (this.value == null) {
      return 0;
    }
    return this.value.hashCode();
  }
  
  public void setValue(T paramT)
  {
    this.value = paramT;
  }
  
  public String toString()
  {
    if (this.value == null) {
      return "null";
    }
    return this.value.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.mutable.MutableObject
 * JD-Core Version:    0.7.0.1
 */