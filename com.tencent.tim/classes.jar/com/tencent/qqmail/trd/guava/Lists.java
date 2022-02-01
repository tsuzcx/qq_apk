package com.tencent.qqmail.trd.guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Lists
{
  public static <T> ArrayList<T> newArrayList()
  {
    return new ArrayList();
  }
  
  public static <T> ArrayList<T> newArrayList(Collection<T> paramCollection)
  {
    return new ArrayList(paramCollection);
  }
  
  public static <T> ArrayList<T> newArrayList(T... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static <Element, Return> List<Return> transform(List<Element> paramList, Function<Element, Return> paramFunction)
  {
    ArrayList localArrayList = newArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(paramFunction.apply(paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.guava.Lists
 * JD-Core Version:    0.7.0.1
 */