package org.apache.commons.lang3;

import java.util.HashSet;
import java.util.Iterator;

final class ClassUtils$2
  implements Iterable<Class<?>>
{
  ClassUtils$2(Iterable paramIterable) {}
  
  public Iterator<Class<?>> iterator()
  {
    HashSet localHashSet = new HashSet();
    return new ClassUtils.2.1(this, this.val$classes.iterator(), localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.ClassUtils.2
 * JD-Core Version:    0.7.0.1
 */