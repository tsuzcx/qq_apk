package org.apache.commons.lang3;

import java.util.Iterator;
import org.apache.commons.lang3.mutable.MutableObject;

class ClassUtils$1$1
  implements Iterator<Class<?>>
{
  ClassUtils$1$1(ClassUtils.1 param1, MutableObject paramMutableObject) {}
  
  public boolean hasNext()
  {
    return this.val$next.getValue() != null;
  }
  
  public Class<?> next()
  {
    Class localClass = (Class)this.val$next.getValue();
    this.val$next.setValue(localClass.getSuperclass());
    return localClass;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.ClassUtils.1.1
 * JD-Core Version:    0.7.0.1
 */