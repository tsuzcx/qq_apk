package com.tencent.qqmail.trd.guava;

import java.util.Collection;
import java.util.HashSet;

public class Sets
{
  public static <T> HashSet<T> newHashSet()
  {
    return new HashSet();
  }
  
  public static <T> HashSet<T> newHashSet(Collection<T> paramCollection)
  {
    return new HashSet(paramCollection);
  }
  
  public static <T> HashSet<T> newHashSet(T... paramVarArgs)
  {
    HashSet localHashSet = new HashSet();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramVarArgs[i]);
      i += 1;
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.guava.Sets
 * JD-Core Version:    0.7.0.1
 */