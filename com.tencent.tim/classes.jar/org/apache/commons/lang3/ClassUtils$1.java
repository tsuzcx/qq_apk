package org.apache.commons.lang3;

import java.util.Iterator;
import org.apache.commons.lang3.mutable.MutableObject;

final class ClassUtils$1
  implements Iterable<Class<?>>
{
  ClassUtils$1(Class paramClass) {}
  
  public Iterator<Class<?>> iterator()
  {
    return new ClassUtils.1.1(this, new MutableObject(this.val$type));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.ClassUtils.1
 * JD-Core Version:    0.7.0.1
 */