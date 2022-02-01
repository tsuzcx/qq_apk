package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class MethodSorter
{
  public static final Comparator<Method> DEFAULT = new MethodSorter.1();
  public static final Comparator<Method> NAME_ASCENDING = new MethodSorter.2();
  
  public static Method[] getDeclaredMethods(Class<?> paramClass)
  {
    Comparator localComparator = getSorter((FixMethodOrder)paramClass.getAnnotation(FixMethodOrder.class));
    paramClass = paramClass.getDeclaredMethods();
    if (localComparator != null) {
      Arrays.sort(paramClass, localComparator);
    }
    return paramClass;
  }
  
  private static Comparator<Method> getSorter(FixMethodOrder paramFixMethodOrder)
  {
    if (paramFixMethodOrder == null) {
      return DEFAULT;
    }
    return paramFixMethodOrder.value().getComparator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.MethodSorter
 * JD-Core Version:    0.7.0.1
 */